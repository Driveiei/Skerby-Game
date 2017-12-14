package Skerby;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Enemy {

	private Image enemyR = (new ImageIcon(this.getClass().getResource("/Images/Enemy/EnemyR.png"))).getImage();
	private Image enemyL = (new ImageIcon(this.getClass().getResource("/Images/Enemy/EnemyL.png"))).getImage();
	private Image enemyY = (new ImageIcon(this.getClass().getResource("/Images/Enemy/EnemyY.png"))).getImage();

    private double x;
    private double y;

    private double speedX = 3;
    private double speedY = 3;
    
    private int countX = 0;
    private int countY = 0;

    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;
    
    private String type;

    public Enemy(double x, double y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void render(Graphics2D g2d) {
        if (right == true && type.equals("x")) {
            g2d.drawImage(enemyR, (int) x, (int) y, null);
        }
        if (left == true && type.equals("x")) {
            g2d.drawImage(enemyL, (int) x, (int) y, null);
        }
        if (type.equals("y")) {
            g2d.drawImage(enemyY, (int) x, (int) y, null);
        }
    }

    public void update() {
        if (type.equals("x")) {
            x += speedX;
            if (countX > 0) {
                if (right == false) {
                    left = true;
                    right = false;
                    speedX = -3;
                    countX--;
                    if (countX == 0) {
                        left = false;
                    }
                } else if (left == false) {
                    right = true;
                    left = false;
                    speedX = 3;
                    countX++;
                    if (countX == 51) {
                        right = false;
                    }
                }
            } else {
                right = true;
                left = false;
                countX++;
                speedX = 3;
            }
        }
        if (type.equals("y")) {
            y += speedY;
            if (countY > 0) {
                if (down == false) {
                    up = true;
                    down = false;
                    speedY = -3;
                    countY--;
                    if (countY == 0) {
                        up = false;
                    }
                } else if (up == false) {
                    down = true;
                    up = false;
                    speedY = 3;
                    countY++;
                    if (countY == 51) {
                        down = false;
                    }
                }
            } else {
                down = true;
                up = false;
                countY++;
                speedY = 3;
            }
        }
    }

    public int getX() {
        return (int) x;
    }

    public Rectangle getEnemyBounds() {
        return new Rectangle((int) x, (int) y, 64, 64);
    }
}
