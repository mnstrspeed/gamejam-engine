package nl.tomsanders.game.egine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

@SuppressWarnings("serial")
public class GameCanvas extends DoubleBufferedCanvas {
	private Renderable target;
	
	public GameCanvas(Renderable target) {
		this.target = target;
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		this.target.render(g2);
	}
}
