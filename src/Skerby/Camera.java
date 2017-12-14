package Skerby;

/**
 * This class is camera control.
 * 
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
 *
 */

public class Camera {

	private double x;
	private double y;

	/**
	 * This constructor is get x, y value and set these value
	 * to attribute in this class.
	 * @param x
	 * @param y
	 */
	public Camera(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * This method works on camera movement.
	 * When player is move to the right the camera will move to the left,
	 * If player is move to the left the camera will move to the right.
	 * @param p
	 */
	public void update(Player p) {
		x = -p.getX() + Game.WIDTH / 5;
		if (x <= -17100) {
			x = -17100;
		}
	}
	
	/**
	 * Get x position of camera.
	 * @return
	 */
	public double getX() {
		return x;
	}

	/**
	 * Get y position of camera.
	 * @return
	 */
	public double getY() {
		return y;
	}

}
