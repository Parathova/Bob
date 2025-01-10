package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.CollisionChecker;
import main.GamePanel;
import main.KeyHandler;
public class Bob extends entity {

	GamePanel gp;
	KeyHandler keyH;
	
	public Bob(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		solidArea = new Rectangle(2, 3, 28, 23);
		
		setDefaultValues();
		GetBobImage();
		
	}
	public void setDefaultValues() {
		
		//set player's default position
		x = 210;
		y = 450;
		speed = 4; //SET BOB SPEEEEEEEEEED
		direction = "default"; //resting direction
		
		
	}
	
	public void GetBobImage() {
		
		try {
			bob = ImageIO.read(getClass().getResourceAsStream("/bob/Bob.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		if (keyH.upPressed == true) {
			y -= speed;
		}
		else if (keyH.downPressed == true) {
			y += speed;
		}
		else if (keyH.leftPressed == true) {
			x -= speed;
			
		}
		else if (keyH.rightPressed == true) {
			x += speed;
		}
		//collisionON = false;
		//gp.Checker.checkTile(this);
	}
	public void draw(Graphics2D g2) {
		
		//g2.setColor(Color.pink);
		
		//g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		BufferedImage image = null;
		switch(direction) {
		case "default" :
			image = bob;
			break;
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}
}
