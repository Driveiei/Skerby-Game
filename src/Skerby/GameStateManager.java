package Skerby;

import java.awt.Graphics2D;

/**
 * This class manage the stage of each level.
 * 
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
 */
public class GameStateManager {

	private Level1 level1;

	/**
	 * This constructor is call level1 class to crear map.
	 */
	public GameStateManager() {
		level1 = new Level1();
	}

	/**
	 * This method works on draw picture.
	 * It is call render methd frome level1 class then draw map.
     * @param g2d - Graphics2D to call Image's Object.
	 */
	public void render(Graphics2D g2d) {
		level1.render(g2d);
	}

}
