
import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage road, grass;
	public static BufferedImage ducc, ducc_up, ducc_down, ducc_right, ducc_left;
	public static BufferedImage car1left, car2left, car1right, car2right;
	
	public static void init() {
		road = ImageLoader.loadImage("/road.png");
		grass = ImageLoader.loadImage("/grass.png");
		
		ducc = ImageLoader.loadImage("/ducc.png");
		ducc_up = ImageLoader.loadImage("/ducc_up.png");
		ducc_down = ImageLoader.loadImage("/ducc_down.png");
		ducc_left = ImageLoader.loadImage("/ducc_left.png");
		ducc_right = ImageLoader.loadImage("/ducc_right.png");
		
		car1left = ImageLoader.loadImage("/car1left.png");
		car2left = ImageLoader.loadImage("/car2left.png");
		car1right = ImageLoader.loadImage("/car1right.png");
		car2right = ImageLoader.loadImage("/car2right.png");
	}
	
}
