package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	public boolean upPressed, downPressed, leftPressed, rightPressed;
	@Override
	public void keyTyped(KeyEvent e) {
		
		//USE FOR TITLE SCREEN?
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
			upPressed = true;
		}
		
		if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
			leftPressed = true;
			//System.out.println("left");
		}
		if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
			downPressed = true;
			//System.out.println("down");
		}
		if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
			rightPressed = true;
			//System.out.println("right");
		}
		
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
			upPressed = false;
		}
		
		if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
			leftPressed = false;
		}
		if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
			downPressed = false;
		}
		if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
			rightPressed = false;
		}
	}

}
