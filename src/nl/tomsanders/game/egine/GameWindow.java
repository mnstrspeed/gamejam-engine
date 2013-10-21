package nl.tomsanders.game.egine;

import java.awt.Rectangle;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	private GameCanvas canvas;
	
	public GameWindow(Renderable target) {
		super("Game");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(1280, 720);
		
		this.canvas = new GameCanvas(target);
		this.getContentPane().add(canvas);
	}

	public void renderFrame() {
		this.canvas.repaint();
	}

	public Rectangle getRenderBounds() {
		return this.canvas.getBounds();
	}
}
