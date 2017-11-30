package Skerby;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Attack {
	
    private Image enemyR = new ImageIcon("Images/Player/fireball.png").getImage();
    private Image enemyL = new ImageIcon("Images/Enemy/EnemyL.png").getImage();

    private double x;
    private double y;
    
    private double speedX = 3;
    private int count = 0;
    
    private boolean left;
    private boolean right;
    
    public Attack(double x, double y){
    	this.x = x;
    	this.y = y;
    }
    
    public void render(Graphics2D g2d){
    	if (right){
            g2d.drawImage(enemyR, (int)x, (int)y, null);
        }
        if (left){
            g2d.drawImage(enemyL, (int)x, (int)y, null);
        }
    }
    
    public void update(){
    	x += speedX;
        if (count > 0){
            if (right == false){
//                left = true;
//                right = false;
                speedX = 3;
//                count--;
                count = -8;
                if (count == 0){
                    left = false;
                }
            }else
                if (left == false){
                right = true;
                left = false;
                speedX = 3;
                count++;
                if (count == 51){
                    right = false;
                }
            }
        }else {
            right = true;
            left = false;
            count++;
            speedX = 3;
        }
    }
    
    public int getX(){
    	return (int)x;
    }
    
    public Rectangle getFireBounds(){
        return new Rectangle((int)x, (int)y, 64, 64);
    }
}
