package nl.tomsanders.game.egine;

public class GameLoop {
	private Game target;
	
	private boolean running = false;
	private boolean runningSlow = false;
	
	private final int FRAMES_PER_SECOND = 60;
	private final long MILLISECONDS_PER_SECOND = 1000;
	private final long MILLISECONDS_PER_FRAME = MILLISECONDS_PER_SECOND / FRAMES_PER_SECOND;
	
	public GameLoop(Game target) {
		this.target = target;
	}
	
	/**
	 * Starts the GameLoop
	 */
	public void start() {
		this.running = true;
		
		GameTime time = new GameTime();
		while (this.running) {
			time = new GameTime(time, runningSlow);
			
			this.target.prepareNextFrame(time);
			
			// Target time - current time
			long waitTime = time.getSystemTime() + MILLISECONDS_PER_FRAME - System.currentTimeMillis();
			if (waitTime > 0) {
				this.runningSlow = false;
				try {
					Thread.sleep(waitTime);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			} else {
				this.runningSlow = true;
			}
		}
	}
	
	/**
	 * Whether or not the GameLoop is running
	 * @return Whether or not the GameLoop is running
	 */
	public boolean isRunning() {
		return this.running;
	}
	
	/**
	 * Stops the GameLoop before the next frame
	 */
	public void stop() {
		this.running = false;
	}
}
