package nl.tomsanders.game.engine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;

public class GameBase {
	
	private boolean loaded;
	
	private GameLoop loop;
	private GameWindow window;
	
	public GameBase() {
		this.loaded = false;
		this.loop = new GameLoop(this);
		
		this.window = new GameWindow(this);
		this.window.setVisible(true);
	}
	
	public void start() {
	
		this.loadContent();
		this.loaded = true;
		
		this.loop.start();
	}

	public void gameOver() {
		this.stop();
	}

	public boolean isRunning() {
		return this.loop.isRunning();
	}
	
	public void prepareNextFrame(GameTime time) {
		if (time.isRunningSlow()) {
			this.window.setTitle("Running slow");
		} else {
			this.window.setTitle("Running fine");
		}
		
		this.update(time);
		this.window.renderFrame();
	}
	
	public void addKeyListener(KeyListener listener) {
		this.window.addKeyListener(listener);
	}
	
	public Rectangle getBounds() {
		return this.window.getRenderBounds();
	}
	
	public void loadContent() {
	}
	
	public void update(GameTime time) {
	}
	
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		AffineTransform transform = new AffineTransform();
		transform.translate(0,this.getBounds().getHeight());
		transform.scale(1.0, -1.0);
		g2.setTransform(transform);
	}
	
	public void renderOverlay(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setTransform(new AffineTransform());
	}

	public boolean isLoaded() {
		return this.loaded;
	}
	
	protected void stop() {
		this.loop.stop();
	}
	
}
