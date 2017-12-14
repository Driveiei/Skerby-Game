package Skerby;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * This class get command to manage and set location of all block in this game.
 * 
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
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
	
	/**
	 * This constructor creates the square block which position and size you want.
	 * 
	 * @param x - position of block in X line.
	 * @param y - position of block in Y line.
	 * @param column - numbers of column square.
	 * @param row - numbers of row square.
	 */
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

	/**
	 * This constructor creates the square blocks which have one row, 
	 * numbers of hole blocks swap with blocks which position you want.
	 * 
	 * @param x - position of block in X line.
	 * @param y - position of block in Y line.
	 * @param column - total numbers of column square.
	 * @param stack - numbers of block column square.
	 * @param space - numbers of hole block column square.
	 */
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
	
	/**
	 * This constructor creates the stair squares of block which have set width and
	 * height of stairs which position you want.
	 * 
	 * @param y - position of block in Y line.
	 * @param x - position of block in X line.
	 * @param height - the numbers of height's stair blocks.
	 * @param width - the numbers of width's stair blocks.
	 * @param str - type of this stair
	 */
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

	/**
	 * This method works on run order from blocks list
	 * and call render method from Block class for
	 * draw each block's picture.
	 * 
     * @param g2d - Graphics2D to call Image's Object.
	 */
	public void render(Graphics2D g2d) {
		for (int i = 0; i < blocksList.size(); i++) {
			blocks = blocksList.get(i);
			blocks.render(g2d, i);
		}
	}

	/**
	 * This method adds block to array list.
	 * @param b - Object of each block.
	 */
	public void addBlock(Block b) {
		blocksList.add(b);
	}

	/**
	 * Get all blocks list.
	 * @return all blocks. 
	 */
	public static ArrayList<Block> getBlocksBounds() {
		return blocksList;
	}

}
