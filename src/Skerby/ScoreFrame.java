/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skerby;

import javax.swing.JFrame;

/**
 * This class sets the option of Jframe you want and
 * add and set information from another class to JFrame.
 * 
 * @author Kornphon Noiprasert
 * @author Thanaphon Keawjam
 */
public class ScoreFrame {

    public static JFrame frame = new JFrame("Skerby Game");
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static DiePanel dieP;

    public static void main() {
        frame.setSize(WIDTH, HEIGHT);//to set the size of JFrame.
        frame.setLocationRelativeTo(null);//to set the location in the center of the desktop when play this game.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//to be able to close the program.
        frame.add(new ScorePanel());//to add and set information from another class to JFrame.
        frame.setResizable(false);//to inhibit the player who wants to resize the frame.
        frame.setVisible(true);// to makes the player can see this game and change to another frame.
    }
}
