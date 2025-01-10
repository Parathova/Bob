package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class entity {
	
	public int x, y;
	public int speed;
	
	public BufferedImage bob;
	public String direction;
	public Rectangle solidArea;
	public boolean collisionON = false;
}
