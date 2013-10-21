package nl.tomsanders.game.engine.util;

public class Vector {
	public final double x;
	public final double y;

	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector(Vector v) {
		this.x = v.getX();
		this.y = v.getY();
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}
	
	public boolean isZero() {
		return this.x == 0 && this.y == 0;
	}

	public Vector translate(Vector b) {
		return new Vector(this.x + b.getX(), this.y + b.getY());
	}
	
	public Vector boundedTranslate(int maxX, int maxY) {
		return new Vector(
				this.x > maxX || this.x < -maxX ? (this.x > maxX ? maxX : -maxX) : this.x,
				this.y > maxY || this.y < -maxY ? (this.y > maxY ? maxY : -maxY) : this.y);	
	}
	
	public static Vector zero() {
		return new Vector(0, 0);
	}

	public Vector scale(double scalar) {
		return new Vector(
				this.x * scalar,
				this.y * scalar);
	}
	
	public Vector multiply(Vector b) {
		return new Vector(
				this.x * b.getX(),
				this.y * b.getY());
	}
	
	@Override
	public String toString() {
		return this.x + ":" + this.y;
	}
}
