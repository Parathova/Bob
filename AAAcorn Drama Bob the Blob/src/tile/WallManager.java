package tile;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class WallManager {

	GamePanel gp;
	Wall [] wall; 
	
	public WallManager(GamePanel gp) {
		
		this.gp = gp;
		wall = new Wall[2];
		
		getWallImage();
	}
	
	public void getWallImage() {
		try {
			
			wall[0] = new Wall();
			wall[0].image = ImageIO.read(getClass().getResourceAsStream("/wall/wall_1.JPG"));
			//wall[0].collision = true;
			
			wall[1] = new Wall();
			wall[1].image = ImageIO.read(getClass().getResourceAsStream("/wall/wall_2.JPG"));
			//wall[1].collision = true;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public  int changeWall = 20; //20 is false, 10 is true 
	
	//update wall position 
	public void updateWall () {
		//System.out.println(changeWall);
		 if (changeWall == 10) { 
			 changeWall = 20;
			 //System.out.println("this works");
			// System.out.println(changeWall);
		 } else {
			 changeWall = 10;
			// System.out.println(changeWall);
		 }
		// System.out.println(changeWall);
	}
	//draw wall position
	 public void drawWall(Graphics2D g2) {
		 int wallScale = 58;
		 int rightPos = gp.screenWidth - gp.tileSize;
		
		 int wall1 = 0;
		 int wall2 = 1;
		
		 
		 if (changeWall == 10) {
			  wall1 = 1;
			  wall2 = 0;
		 } 
		 
		// System.out.println(wall1);
		 
		 for (int i=0; i<11; i++) {
			 
		g2.drawImage(wall[wall1].image, 0, (i*wallScale), gp.tileSize, gp.tileSize, null);
		g2.drawImage(wall[wall1].image, rightPos, (i*wallScale), gp.tileSize, gp.tileSize, null);
		i++;
		g2.drawImage(wall[wall2].image, 0, (i*wallScale), gp.tileSize, gp.tileSize, null);
		g2.drawImage(wall[wall2].image, rightPos, (i*wallScale), gp.tileSize, gp.tileSize, null);
		 }
		//System.out.println(changeWall);
		 
	}
}
