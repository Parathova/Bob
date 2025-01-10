package main;

import entity.entity;

public class CollisionChecker {
	
	GamePanel gp;
	public boolean WallCollision = false;
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
		
	}
	public void checkTile(entity entity) {
		
		int entityLeftX = entity.x - (entity.solidArea.x*gp.scale);
		if (entityLeftX == gp.tileSize) {
			  WallCollision = true; 
		}
		//System.out.println(entityLeftX);
		int entityRightX = entity.x + entity.solidArea.x*gp.scale;
		//System.out.println(entityRightX);
		
		int entityTopY = entity.y - entity.solidArea.y*gp.scale;
		int entityBottomY = entity.y + entity.solidArea.y*gp.scale;
		
		//int entityLeftCol = entityLeftWorldX/gp.tileS)ize;
		//int entityRightCol = entityRightWorldX/gp.tileSize;
		//int entityTopRow = entityTopWorldY/gp.tileSize;
		//int entityBottomRow = entityBottomWorldY/gp.tileSize;
		
		//int tileNum1, tileNum2;
	}

}
