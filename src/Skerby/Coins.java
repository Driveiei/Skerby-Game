package Skerby;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Coins {

	private Image donut = (new ImageIcon(this.getClass().getResource("/Images/Items/donut.png"))).getImage();

    private double x;
    private double y;

    public Coins(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void render(Graphics2D g2d) {
        g2d.drawImage(donut, (int) x, (int) y, null);
    }

    public Rectangle getCoinsBounds() {
        return new Rectangle((int) x, (int) y, 45, 45);
    }
}
