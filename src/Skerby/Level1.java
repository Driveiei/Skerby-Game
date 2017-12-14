package Skerby;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Level1 {
    private Image arrowLeft = new ImageIcon("Images/StateLV1/arrowLeft.png").getImage();
    private Image arrowRight = new ImageIcon("Images/StateLV1/arrowRight.png").getImage();
    private Image arrowUp = new ImageIcon("Images/StateLV1/arrowUp.png").getImage();
    private Image spacebar = new ImageIcon("Images/StateLV1/spacebar.png").getImage();
    private Image z = new ImageIcon("Images/StateLV1/z.png").getImage();
    private Image warpgate = new ImageIcon("Images/StateLV1/WarpGate.png").getImage();

    private BlockManager bm;
    
    static ArrayList<Block> blockList = new ArrayList<>();

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

        bm = new BlockManager(550, 270, 3, 5, "Stair"); // x,y,height,width
        bm = new BlockManager(2395, 180, 5, 1, "Stair"); // x,y,height,width
        bm = new BlockManager(3610, 45, 4, 1, "Stair"); // x,y,height,width
        bm = new BlockManager(4330, 270, 4, 15, "Stair"); // x,y,height,width

    	bm = new BlockManager(3070,405,30,5,5);
    }
    
    public void render(Graphics2D g2d){
        g2d.setColor(Color.black);
        g2d.setFont(new Font("Fluo_Gums", Font.BOLD, 20));
        g2d.drawImage(arrowLeft, 30, 350, null);
        g2d.drawImage(arrowRight, 80, 350, null);
        g2d.drawString("Left / Right", 125, 373);
        g2d.drawImage(arrowUp, 30, 300, null);
        g2d.drawString("or", 70, 322);
        g2d.drawImage(spacebar, 105, 300, null);
        g2d.drawString("Jump", 150, 325);
        g2d.drawImage(z, 30, 250, null);
        g2d.drawString("Attack", 90, 275);
        g2d.setColor(Color.PINK);
        g2d.drawOval(145,232,60,60);
        //g2d.fillOval(145,232,60,60);
        g2d.drawImage(warpgate, 118, 200,null);
        g2d.drawOval(5652,142,60,60);
       // g2d.fillOval(5652,142,60,60);
        g2d.drawImage(warpgate, 5625, 110,null);
        bm.render(g2d);
        
    }

}
