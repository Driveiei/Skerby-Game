package Skerby;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * This class is BloackManager.
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
 *
 */

public class BlockManager {

	private Block blocks;

	private int x;
	private int y;
	private int column;
	private int row;
	private int height;
	private int width;
	private int stack;

	private final int boxSize = 45;

	static ArrayList<Block> blocksList = new ArrayList<>();

	public BlockManager() {
	}

	public BlockManager(int x, int y, int column, int row) {
		this.x = x;
		this.y = y;
		this.column = column;
		this.row = row;
		for (int i = x; i < x + (column * boxSize); i += boxSize) {
			for (int j = y; j < y + (row * boxSize); j += boxSize) {
				addBlock(new Block(i, j));
			}
		}
	}

	public BlockManager(int x, int y, int column, int stack, int space) {
		this.x = x;
		this.y = y;
		this.column = column;
		this.stack = stack;
		int countStack = 0;
		int countSpace = 0;
		for (int i = x; i < x + (column * boxSize); i += boxSize) {
			if (countStack < stack) {
				addBlock(new Block(i, y));
				countStack++;
			} else {
				countSpace++;
				if (countSpace >= space) {
					countStack = 0;
					countSpace = 0;
				}
			}
		}
	}

	public BlockManager(int y, int x, int height, int width, String str) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		for (int i = x; i < x + (height * boxSize); i += boxSize) {
			for (int j = y; j < y + (width * boxSize); j += boxSize) {
				addBlock(new Block(j, i));
			}
			width += 2;
			y -= boxSize;
		}
	}

	public void render(Graphics2D g2d) {
		for (int i = 0; i < blocksList.size(); i++) {
			blocks = blocksList.get(i);
			blocks.render(g2d, i);
		}
	}

	public void addBlock(Block b) {
		blocksList.add(b);
	}

	public static ArrayList<Block> getBlocksBounds() {
		return blocksList;
	}

}
