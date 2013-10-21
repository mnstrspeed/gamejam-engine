package nl.tomsanders.game.egine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

@SuppressWarnings("serial")
public class DoubleBufferedCanvas extends Canvas {
	@Override
	public void repaint() {
		this.update(this.getGraphics());
	}
	
	@Override
	public void update(Graphics g) {
		Dimension canvasDimension = this.getSize();
		
		Image offscreenImage = this.createImage(
				(int)canvasDimension.getWidth(),
				(int)canvasDimension.getHeight());
		Graphics offscreenGraphics =
				offscreenImage.getGraphics();
		
		this.clear(offscreenGraphics, this.getBackground());
		this.paint(offscreenGraphics);
		
		g.drawImage(offscreenImage, 0, 0, this);
	}

	private void clear(Graphics g, Color clearColor) {
		Dimension canvasDimension = this.getSize();
		
		// Save current foreground color for later
		Color foregroundColor = g.getColor();
		
		g.setColor(clearColor);
		g.fillRect(0, 0, 
				(int)canvasDimension.getWidth(), 
				(int)canvasDimension.getHeight());
		
		// Restore color selection
		g.setColor(foregroundColor);
	}
}
