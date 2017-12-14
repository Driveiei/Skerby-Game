package Skerby;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * This class is CoinsManager.
 * It works on creat donut.
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
 *
 */

public class CoinsManager {

	static ArrayList<Coins> coinsList = new ArrayList<>();
	
	private Coins coins;

	/**
	 * This constructor is creat donut.
	 */
	public CoinsManager() {
		for (int i = 0; i < 180; i += 60) {
			addCoin(new Coins(255 + i, 360));
		}
		addCoin(new Coins(445, 310));
		for (int i = 0; i < 210; i += 70) {
			addCoin(new Coins(550 + i, 200));
		}
		for (int i = 0; i < 250; i += 50) {
			addCoin(new Coins(550 + i, 90));
		}
		addCoin(new Coins(1450, 130));
		addCoin(new Coins(1500, 130));
		addCoin(new Coins(1550, 130));
		for (int i = 0; i < 350; i += 50) {
			addCoin(new Coins(1800 + i, 350));
		}
		addCoin(new Coins(1950, 220));
		addCoin(new Coins(2000, 220));
		for (int i = 0; i < 150; i += 50) {
			addCoin(new Coins(2200 + i, 80));
		}
		addCoin(new Coins(2400, 130));
		addCoin(new Coins(2450, 180));
		addCoin(new Coins(2490, 230));
		addCoin(new Coins(2530, 270));
		addCoin(new Coins(2570, 320));
		addCoin(new Coins(3100, 270));
		addCoin(new Coins(3150, 270));
		addCoin(new Coins(3200, 270));
		addCoin(new Coins(3550, 270));
		addCoin(new Coins(3600, 270));
		for (int i = 0; i < 550; i += 50) {
			addCoin(new Coins(4350 + i, 220));
		}
		for (int i = 0; i < 550; i += 50) {
			addCoin(new Coins(4350 + i, 90));
		}
		addCoin(new Coins(5300, 50));
		for (int i = 0; i < 250; i += 50) {
			addCoin(new Coins(5985 + i, 220));
		}
		for (int i = 0; i < 250; i += 50) {
			addCoin(new Coins(5985 + i, 100));
		}
		for (int i = 0; i < 300; i += 50) {
			addCoin(new Coins(6157 + i, 360));
		}
		for (int i = 80; i < 200; i += 40) {
			for (int j = 0; j < 150; j += 50) {
				addCoin(new Coins(6713 + j, i));
			}
		}
		for (int i = 0; i < 200; i += 50) {
			addCoin(new Coins(7029 + i, 230));
		}
		for (int i = 0; i < 150; i += 50) {
			addCoin(new Coins(7385 + i, 120));
		}
		for (int i = 0; i < 150; i += 50) {
			addCoin(new Coins(7861 + i, 90));
		}
		for (int i = 0; i < 250; i += 50) {
			addCoin(new Coins(8349 + i, 200));
		}
		addCoin(new Coins(9021, 200));
		addCoin(new Coins(9021, 240));
		for (int i = 0; i < 400; i += 50) {
			addCoin(new Coins(9577 + i, 80));
		}
		addCoin(new Coins(10377, 70));
		addCoin(new Coins(10477, 70));
		addCoin(new Coins(10577, 70));
		addCoin(new Coins(11211, 130));
		for (int i = 0; i < 150; i += 50) {
			addCoin(new Coins(12479 + i, 90));
		}
		for (int i = 0; i < 250; i += 50) {
			addCoin(new Coins(13561 + i, 100));
		}
		for (int i = 0; i < 500; i += 50) {
			addCoin(new Coins(14341 + i, 120));
		}
		for (int i = 0; i < 200; i += 50) {
			addCoin(new Coins(15529 + i, 100));
		}
		for (int i = 120; i < 240; i += 40) {
			for (int j = 0; j < 200; j += 50) {
				addCoin(new Coins(16741 + j, i));
			}
		}
		for (int i = 0; i < 550; i += 50) {
			addCoin(new Coins(14131 + i, 360));
		}
	}

	/**
	 * This method works on run order from coins list
	 * and call render method from Coins class for
	 * draw picture.
	 * @param g2d
	 */
	public void render(Graphics2D g2d) {
		for (int i = 0; i < coinsList.size(); i++) {
			coins = coinsList.get(i);
			coins.render(g2d);
		}
	}

	/**
	 * This method is add donut to array list.
	 * @param c
	 */
	public void addCoin(Coins c) {
		coinsList.add(c);
	}
	
	/**
	 * This method is remove donut from array list.
	 * @param c
	 */
	public void removeCoin(Coins c) {
		coinsList.remove(c);
	}

	/**
	 * Get size of coins list.
	 * @return
	 */
	public static ArrayList<Coins> getCoinsBounds() {
		return coinsList;
	}

}