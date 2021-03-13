import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(1);
	public static Tile roadTile = new RoadTile(2);
	
	public static final int width = 100, height = 100;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int num) {
		this.texture = texture;
		id = num;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture,x,y,width,height,null);
	}
	
	public int getId() {
		return id;
	}
	
	public boolean isSolid() {
		return false;
	}
}

