package Skerby;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * This class get command to manage and set location of all enemy in this game.
 *
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
 */
public class EnemyManager {

	static ArrayList<Enemy> enemyList = new ArrayList<>();

	private Enemy enemy;

	/**
	 * This constructor create enemy with
	 * x position, y position, and axis movement.
	 */
	public EnemyManager() {
		addEnemy(new Enemy(1050, 340, "x"));
		addEnemy(new Enemy(1750, 340, "x"));
		addEnemy(new Enemy(3250, 115, "x"));
		addEnemy(new Enemy(3100, 340, "x"));
		addEnemy(new Enemy(3500, 340, "x"));
		addEnemy(new Enemy(4500, 210, "x"));
		addEnemy(new Enemy(6241, 340, "x"));
		addEnemy(new Enemy(9620, 158, "x"));
		addEnemy(new Enemy(9840, 158, "x"));
		addEnemy(new Enemy(13688, 202, "x"));
		addEnemy(new Enemy(14432, 337, "x"));
		addEnemy(new Enemy(16702, 340, "x"));

		addEnemy(new Enemy(480, 30, "y"));
		addEnemy(new Enemy(800, 40, "y"));
		addEnemy(new Enemy(1300, 60, "y"));
		addEnemy(new Enemy(1650, 30, "y"));
		addEnemy(new Enemy(2500, 30, "y"));
		addEnemy(new Enemy(4200, 100, "y"));
		addEnemy(new Enemy(5100, 45, "y"));
		addEnemy(new Enemy(5540, 55, "y"));
		addEnemy(new Enemy(6310, 30, "y"));
		addEnemy(new Enemy(6497, 60, "y"));
		addEnemy(new Enemy(7598, 100, "y"));
		addEnemy(new Enemy(8747, 150, "y"));
		addEnemy(new Enemy(8894, 160, "y"));
		addEnemy(new Enemy(9034, 150, "y"));
		addEnemy(new Enemy(9150, 160, "y"));
		addEnemy(new Enemy(11196, 55, "y"));
		addEnemy(new Enemy(11508, 30, "y"));
		addEnemy(new Enemy(16044, 30, "y"));
	}

	/**
	 * This method works on run order from enemylist
	 * and call render method from Enemy class for
	 * draw each enemy's picture.
     * @param g2d - Graphics2D to call Image's Object.
	 */
	public void render(Graphics2D g2d) {
		for (int i = 0; i < enemyList.size(); i++) {
			enemy = enemyList.get(i);
			enemy.render(g2d);
		}
	}

	/**
	 * This method works on run order from enemy list
	 * about movement and call update method from Enemy class
	 * for update movement all the time.
	 */
	public void update() {
		for (int i = 0; i < enemyList.size(); i++) {
			enemy = enemyList.get(i);
			enemy.update();
		}
	}

	/**
	 * Add enemy to arraylist.
	 * @param e - Object of each enemy.
	 */
	public void addEnemy(Enemy e) {
		enemyList.add(e);
	}

	/**
	 * Remove enemy frome arraylist.
	 * @param e - Object of each enemy.
	 */
	public void removeEnemy(Enemy e) {
		enemyList.remove(e);
	}

	/**
	 * Get all enemy list.
	 * @return all enemy list.
	 */
	public static ArrayList<Enemy> getEnemyListBounds() {
		return enemyList;
	}

}