import java.awt.Graphics;

public abstract class Entity {
	
	protected float x, y;// smooth flow as calcluations arent perfect ints
	
	public Entity(int a, int b) {
		x = a;
		y = b;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
}
