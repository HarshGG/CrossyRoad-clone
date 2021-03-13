import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Car extends Entity{

	private String[] types;
	private BufferedImage[] images;
	private String type;
	private BufferedImage texture;
	private boolean rightToLeft = false;
	
	private int spawnX, spawnY;
	
	public Car(int a, int b) {
		super(a, b);
		
		types = new String[3];
		types[0] = "car1";
		types[1] = "car2";
		types[2] = "bus1";
		
		images = new BufferedImage[4];
		images[0] = Assets.car1left;
		images[1] = Assets.car2left;
		images[2] = Assets.car1right;
		images[3] = Assets.car2right;
		
		assign();
	}

	@Override
	public void tick() {
		if(!rightToLeft)
			x+=3;
		else
			x-=3;
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(texture,(int) x, (int) y, null);
		
	}
	
	public void assign() {
		int rand = ((int) (Math.random()*2) + 1)-1;
		type = types[rand];
		BufferedImage[] current = new BufferedImage[2];
		if(rand==0) {
			current[0] = images[0];//left
			current[1] = images[2];//right
		}
		else {
			current[0] = images[1];//left
			current[1] = images[3];//right
		}
		
		rand = (int)(Math.random() * 2);
		
		if(rand==1)
			rightToLeft = true;
		if(rightToLeft) {
			int[] posY = new int[2];
			posY[0] = 120;
			posY[1] = 420;
			rand = (int)(Math.random() * 2);
			spawnY = posY[rand];
			spawnX = 900;
			
			texture = current[1];
		}
		else{
			int[] posY = new int[2];
			posY[0] = 220;
			posY[1] = 520;
			rand = (int)(Math.random() * 2);
			spawnY = posY[rand];
			spawnX = -100;
			
			texture = current[0];
		}
		
		x = (float) spawnX;
		y = (float) spawnY;
		
	}

}
