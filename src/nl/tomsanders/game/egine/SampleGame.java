package nl.tomsanders.game.egine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import nl.tomsanders.game.egine.util.Vector;

public class SampleGame extends Game {

	public class Particle {
		private Vector position;
		private Vector direction;
		private double secondsLeft;
		private boolean outsideBounds;
		
		public Particle(Vector position) {
			this.position = position;
			this.secondsLeft = 1;
			
			Random random = new Random();
			double rotation = random.nextDouble() * Math.PI * 2;
			float speedFluctuation = (float)random.nextDouble();
			
			this.direction = new Vector(
					(float)Math.cos(rotation) * 500 * speedFluctuation,
					(float)Math.sin(rotation) * 500 * speedFluctuation);
		}
		
		public void update(GameTime time, Rectangle bounds) {
			this.position = new Vector(
					this.position.getX() + this.direction.getX() * time.getSecondsElapsed(),
					this.position.getY() + this.direction.getY() * time.getSecondsElapsed());
			this.secondsLeft -= time.getSecondsElapsed();
			
			if (this.position.getX() < bounds.getX() - 50 || this.position.getX() - 50 > bounds.getMaxX() ||
					this.position.getY() < bounds.getY() - 50 || this.position.getY() - 50 > bounds.getMaxY())
				this.outsideBounds = true;
		}
		
		public void render(Graphics g) {
			if (!this.isExpired()) {
				g.setColor(new Color(1, 0, 0, 
						(float)this.secondsLeft));
				g.fillOval((int)this.position.getX(), (int)this.position.getY(), 3, 3);
			}
		}
		
		public boolean isExpired() {
			return this.secondsLeft < 0 || this.outsideBounds;
		}
	}
	
	private Vector ballPosition;
	private Vector ballDirection;
	private final int ballRadius = 50;
	
	private ArrayList<Particle> particles;
	
	public SampleGame() {
		super();
		
		this.ballPosition = new Vector(100, 100);
		this.ballDirection = new Vector(1000, 1000);
		
		this.particles = new ArrayList<Particle>();
	}
	
	@Override
	public void update(GameTime time) {
		super.update(time);
		
		this.ballPosition = new Vector(
				this.ballPosition.getX() + this.ballDirection.getX() * time.getSecondsElapsed(),
				this.ballPosition.getY() + this.ballDirection.getY() * time.getSecondsElapsed());
		
		if (this.ballPosition.getX() + ballRadius > this.getBounds().getWidth() || this.ballPosition.getX() < 0) {
			this.ballDirection = new Vector(-this.ballDirection.getX(), this.ballDirection.getY());
			
			if (this.ballPosition.getX() < 0) {
				this.launchParticles(new Vector(
						this.ballPosition.getX(), 
						this.ballPosition.getY() + (this.ballRadius / 2)));
			} else {
				this.launchParticles(new Vector(
						this.ballPosition.getX() + this.ballRadius, 
						this.ballPosition.getY() + (this.ballRadius / 2)));
			}
		}
		if (this.ballPosition.getY() + ballRadius > this.getBounds().getHeight() || this.ballPosition.getY() < 0) {
			this.ballDirection = new Vector(this.ballDirection.getX(), -this.ballDirection.getY());
			
			if (this.ballPosition.getY() < 0) {
				this.launchParticles(new Vector(
						this.ballPosition.getX() + (this.ballRadius / 2), 
						this.ballPosition.getY()));
			} else {
				this.launchParticles(new Vector(
						this.ballPosition.getX() + (this.ballRadius / 2), 
						this.ballPosition.getY() + this.ballRadius));
			}
		}
		
		for (int i = 0; i < this.particles.size(); i++) {
			if (this.particles.get(i).isExpired()) {
				this.particles.remove(i);
			} else {
				this.particles.get(i).update(time, this.getBounds());
			}
		}
	}
	
	private void launchParticles(Vector point) {
		for (int i = 0; i < 750; i++) {
			this.particles.add(new Particle(point));
		}
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
		
		g.setColor(Color.BLUE);
		g.fillOval((int)this.ballPosition.getX(), (int)this.ballPosition.getY(), 
				ballRadius, ballRadius);
		
		for (Particle particle : this.particles)
			particle.render(g);
		
		g.setColor(Color.RED);
		g.drawString("Particles: " + this.particles.size(), 20, 20);
	}
	
	public static void main(String[] args) {
		new SampleGame().start();
	}
}
