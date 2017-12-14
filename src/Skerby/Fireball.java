package Skerby;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Fireball {
	
	private Image fireball = (new ImageIcon(this.getClass().getResource("/Images/Player/fireball.png"))).getImage();

    private double x;
    private double y;
    
    private double speedX = 5;
    
    public Fireball(double x, double y){
    	this.x = x;
    	this.y = y;
    }
    
    public void render(Graphics2D g2d){
        g2d.drawImage(fireball, (int)x, (int)y, null);
    }
    
    public void update(){
    	x += speedX;
    }
    
    public int getX(){
    	return (int)x;
    }
    
    public Rectangle getFireballBounds(){
        return new Rectangle((int)x, (int)y, 64, 64);
    }
}
