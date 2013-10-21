package nl.tomsanders.game.engine.util;

public class Size {
	private final double width;
	private final double height;
	
	public Size(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public Size(Size size) {
		this.width = size.getWidth();
		this.height = size.getHeight();
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	@Override
	public String toString() {
		return this.width + "x" + this.height;
	}
}
