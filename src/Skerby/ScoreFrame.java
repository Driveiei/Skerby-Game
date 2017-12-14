/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skerby;

import javax.swing.JFrame;

/**
 * 
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
 *
 */

public class ScoreFrame {

    public static JFrame frame = new JFrame("Skerby Game");
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static DiePanel dieP;

    public static void main() {
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ScorePanel());
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
