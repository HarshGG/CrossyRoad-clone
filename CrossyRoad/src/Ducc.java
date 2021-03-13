import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Ducc extends Creature{
	
	private Game game;
	private BufferedImage image;

	public Ducc(Game g, int x, int y) {
		super(x, y);
		game = g;
		image = Assets.ducc;
	}

	@Override
	public void tick() {
		if(game.getKeyManager().up || game.getKeyManager().down || game.getKeyManager().left || game.getKeyManager().right) {
		
		if(game.getKeyManager().up) {
			y-=3;
			image = Assets.ducc_up;
		}
		if(game.getKeyManager().down) {
			y+=3;
			image = Assets.ducc_down;
		}
		if(game.getKeyManager().left) {
			x-=3;
			image = Assets.ducc_left;
		}
		if(game.getKeyManager().right) {
			x+=3;
			image = Assets.ducc_right;
			}
		}
		else
			image = Assets.ducc;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, (int) x, (int) y, null);
	}

	
	
} 
