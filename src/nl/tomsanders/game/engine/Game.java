package nl.tomsanders.game.egine;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Game implements Renderable {
	
	private GameLoop loop;
	private GameWindow window;
	
	public Game() {
		this.loop = new GameLoop(this);
		
		this.window = new GameWindow(this);
		this.window.setVisible(true);
	}
	
	public void start() {
		this.loadContent();
		this.loop.start();
	}

	public boolean isRunning() {
		return this.loop.isRunning();
	}
	
	public void prepareNextFrame(GameTime time) {
		if (time.isRunningSlow())
			this.window.setTitle("Running slow");
		
		this.updateInputs();
		this.update(time);
		this.window.renderFrame();
	}
	
	public Rectangle getBounds() {
		return this.window.getRenderBounds();
	}
	
	private void loadContent() {
	}
	
	private void updateInputs() {	
	}
	
	public void update(GameTime time) {
	}
	
	public void render(Graphics g) {
	}
	
}
