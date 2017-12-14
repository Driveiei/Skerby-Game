package Skerby;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * This class is item.
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
 *
 */

public class Items {

	private Image poison = (new ImageIcon(this.getClass().getResource("/Images/Items/poison.png"))).getImage();
	private Image health = (new ImageIcon(this.getClass().getResource("/Images/Items/health.png"))).getImage();

	private double x;
	private double y;

	private String type;

	/**
	 * This constructor is get x, y vale and type of item(poison or health),
	 * and set these to attribute in this class.
	 * @param x
	 * @param y
	 * @param type
	 */
	public Items(double x, double y, String type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}

	/**
	 * This method works on draw item with Graphics2D.
	 * @param g2d
	 */
	public void render(Graphics2D g2d) {
		if (type.equals("poison")) {
			g2d.drawImage(poison, (int) x, (int) y, null);
		}
		if (type.equals("health")) {
			g2d.drawImage(health, (int) x, (int) y, null);
		}
	}

	/**
	 * Get type of item.
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * Get bounds of item.
	 * @return
	 */
	public Rectangle getItemsBounds() {
		return new Rectangle((int) x, (int) y, 45, 45);
	}

}
