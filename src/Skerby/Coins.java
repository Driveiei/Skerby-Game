package Skerby;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * This class collect the data of coins and show the image of each coin.
 * 
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
 */
public class Coins {

	private Image donut = (new ImageIcon(this.getClass().getResource("/Images/Items/donut.png"))).getImage();

    private double x;
    private double y;

    /**
     * This constructor is get x, y value from CoinsManager class
     * then set these value to attribute in this class.
     * 
     * @param x - position of coin in X line.
	 * @param y - position of coin in Y line.
     */
    public Coins(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * This method works on draw coin with Graphics2D.
     * @param g2d - Graphics2D to call Image's Object.
     */
    public void render(Graphics2D g2d) {
        g2d.drawImage(donut, (int) x, (int) y, null);
    }

    /**
     * Get bounds of coin.
     * @return the bounds of each coin.
     */
    public Rectangle getCoinsBounds() {
		return new Rectangle((int) x, (int) y, 45, 45);
	}
}
