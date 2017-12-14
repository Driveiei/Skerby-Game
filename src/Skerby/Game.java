package Skerby;

import javax.swing.JFrame;

/**
 * 
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
 *
 */

public class Game {

	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	public static JFrame window = new JFrame("Skerby Game");
	
	public static DiePanel dieP;
	public static Player player;

	public static void main() {
		player = new Player(100);
		window = new JFrame("Skerby Game");
		window.setSize(WIDTH, HEIGHT);
		window.setLocationRelativeTo(null);
		window.add(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
	}

	public void setVisible(boolean trueOrFalse) {
		window.setSize(WIDTH, HEIGHT);
		window.setLocationRelativeTo(null);
		window.add(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
	}
}
