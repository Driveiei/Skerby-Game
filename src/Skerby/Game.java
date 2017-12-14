package Skerby;

import javax.swing.JFrame;

/**
 * This class sets the option of Jframe you want and
 * add and set information from another class to JFrame.
 * 
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
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
		window.setSize(WIDTH, HEIGHT); //to set the size of JFrame.
		window.setLocationRelativeTo(null);//to set the location in the center of the desktop when play this game.
		window.add(new GamePanel());//to add and set information from another class to JFrame.
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//to be able to close the program.
		window.setResizable(false);//to inhibit the player who wants to resize the frame.
		window.setVisible(true);// to makes the player can see this game and change to another frame.
	}

	public void setVisible(boolean trueOrFalse) {
		window.setSize(WIDTH, HEIGHT); //to set the size of JFrame.
		window.setLocationRelativeTo(null);//to set the location in the center of the desktop when play this game.
		window.add(new GamePanel());//to add and set information from another class to JFrame.
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//to be able to close the program.
		window.setResizable(false);//to inhibit the player who wants to resize the frame.
		window.setVisible(true);// to makes the player can see this game and change to another frame.
	}
}
