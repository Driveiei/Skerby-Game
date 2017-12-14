/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skerby;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author WIN10PRO
 */
public class ScorePanel extends JPanel implements ActionListener {

	private Image background = (new ImageIcon(this.getClass().getResource("/Images/Background/HighScore.png"))).getImage();

    private static Score[] nameAndScore = new Score[5];
    private ScoreManager sm;

    public ScorePanel() {
        sm = new ScoreManager();
        nameAndScore = sm.getNameScores();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 0, 0, null);
        this.addMouseListener(new MouseInput());
        g2d.setColor(Color.darkGray);
        g2d.setFont(new Font("Comics_Sans", Font.BOLD, 20));
        int y = 150;
        for (int i = 0; i < 5; i++) {
            if (nameAndScore[i] == null) {
            } else {
                g2d.drawString(String.format("%d.", i + 1), 30, y);
                g2d.drawString(String.format("%-12s", nameAndScore[i].getName()), 55, y);
                g2d.drawString(String.format("%5d", nameAndScore[i].getScore()), 500, y);
                y += 45;
            }
        }
        sm.deleteInformation();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
