package nl.tomsanders.game.engine;

import game.Level;
import game.objects.Player;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyListener;

public class Game{
	
	private GameLoop loop;
	private GameWindow window;
	
	public Game(GameWindow window) {
		this.window = window;
		this.window.setVisible(true);
		this.loop = new GameLoop(this);
	}
	
	public void start() {
		this.loop.start();
	}
	
	public void addKeyListener(KeyListener listener) {
		this.window.addKeyListener(listener);
	}
	
	public void removeKeyListener(KeyListener listener) {
		this.window.removeKeyListener(listener);
	}

	public boolean isRunning() {
		return this.loop.isRunning();
	}
	
	public void prepareNextFrame(GameTime time) {
		this.update(time);
		this.window.renderFrame();
	}
	
	public Rectangle getBounds() {
		return this.window.getRenderBounds();
	}
	
	public void update(GameTime time) {
		System.out.println("Game.update");
	}
	
	public void render(Graphics2D g, Level level) {
		System.out.println("Game.render");
		window.render(g, level);
	}
	
	public void render(Graphics2D g) {
	}
	
	public void setLevel(Level level) {
	}
	
}
