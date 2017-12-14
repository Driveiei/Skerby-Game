package Skerby;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * This class get command to manage and set location of all items in this game.
 * 
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
 */
public class ItemsManager {

	static ArrayList<Items> itemsList = new ArrayList<>();

	private Items item;

	/**
	 * This constructor is creat item.
	 * It is set x position, y position, and type of item.
	 */
	public ItemsManager() {
		addItem(new Items(1350, 90, "poison"));
		addItem(new Items(2150, 90, "poison"));
		addItem(new Items(2900, 130, "poison"));
		addItem(new Items(3580, 50, "health"));
		addItem(new Items(4000, 100, "health"));
		addItem(new Items(4600, 150, "health"));
		addItem(new Items(4700, 150, "poison"));
		addItem(new Items(5500, 50, "poison"));
		addItem(new Items(6385, 140, "health"));
		addItem(new Items(8055, 110, "poison"));
		addItem(new Items(8753, 160, "health"));
		addItem(new Items(11667, 110, "poison"));
		addItem(new Items(14749, 360, "health"));
		addItem(new Items(15525, 360, "poison"));
		addItem(new Items(16353, 360, "health"));
		addItem(new Items(16757, 360, "poison"));
		addItem(new Items(16873, 360, "poison"));
		addItem(new Items(17154, 200, "poison"));
	}

	/**
	 * This method works on run order item list
	 * about draw picture and call render method
	 * from Items class for draw picture.
     * @param g2d - Graphics2D to call Image's Object.
	 */
	public void render(Graphics2D g2d) {
		for (int i = 0; i < itemsList.size(); i++) {
			item = itemsList.get(i);
			item.render(g2d);
		}
	}

	/**
	 * Add item to arraylist.
	 * @param i - Object of item.
	 */
	public void addItem(Items i) {
		itemsList.add(i);
	}

	/**
	 * Remove item from arraylist.
	 * @param i - Object of item.
	 */
	public void removeItem(Items i) {
		itemsList.remove(i);
	}

	/**
	 * Get size of item list.
	 * @return all items.
	 */
	public static ArrayList<Items> getItemsBounds() {
		return itemsList;
	}
}
