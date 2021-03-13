import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Utils.Clock;

public class Game implements Runnable{
	
	private Display display;
	private int width, height;
	private String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private State gameState;
	private State menuState;
	
	private KeyManager keyManager;
	
	private Clock clock;
	
	public Game(String title, int w, int h) {
		width = w;
		height = h;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameState = new GameState(this);
		State.setState(gameState);
	}
	
	int x = 0;
	
	private void tick() {
		keyManager.tick();
		if(State.getState()!=null)
			State.getState().tick();
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		//clear screen
		g.clearRect(0, 0, width, height);
		//Draw Here
		
		
		if(State.getState()!=null)
			State.getState().render(g);
		
		
		//End Drawing
				
		bs.show();
		g.dispose();
	}

	@Override
	public void run() {
		
		init();
		
		clock =  new Clock(60, System.nanoTime());
		
//		int fps = 60;
//		double timePerTick = 1000000000/fps; //1 billion nanoseconds in one second
//		double delta = 0;
//		long now;
//		long lastTime = System.nanoTime(); // amt of time in nanoseconds our computer is running at
//		
//		long timer = 0;
//		int ticks = 0;
//		
		while(running) {
			clock.now = System.nanoTime();
			clock.delta += (clock.now-clock.lastTime)/clock.timePerTick; // (amt of time passed)/ max time allowed to call tick and render
			//delta tells computer when and when not to call t&r
			clock.timer += clock.now - clock.lastTime;
			clock.lastTime = clock.now;
			
			if(clock.delta>=1) {//done in order to achieve 60 fps
				tick();
				render();
				clock.ticks++;
				clock.delta--;
			}
			//timer
			if(clock.timer >= 1000000000) {
				System.out.println("FPS :" + clock.ticks);
				clock.ticks = 0;
				clock.timer = 0;
			}
			
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Clock getClock() {
		return clock;
	}

	public void setClock(Clock clock) {
		this.clock = clock;
	}
}
