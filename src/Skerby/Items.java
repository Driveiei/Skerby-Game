/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skerby;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author WIN10PRO
 */
public class Items {
    
  
   private Image poison = (new ImageIcon(this.getClass().getResource("/Images/Items/poison.png"))).getImage();
   private Image health = (new ImageIcon(this.getClass().getResource("/Images/Items/health.png"))).getImage();

   private double x;
   private double y;
   
   private String type;
   
   public Items(double x, double y, String type){
       this.x = x;
       this.y = y;
       this.type = type;
   }
   
   public void render(Graphics2D g2d){
       if (type.equals("poison")){
           g2d.drawImage(poison, (int)x, (int)y, null);
       }
       if (type.equals("health")){
           g2d.drawImage(health, (int)x, (int)y, null);
       }
   }
   
   public String getType(){
       return type;
   }
   
   public Rectangle getItemsBounds(){
       return new Rectangle((int)x, (int)y, 45, 45);
   }
    
}