package Utils;

public class Clock {

	public int fps = 60;
	public double timePerTick = 1000000000/fps; //1 billion nanoseconds in one second
	public double delta = 0;
	public long now;
	public long lastTime;
	
	public long timer = 0;
	public int ticks = 0;
	
	public Clock(int fps, long lastTime) {
		this.fps = fps;
		this.lastTime = lastTime;
	}
	
	
	
}
