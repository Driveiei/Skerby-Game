package Skerby;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * This class manage location, movement and attack of player and 
 * check if player or fireball's position are intersects with 
 * blocks, coins, enemies, and items.
 * 
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
 */
public class Player {

	private Image playerR = (new ImageIcon(this.getClass().getResource("/Images/Player/playerR.png"))).getImage();

	private boolean attack = false;
	private boolean right;
	private boolean left;

	private boolean jumping = true;
	private double jumpSpeed = 6;
	private double currentJumpSpeed = jumpSpeed;

	private boolean falling = true;
	private double maxFallSpeed = 6;
	private double currentFallSpeed = 0.1;

	private double starterJump = -100;
	private boolean inAir = false;
	private int bugJump = 100;

	private double x;
	private double y;
	private int playerHP;

	private EnemyManager em;
	private CoinsManager cm;
	private FireballManager fbm;
	private ItemsManager im;

	static ArrayList<Coins> cl = CoinsManager.getCoinsBounds();
	static ArrayList<Enemy> el = EnemyManager.getEnemyListBounds();
	static ArrayList<Fireball> fbl = FireballManager.getFireballBounds();
	static ArrayList<Items> il = ItemsManager.getItemsBounds();
	static ArrayList<Block> bl = BlockManager.getBlocksBounds();

	static int score = 0;

	private final int playerWidth = 64;
	private final int playerHeight = 64;

	private JOptionPane frame;

	private int count = 0;

	/**
	 * This constructor is get hp value and set to attribute
	 * and set start position of player.
	 * @param hp - hp of player.
	 */
	public Player(int hp) {
		x = 140;
		y = 200;
		this.playerHP = hp;
	}

	/**
	 * This method works on movement of player(move right/left, 
	 * jump, collision, and attack) and call check method of intersect location.
	 */
	public void update() {
		if (right) {
			x += 4;
		}
		if (left) {
			x -= 4;
		}
		if (attack) {
			fbm = new FireballManager(this);
		}
		if (jumping) {
			y -= currentJumpSpeed;
			currentJumpSpeed -= 0.1;
			if (currentJumpSpeed <= 0) {
				currentJumpSpeed = jumpSpeed;
				jumping = false;
				falling = true;
			}
		}
		if (y < starterJump + 0.1 && count == 1 && currentFallSpeed > 5) {
			jumping = false;
			falling = true;
			currentFallSpeed = 4;
		}

		if (currentJumpSpeed > 0.1 && currentJumpSpeed < 5.9) {
			inAir = true;
		}

		if (count == 2) {
			bugJump = 2;
		} else {
			bugJump = 3;
		}
		if (falling) {
			y += currentFallSpeed;

			if (currentFallSpeed < maxFallSpeed) {
				currentFallSpeed += 0.15;
			}
		}
		if (!falling) {
			currentFallSpeed = 0.1;
		}
		if (x < 140)
			x = 140;
		if (x > 17700)
			x = 17700;
		if (y > 450) {
			playerHP = 0;
		}
		if (y < 0)
			y = 0;
		collisionCoins();
		collisionEnemy();
		collisionBlocks();
		fireBallEnemy();
		fireBallBlock();
		collisionItems();
		if (playerHP < 0) {
			this.playerHP = 0;
		}
	}

	/**
	 * This method works on draw picture.
     * @param g2d - Graphics2D to call Image's Object.
	 */
	public void render(Graphics2D g2d) {
		if (attack == true) {
			g2d.drawImage(playerR, (int) x, (int) y, null);
			try {
				fbm.render(g2d);
			} catch (Exception e) {

			}
		} else {
			g2d.drawImage(playerR, (int) x, (int) y, null);
		}
		
		// show player bounds for test collision.
		// g3d.draw(getBoundsRight());
		// g3d.draw(getBoundsLeft());
		// g3d.draw(getBoundsTop());
	}

	/**
	 * Get x position of player.
	 * @return position of player in X axis.
	 */
	public double getX() {
		return x;
	}

	/**
	 * Get y position of player.
	 * @return position of player in Y axis.
	 */
	public int getY() {
		return (int) y;
	}

	/**
	 * Get player height value.
	 * @return height of player.
	 */
	public int getPlayerHeight() {
		return (int) playerHeight;
	}

	/**
	 * Get player width value.
	 * @return width of player.
	 */
	public int getPlayerWidth() {
		return (int) playerWidth;
	}

	/**
	 * Get attack value.
	 * @return attack of player.
	 */
	public boolean getAttack() {
		return attack;
	}

	/**
	 * Get score value.
	 * @return score of player.
	 */
	public static int getScore() {
		return score;
	}

	/**
	 * Get player hp value.
	 * @return hp of player.
	 */
	public int getPlayerHP() {
		return playerHP;
	}

	/**
	 * This method checks if it can double jump.
	 * If it can do return true, else return false.
	 * @return can jump twice or not.
	 */
	public boolean doubleJump() {
		if (count <= 1) {
			currentJumpSpeed += 0.5;
			falling = false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method works on when player hit button.
	 * Use KeyEvent for check.
	 * @param k - KeyEvent to call object KeyAdapter.
	 */
	public void keyPressed(KeyEvent k) {
		int key = k.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			left = true;
		}
		if (key == KeyEvent.VK_RIGHT) {
			right = true;
		}
		if ((key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP) && (canJump() || doubleJump())) {
			count++;
			starterJump = y;
			jumping = true;
		}
		if (key == KeyEvent.VK_Z) {
			attack = true;
		}
	}

	/**
	 * This method works on when player release button.
	 * Use KeyEvent for check.
	 * @param k - KeyEvent to call object KeyAdapter.
	 */
	public void keyReleased(KeyEvent k) {
		int key = k.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			left = false;
		}
		if (key == KeyEvent.VK_RIGHT) {
			right = false;
		}
		if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP) {
		}
		if (key == KeyEvent.VK_Z) {
			attack = false;
		}
	}

	/**
	 * If player can jump (when on the blocks).
	 * @return can jump or not.
	 */
	public boolean canJump() {
		for (int i = 0; i < bl.size(); i++) {
			if (getBoundsDown().intersects(bl.get(i).getBlockBounds())) {
				count = 0;
				return true;
			}
		}
		return false;
	}

	/**
	 * Get bound down of player.
	 * @return bound down of player.
	 */
	public Rectangle getBoundsDown() {
		return new Rectangle((int) x + 5, (int) y + playerHeight,
				(int) playerWidth - 16, (int) 5);
	}

	/**
	 * Get bound top of player.
	 * @return bound top of player.
	 */
	public Rectangle getBoundsTop() {
		return new Rectangle((int) x + 11, (int) y + (playerHeight / 5),
				(int) playerWidth - 25, (int) 5);
	}

	/**
	 * Get bound right of player.
	 * @return bound right of player.
	 */
	public Rectangle getBoundsRight() {
		return new Rectangle((int) x + playerWidth - 8, (int) y
				+ (playerHeight / 4), (int) 5, (int) playerHeight - 25);
	}

	/**
	 * Get bound left of player
	 * @return bound left of player.
	 */
	public Rectangle getBoundsLeft() {
		return new Rectangle((int) x - 5, (int) y + (playerHeight / 4),
				(int) 5, (int) playerHeight - 25);
	}

	/**
	 * Check the location of player and coins that are intersect or not.
	 * Return true when it crash, else false.
	 * 
	 * @param i - numbers of each coin.
	 * @return intersect or not.
	 */
	public boolean coinOrNot(int i) {
		if (getBoundsDown().intersects(cl.get(i).getCoinsBounds())) {
			return true;
		} else if (getBoundsTop().intersects(cl.get(i).getCoinsBounds())) {
			return true;
		} else if (getBoundsRight().intersects(cl.get(i).getCoinsBounds())) {
			return true;
		} else if (getBoundsLeft().intersects(cl.get(i).getCoinsBounds())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method works on collision coins.
	 * If player location intersects each coin it will add score 10 point.
	 */
	public void collisionCoins() {
		for (int i = 0; i < cl.size(); i++) {
			if (coinOrNot(i)) {
				cl.remove(i);
				score += 10;
			}
		}
	}

	/**
	 * Check the location of player and enemies that are intersect or not.
	 * Return true when it crash, else false.
	 * 
	 * @param i - numbers of each enemy.
	 * @return intersect or not.
	 */
	public boolean enemyOrNot(int i) {
		if (getBoundsDown().intersects(el.get(i).getEnemyBounds())) {
			return true;
		} else if (getBoundsTop().intersects(el.get(i).getEnemyBounds())) {
			return true;
		} else if (getBoundsRight().intersects(el.get(i).getEnemyBounds())) {
			return true;
		} else if (getBoundsLeft().intersects(el.get(i).getEnemyBounds())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method works on collision enemy.
	 * If location of player intersects each enemy it will give damage to player.
	 * If player are attack and location of player intersects each enemy  
	 * then, enemy will be remove from arraylist and add score 15 point.
	 */
	public void collisionEnemy() {
		for (int i = 0; i < el.size(); i++) {
			if (enemyOrNot(i)) {
				if (attack) {
					el.remove(i);
					score += 15;
				} else {
					playerHP -= 1;
				}
			}
		}
	}

	/**
	 * This method checks if location of player intersects
	 * with blocks and set movement of player when intersect of each block.
	 */
	public void collisionBlocks() {
		for (int i = 0; i < bl.size(); i++) {
			if (getBoundsDown().intersects(bl.get(i).getBlockBounds())) {
				currentFallSpeed = 0;
				if (falling) {
					currentJumpSpeed = 6;
				}
			}
		}
		for (int i = 0; i < bl.size(); i++) {
			if (getBoundsTop().intersects(bl.get(i).getBlockBounds())) {
				falling = true;
				jumping = false;
			}
		}
		for (int i = 0; i < bl.size(); i++) {
			if (getBoundsLeft().intersects(bl.get(i).getBlockBounds())) {
				x += 5;
			}
		}
		for (int i = 0; i < bl.size(); i++) {
			if (getBoundsRight().intersects(bl.get(i).getBlockBounds())) {
				x -= 5;
			}
		}
	}

	/**
	 * This method works on collision items.
	 * If player's location intersects with poison it will decrease hp of player.
	 * If player's location intersects with health it will increase hp of player.
	 */
	public void collisionItems() {
		for (int i = 0; i < il.size(); i++) {
			if (itemOrNot(i) == true && il.get(i).getType().equals("poison")) {
				playerHP -= 10;
				il.remove(i);
			} else if (itemOrNot(i) == true
					&& il.get(i).getType().equals("health")) {
				playerHP += 15;
				il.remove(i);
				if (playerHP > 100) {
					playerHP = 100;
				}
			}
		}
	}

	/**
	 * Check player's location intersects with items or not.
	 * Return true when it crash, else false.
	 * @param i - numbers of each item.
	 * @return intersects with item or not.
	 */
	public boolean itemOrNot(int i) {
		if (getBoundsDown().intersects(il.get(i).getItemsBounds())) {
			return true;
		} else if (getBoundsTop().intersects(il.get(i).getItemsBounds())) {
			return true;
		} else if (getBoundsRight().intersects(il.get(i).getItemsBounds())) {
			return true;
		} else if (getBoundsLeft().intersects(il.get(i).getItemsBounds())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method works on fireball collision with enemy.
	 * If fireball's location intersects with enemy or 
	 * x position of fireball more than 17700 in X-axis
	 * then remove fireball.
	 */
	public void fireBallEnemy() {
		for (int i = 0; i < el.size(); i++) {
			try {
				if (fbl.get(0).getFireballBounds()
						.intersects(el.get(i).getEnemyBounds())) {
					el.remove(i);
					fbl.remove(0);
					score += 15;
				}else if (fbl.get(0).getX() > 17700) {
					fbl.remove(0);
				}
			} catch (Exception e) {

			}

		}
	}

	/**
	 * This method works on fireball collision with block.
	 * If fireball's location intersects with block
	 * or x position of fireball more than 17700 then remove fireball.
	 */
	public void fireBallBlock() {
		for (int i = 0; i < bl.size(); i++) {
			try {
				if (fbl.get(0).getFireballBounds()
						.intersects(bl.get(i).getBlockBounds())) {
					fbl.remove(0);
				}else if (fbl.get(0).getX() > 17700) {
					fbl.remove(0);
				}
			} catch (Exception e) {

			}

		}
	}

}
