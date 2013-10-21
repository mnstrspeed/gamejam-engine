package nl.tomsanders.game.egine;

public class GameTime {
	private final long systemTime;
	private final long timeElapsed;
	private final boolean runningSlow;
	
	public GameTime() {
		this.systemTime = System.currentTimeMillis();
		this.timeElapsed = 0;
		this.runningSlow = false;
	}
	
	public GameTime(GameTime previous) {
		this(previous, false);
	}
	
	public GameTime(GameTime previous, boolean runningSlow) {
		this.systemTime = System.currentTimeMillis();
		this.timeElapsed = this.systemTime - previous.getSystemTime();
		this.runningSlow = runningSlow;
	}
	
	public long getSystemTime() {
		return this.systemTime;
	}
	
	public long getTimeElapsed() {
		return this.timeElapsed;
	}
	
	public boolean isRunningSlow() {
		return this.runningSlow;
	}
	
	public double getSecondsElapsed() {
		return this.timeElapsed / 1000d;
	}
}
