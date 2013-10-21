package nl.tomsanders.game.engine;

import java.awt.Dialog.ModalityType;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	private GameBase target;
	private GameCanvas canvas;
	
	public GameWindow(GameBase target) {
		super("Aap in de boom naar drone");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(1280, 720);
		this.setResizable(false);
		
		/*this.setUndecorated(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] devices = environment.getScreenDevices();
		
		GraphicsDevice targetDevice = devices[0];
		//targetDevice.setFullScreenWindow(this);*/
		
		this.canvas = new GameCanvas(target);
		this.getContentPane().add(canvas);
	}

	public void renderFrame() {
		this.canvas.repaint();
	}

	public Rectangle getRenderBounds() {
		return this.canvas.getBounds();
	}
	
	public void showGameOverMessage() {
		JOptionPane.showMessageDialog(this, "Game Over!", "GAME OVER!", JOptionPane.PLAIN_MESSAGE);
	}
}
