/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skerby;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author DELL
 */
public class MouseInput implements MouseListener {

	//static int count = 0;
	static boolean create = true;
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		//count++;

		if (mouseX >= 500 && mouseX <= 615) {
			if (mouseY >= 315 && mouseY <= 430) {
				// this.setVisible(false);
				// ScoreFrame.frame.dispose();
				// //ScoreFrame.setVisible(false);
				// //Game.dieP = new DiePanel();
				// //new DiePanel().setVisible(true);//whyyyyy
				// Game.dieP.setVisible(true);
				if(create){
                                    ScoreFrame.frame.setVisible(false); 
                                    new Interface().setVisible(true);
					
					ScoreFrame.frame.dispose();
					create = false;
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
