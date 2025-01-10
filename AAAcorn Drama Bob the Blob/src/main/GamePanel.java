package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Bob;
import tile.WallManager;

public class GamePanel extends JPanel implements Runnable{

	// SCREEN SETTINGS 
	final int originalTileSize = 32; // 32 x 32 size
	public final int scale = 2;
	
	public final int tileSize = originalTileSize * scale; //64 x 64 tiles
	final int maxScreenCol = 8; //vertical
	final int maxScreenRow = 10; //horizontal
	public final int screenWidth = tileSize * maxScreenCol;  //512 pixels horizontal
	final int screenHeight = tileSize * maxScreenRow;  // 640 pixels vertical
	
	//FPS 
	int FPS = 60;
	WallManager WallM = new WallManager(this);
	
	KeyHandler KeyH = new KeyHandler(); //initiate keyhandler class to control entity (BOB)
	Thread gameThread; //basically time, it keeps going forever 
	//public CollisionChecker Checker = new CollisionChecker(this);
	Bob bob = new Bob(this, KeyH);
	
		
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground( new Color (0, 0, 153));
		this.setDoubleBuffered(true);
		this.addKeyListener(KeyH);
		this.setFocusable(true);
		
	}

	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	double BeforeBackDrawTime = System.nanoTime();
	int BackFPS = 10;
	
	
	@Override
	
	public void run() {
		
		double drawInterval = 1000000000/FPS; // 0.016666 seconds interval for character movement
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		//Forever run 
		int BackFPS = 10;
		double BackDrawInterval = 1000000000/BackFPS;
		
		
		
		while (gameThread != null) {
			
		 
			// System.out.println("is runnnnin");
			// Basically 1: update info like character position
			
			update();
			// 2: draw the screen with the updated info
			repaint();
				
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	//CONTROL BOBBBBBBBB
	public void update () {
		
		
		bob.update();
		double AfterBackDrawTime = System.nanoTime();
		double BackDifference = AfterBackDrawTime - BeforeBackDrawTime;
		//System.out.println(AfterBackDrawTime/100000000 + "-" + BeforeBackDrawTime/100000000);
		//System.out.println(BackDifference/100000000);
		//System.out.println((1000000000/BackFPS));
		
		if (BackDifference > (1000000000/BackFPS)) {
			WallM.updateWall();
			BeforeBackDrawTime = System.nanoTime();
			
		}
				
	}
	
	// DRAW BOBBBBBBB
	
	public void paintComponent (Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		WallM.drawWall(g2);
		//System.out.println(System.nanoTime());
		
		bob.draw(g2);
		
		g2.dispose();
		
	}
}
