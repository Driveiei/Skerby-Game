package Skerby;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This class is key input control.
 * Extend this class to create a KeyEvent listener 
 * and override the methods for the events of interest.
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
 *
 */

public class KeyInput extends KeyAdapter {

	private Player p;

	/**
	 * This constructor is set p vale(Player type) to
	 * attribute.
	 * @param p
	 */
	public KeyInput(Player p) {
		this.p = p;
	}

	/**
	 * This method works on key press when
	 * player hit button.
	 */
	public void keyPressed(KeyEvent k) {
		p.keyPressed(k);
	}

	/**
	 * This method works on key release when
	 * player release button.
	 */
	public void keyReleased(KeyEvent k) {
		p.keyReleased(k);
	}

}
