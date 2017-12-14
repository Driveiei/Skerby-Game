package Skerby;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * This class is Level1. It's manage about level1 map and contains of
 * blocks in level1.
 *
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
 */
public class Level1 {

	private Image warpgate = (new ImageIcon(this.getClass().getResource("/Images/StateLV1/WarpGate.png"))).getImage();

	private BlockManager bm;
	
	/**
	 * This constructor is set x position, y position,
	 * size or type of block.
	 */
	public Level1() {

		bm = new BlockManager();

		bm = new BlockManager(10, 405, 30, 1);
		bm = new BlockManager(1765, 405, 25, 1);
		bm = new BlockManager(10, 0, 150, 1);
		bm = new BlockManager(10, 0, 1, 10);
		bm = new BlockManager(550, 135, 5, 1);
		bm = new BlockManager(955, 225, 6, 1);
		bm = new BlockManager(1360, 135, 2, 5);
		bm = new BlockManager(1450, 180, 4, 2);
		bm = new BlockManager(1855, 45, 2, 6);
		bm = new BlockManager(1945, 270, 2, 1);
		bm = new BlockManager(2170, 135, 5, 6);
		bm = new BlockManager(2800, 180, 20, 1);
		bm = new BlockManager(3970, 180, 2, 1);
		bm = new BlockManager(5320, 270, 2, 1);
		bm = new BlockManager(5635, 225, 2, 1);
		bm = new BlockManager(550, 270, 3, 5, "Stair");
		bm = new BlockManager(2395, 180, 5, 1, "Stair");
		bm = new BlockManager(3610, 45, 4, 1, "Stair");
		bm = new BlockManager(4330, 270, 4, 15, "Stair");
		bm = new BlockManager(3070, 405, 30, 5, 5);
		bm = new BlockManager(6755, 0, 300, 1);
		bm = new BlockManager(5905, 405, 30, 1);
		bm = new BlockManager(5995, 270, 6, 1);
		bm = new BlockManager(6220, 225, 5, 1);
		bm = new BlockManager(6670, 270, 3, 5, "Stair");
		bm = new BlockManager(7390, 270, 3, 1);
		bm = new BlockManager(7705, 225, 3, 1);
		bm = new BlockManager(8020, 180, 3, 1);
		bm = new BlockManager(8515, 405, 45, 1);
		bm = new BlockManager(8690, 45, 1, 6);
		bm = new BlockManager(8825, 45, 1, 6);
		bm = new BlockManager(8960, 45, 1, 6);
		bm = new BlockManager(9095, 45, 1, 6);
		bm = new BlockManager(9230, 45, 1, 6);
		bm = new BlockManager(9505, 225, 4, 12, "Stair");
		bm = new BlockManager(10310, 135, 9, 1);
		bm = new BlockManager(10670, 45, 1, 2);
		bm = new BlockManager(10675, 270, 4, 1);
		bm = new BlockManager(10900, 180, 1, 1);
		bm = new BlockManager(11080, 180, 1, 1);
		bm = new BlockManager(11350, 225, 1, 1);
		bm = new BlockManager(11660, 180, 1, 1);
		bm = new BlockManager(11930, 180, 1, 1);
		bm = new BlockManager(12245, 270, 15, 1);
		bm = new BlockManager(12425, 180, 2, 6, "Stair");
		bm = new BlockManager(13010, 405, 10, 1);
		bm = new BlockManager(13505, 270, 10, 1);
		bm = new BlockManager(13910, 405, 21, 1);
		bm = new BlockManager(14180, 180, 20, 1);
		bm = new BlockManager(14810, 225, 1, 4);
		bm = new BlockManager(15260, 405, 10, 1);
		bm = new BlockManager(15845, 270, 2, 1);
		bm = new BlockManager(16160, 180, 5, 1);
		bm = new BlockManager(16340, 405, 15, 1);
		bm = new BlockManager(17060, 275, 4, 1);
		bm = new BlockManager(17110, 135, 4, 1);
		bm = new BlockManager(17240, 405, 20, 1);
	}

	/**
	 * This method works on draw warp gate.
     * @param g2d - Graphics2D to call Image's Object.
	 */
	public void render(Graphics2D g2d) {
		g2d.drawImage(warpgate, 118, 200, null);
		g2d.drawImage(warpgate, 17500, 300, null);
		bm.render(g2d);

	}

}
