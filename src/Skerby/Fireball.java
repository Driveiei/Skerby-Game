package Skerby;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * This class is Fireball.
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
 *
 */

public class Fireball {
	
	private Image fireball = (new ImageIcon(this.getClass().getResource("/Images/Player/fireball.png"))).getImage();

    private double x;
    private double y;
    
    private double speedX = 5;
    
    /**
     * This constructor is get x, y value from FireballManager class
     * and set these to attribute in this class.
     * @param x
     * @param y
     */
    public Fireball(double x, double y){
    	this.x = x;
    	this.y = y;
    }
    
    /**
     * This method works on draw fireball with Graphics2D.
     * @param g2d
     */
    public void render(Graphics2D g2d){
        g2d.drawImage(fireball, (int)x, (int)y, null);
    }
    
    /**
     * This method works on movement of fireball.
     */
    public void update(){
    	x += speedX;
    }
    
    /**
     * Get x position of fireball.
     * @return
     */
    public int getX(){
    	return (int)x;
    }
    
    /**
     * Get bounds of fireball.
     * @return
     */
    public Rectangle getFireballBounds(){
        return new Rectangle((int)x, (int)y, 64, 64);
    }
}
