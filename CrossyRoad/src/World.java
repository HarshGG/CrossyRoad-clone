import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Utils.Clock;

public class World{

	private int width, height, spawnX, spawnY;
	private int[][] tiles;
	private ArrayList<Car> cars;
	
	public World() throws IOException{
		loadWorld();
		cars = new ArrayList<Car>();
		spawnCars();
	}
	
	public void tick() {
		double seconds = (double) System.nanoTime()/1000000000;
		if(seconds/3==1) {
			spawnCars();
			System.out.println(seconds);
		}
		
		for(Car a: cars)
			a.tick();
	}
	
	public void render(Graphics g) {
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				getTile(x, y).render(g, x * Tile.width, y * Tile.height);
			}
		}
		g.drawImage(Assets.ducc, 400, 700, null);
		for(Car a: cars)
			a.render(g);
	}
	
	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[tiles[x][y]];
		if(t==null)
			return Tile.grassTile;
		return t;
	}
	
	public void loadWorld() throws IOException{
		Scanner input = new Scanner(new File("world.txt"));
		width = input.nextInt();
		height = input.nextInt();
		
		tiles = new int[width][height];
		
		for(int y = 0; y<height; y++) {
			for(int x = 0; x<width; x++) {
				int a = input.nextInt();
				tiles[x][y] = a;
			}
		}
		
	}
	
	public void spawnCars() {
		
		for(int a = 0; a<3; a++) {
			Car temp = new Car(0,0);
			cars.add(temp);
		}
	}
	
}
