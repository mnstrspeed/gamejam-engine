package nl.tomsanders.game.engine;

import game.Game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import nl.tomsanders.game.engine.util.Size;

@SuppressWarnings("serial")
public class GameCanvas extends DoubleBufferedCanvas {
	public static final String[] backgroundImgFiles = new String[] {"res/img/backg1.png", "res/img/backg2.png", "res/img/backg3.png", "res/img/backg4.png", "res/img/backg4.png", "res/img/backg4.png"};
	
	private GameBase target;
	private BufferedImage[] backgroundImgs;
	private ArrayList<Integer> randomBackgroundImgs;
	
	public GameCanvas(GameBase target) {
		this.target = target;
		this.backgroundImgs = new BufferedImage[GameCanvas.backgroundImgFiles.length];
		for(int i=0; i<backgroundImgFiles.length; i++) {
			try {
				System.out.println("Try to load: "+ GameCanvas.backgroundImgFiles[i]);
				this.backgroundImgs[i] = ImageIO.read(new File(GameCanvas.backgroundImgFiles[i]));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.randomBackgroundImgs = new ArrayList<Integer>();
		System.out.println(getWidth() + " : " + getHeight());
		for(int w=0; w<=8192; w += 128) {
			for(int h=0; h<=8192; h += 128) {
				this.randomBackgroundImgs.add((int)(Math.random() * this.backgroundImgs.length));
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		if (this.target.isLoaded()) {	
			this.paintBackground(g2);
			this.target.render(g2);
			
			g2.setTransform(new AffineTransform());
			this.target.renderOverlay(g2);
		}
	}
	
	private void paintBackground(Graphics2D g) {
		int i = 0;
		for(int w=0; w<=this.getWidth(); w += 128) {
			for(int h=0; h<=this.getHeight(); h += 128) {
				g.drawImage(this.backgroundImgs[this.randomBackgroundImgs.get(i)], w, h, 128, (int) 128, null);
				i++;
			}
		}
	}
}
