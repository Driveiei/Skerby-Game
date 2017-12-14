package Skerby;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * This class get command to manage and set location of fireball in this game.
 *
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
 */
public class FireballManager {

	static ArrayList<Fireball> fireballList = new ArrayList<>();

	private Fireball fb;
	
	/**
	 * This constructor is empty.
	 */
	public FireballManager() {
	}

	/**
	 * This constructor checks size of fireball list, if fireball less than 1 then add fireball.
	 * You can add only 1 fireball.
	 * 
	 * @param player - Object of player to show location pf player.
	 */
	public FireballManager(Player player) {
		if (fireballList.size() < 1) {
			addFireball(new Fireball(player.getX() + 20, player.getY()));
		}
	}

	/**
	 * This method works on run order from fireball list
	 * about draw fireball picture and call render method from Fireball class.
	 * 
     * @param g2d - Graphics2D to call Image's Object.
	 */
	public void render(Graphics2D g2d) {
		for (int i = 0; i < fireballList.size(); i++) {
			fb = fireballList.get(i);
			fb.render(g2d);
		}
	}

	/**
	 * This method works on run order from fireball list
	 * about movement fireball then call update method from
	 * Fireball class for update movement.
	 */
	public void update() {
		for (int i = 0; i < fireballList.size(); i++) {
			fb = fireballList.get(i);
			fb.update();
		}
	}

	/**
	 * Add fireball to arraylist.
	 * @param a - Object of fireball.
	 */
	public void addFireball(Fireball a) {
		fireballList.add(a);
	}

	/**
	 * Remove fireball from arraylist.
	 * @param a - Object of fireball.
	 */
	public void removeFireball(Fireball a) {
		fireballList.remove(a);
	}

	/**
	 * Get size of fireball list.
	 * @return
	 */
	public static ArrayList<Fireball> getFireballBounds() {
		return fireballList;
	}

}