package Skerby;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * This class collect the data of fireball and show the image of fireball.
 * 
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
 */
public class Fireball {
	
	private Image fireball = (new ImageIcon(this.getClass().getResource("/Images/Player/fireball.png"))).getImage();

    private double x;
    private double y;
    
    private double speedX = 5;

    /**
     * This constructor gets x, y value from FireballManager class
     * and set this to attribute in this class.
     * 
     * @param x - position of enemy in X line.
     * @param y - position of enemy in Y line.
     */
    public Fireball(double x, double y){
    	this.x = x;
    	this.y = y;
    }
    
    /**
	 * This method works on draw fireball with Graphics2D.
	 * 
	 * @param g2d - Graphics2D to call Image's Object.
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
     * @return position of fireball.
     */
    public int getX(){
    	return (int)x;
    }
    
    /**
	 * Get all fireball list.
	 * @return all fireball list.
	 */
    public Rectangle getFireballBounds(){
        return new Rectangle((int)x, (int)y, 64, 64);
    }
}
