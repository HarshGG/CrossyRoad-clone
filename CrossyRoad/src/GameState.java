import java.awt.Graphics;
import java.io.IOException;

public class GameState extends State{

	private Ducc ducc;
	private World world;
	
	public GameState(Game g){
		super(g);
		ducc = new Ducc(g, 400, 630);
		try {
			world = new World();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void tick() {
		world.tick();
		ducc.tick();
	}
	
	public void render(Graphics g) {
		world.render(g);
		ducc.render(g);		
	}
	
	public Game getGame() {
		return game;
	}
	
	
}
