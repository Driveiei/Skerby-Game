package Skerby;

/**
 * This class is camera control to manage camera to focus the player movement.
 * 
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
 */
public class Camera {

	private double x;
	private double y;

	/**
	 * This constructor is get x, y value and set these value
	 * to attribute in this class.
	 * @param x - position of camera in X line.
	 * @param y - position of camera in Y line.
	 */
	public Camera(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * This method works on camera movement.
	 * When player is move to the right the camera will move to the left,
	 * If player is move to the left the camera will move to the right.
	 * @param p - the object of the player.
	 */
	public void update(Player p) {
		x = -p.getX() + Game.WIDTH / 5;
		if (x <= -17100) {
			x = -17100;
		}
	}
	
	/**
	 * Get x position of camera.
	 * @param x - position of camera in X line.
	 */
	public double getX() {
		return x;
	}

	/**
	 * Get y position of camera.
	 * @param y - position of camera in Y line.
	 */
	public double getY() {
		return y;
	}

}
