<<<<<<< HEAD
package Skerby;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Player {
	
//    private Image playerR = new ImageIcon("src/Images/Player/playerR.png").getImage();
//    private Image playerJump = new ImageIcon("src/Images/Player/playerJump.png").getImage();
//    private Image playerAtk = new ImageIcon("src/Images/Player/playerAtk.png").getImage();
//    private Image playerAtkStar = new ImageIcon("src/Images/Player/Fireballtwo.png").getImage();
	private Image playerR = (new ImageIcon(this.getClass().getResource("/Images/Player/playerR.png"))).getImage();
	private Image playerJump = (new ImageIcon(this.getClass().getResource("/Images/Player/playerJump.png"))).getImage();
	private Image playerAtk = (new ImageIcon(this.getClass().getResource("/Images/Player/playerAtk.png"))).getImage();
	private Image playerAtkStar = (new ImageIcon(this.getClass().getResource("/Images/Player/Fireballtwo.png"))).getImage();

//    private Image playerAtk2 = new ImageIcon("Images/Player/playerAtk2.png").getImage();
    
    private boolean attack = false;
    private boolean right;
    private boolean left;
    
    private boolean jumping = true;
    private double jumpSpeed = 6;
    private double currentJumpSpeed = jumpSpeed;
    
    private boolean falling = true;
    private double maxFallSpeed = 6;
    private double currentFallSpeed = 0.1;
   
    private double x ;
    private double y;
    private int playerHP;

    private EnemyManager em;
    private CoinsManager cm;
    //add
    //private AttackManager am;
    private FireballManager fbm;
    private ItemsManager im;
    
    
    private double starterJump = -100;
    private boolean inAir = false;
    private int bugJump = 100;

    static int score = 0;
    
    static ArrayList<Coins> cl = CoinsManager.getCoinsBounds();
    static ArrayList<Enemy> el = EnemyManager.getEnemyListBounds();
//    static ArrayList<Attack> al = AttackManager.getFireBounds();
    //add
    static ArrayList<Fireball> fbl = FireballManager.getFireballBounds();
    static ArrayList<Items> il = ItemsManager.getItemsBounds();
    
    //new
    static ArrayList<Block> bl = BlockManager.getBlocksBounds();
    private final int playerWidth = 64;
    private final int playerHeight = 64;
    
    private JOptionPane frame;

    private int count = 0;
    
    public Player(int hp){
        x = 140;
        y = 200;
        this.playerHP = hp;
    }
    
    public void update(){
//        System.out.print("Falling =");
//        System.out.println(currentFallSpeed);
        if (right){
            x += 4;
        }
        if (left) {
            x -= 4;
        }
        if (attack){
		fbm = new FireballManager(this); // oneRound
        }
        if (jumping){
            y -= currentJumpSpeed;
            currentJumpSpeed -= 0.1;
            if (currentJumpSpeed <= 0){
                currentJumpSpeed = jumpSpeed;
                jumping = false;
                falling = true;
            }
        }
        
//        if(count == 1 && currentJumpSpeed > 1.4 && currentJumpSpeed < 1.5){
//                jumping = false;
//                falling = true;
//        }
//        
//        if(count == 1 && currentJumpSpeed > 2.1 && currentJumpSpeed < 2.2){
//                jumping = false;
//                falling = true;
//        }

        if(y < starterJump+0.1 && count == 1 && currentFallSpeed > 5){
            jumping = false;
            falling = true;
            currentFallSpeed = 4;
        }
        
        if(currentJumpSpeed >0.1 && currentJumpSpeed < 5.9){
            inAir =true;
        }
        
        if(count == 2){
            bugJump = 2;
        } else {
            bugJump = 3;
        }

        if (falling){
            y += currentFallSpeed;
            
            if (currentFallSpeed < maxFallSpeed){                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
                currentFallSpeed += 0.15;
            }
        }
        if (!falling) {
            currentFallSpeed = 0.1;
        }
        if (x < 140) x = 140;
        if (x > 17700) x = 17700; // change
        //new
        if (y > 450) {
            playerHP = 0;
        }
//        if (y > 360) y = 360;
        if (y < 0) y = 0;
        colisionCoins();
        colisionEnemy();
        //new
        colisionBlocks();
        fireBallEnemy();
        fireBallBlock();
        colisionItems();
//add
        if(playerHP <= 0){

//            Game.dieP = new DiePanel();
//            Game.dieP.setVisible(true);
//            Game.window.dispose();
//            JOptionPane.showMessageDialog(null, EnterYourName.yourName+" is die.");
//            Object[] options = {"Yes, please",
//                    "No, thanks",
//                    "No eggs, no ham!"};
//                    int n = JOptionPane.showOptionDialog(frame,
//                    "Would you like some green eggs to go "
//                    + "with that ham?",
//                    "A Silly Question",
//                    JOptionPane.YES_NO_CANCEL_OPTION,
//                    JOptionPane.QUESTION_MESSAGE,
//                    null,
//                    options,
//                    options[2]);
        
        
        
        
        }
        if(playerHP < 0){
            this.playerHP = 0;
        }
    }
    
    public void render(Graphics2D g2d){
        if (jumping == true) {
            g2d.drawImage(playerJump, (int)x, (int)y, null);
        }else if (attack == true){
        	g2d.drawImage(playerR, (int)x, (int)y, null);
                fbm.render(g2d);
        }else {
            g2d.drawImage(playerR, (int)x, (int)y, null);
        }
      //add for test
      //g2d.drawImage(playerAtkStar, (int)x+80, (int)y+32, null);
//      g3d.draw(getBoundsRight());
//      g3d.draw(getBoundsLeft());
//      g3d.draw(getBoundsTop());

    }
    
    public double getX(){
        return x;
    }
    
    public int getY(){
        return (int)y;
    }
    
     public int getPlayerHeight(){
        return (int)playerHeight;
    }
     
      public int getPlayerWidth(){
        return (int)playerWidth;
    }
      
      public boolean getAttack(){
        return attack;
    }
    
    public static int getScore(){
        return score;
    }
    
    public int getPlayerHP(){
        return playerHP;
    }
    
    public boolean doubleJump(){
    	if(count <= 1 ){
                //may be bug 
                currentJumpSpeed += 0.5;
    		falling = false;
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public void keyPressed(KeyEvent k){
        int key = k.getKeyCode();
        if (key == KeyEvent.VK_LEFT){
           left = true;
        }
        if (key == KeyEvent.VK_RIGHT){
            right = true;
        }
        if ((key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP) && (canJump() || doubleJump()) ){
            count++;
            starterJump = y;
            jumping = true;
        }
        if (key == KeyEvent.VK_Z){
            attack = true;
        }
    }
    
    public void keyReleased(KeyEvent k){
        int key = k.getKeyCode();
        if (key == KeyEvent.VK_LEFT){
            left = false;
        }
        if (key == KeyEvent.VK_RIGHT){
            right = false;
        }
        if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP){

        }
        if (key == KeyEvent.VK_Z){
            attack = false;
        }
    }
    
    public boolean canJump(){
    	for(int i = 0; i<bl.size();i++){
    		if(getBoundsDown().intersects(bl.get(i).getBlockBounds())){
    			count = 0;
    			return true;
    		}
    	}
    	return false;
    }
    
    /*
    public Rectangle getPlayerBounds(){
        return new Rectangle((int)x, (int)y, 64, 64);
    } */
    
    //new
    public Rectangle getBoundsDown(){
    	return new Rectangle((int)x+5,(int)y+playerHeight,(int)playerWidth-16,(int)5);
    }
    
    public Rectangle getBoundsTop(){
    	return new Rectangle((int)x+11,(int)y+(playerHeight/5),(int)playerWidth-25,(int)5);
    }
    
    public Rectangle getBoundsRight(){
      	return new Rectangle((int)x+playerWidth-8,(int)y+(playerHeight/4),(int)5,(int)playerHeight-25);
    }
    
    public Rectangle getBoundsLeft(){
    	return new Rectangle((int)x-5,(int)y+(playerHeight/4),(int)5,(int)playerHeight-25);
    }
    
  //new
    public boolean coinOrNot(int i){
    	if(getBoundsDown().intersects(cl.get(i).getCoinsBounds())){
    		return true;
    	} else if(getBoundsTop().intersects(cl.get(i).getCoinsBounds())){
    		return true;
    	} else if(getBoundsRight().intersects(cl.get(i).getCoinsBounds())){
    		return true;
    	} else if(getBoundsLeft().intersects(cl.get(i).getCoinsBounds())){
    		return true;
    	} else {
    		return false;
    	}
    }

    
    public void colisionCoins(){
        for (int i = 0; i < cl.size(); i++){
 //           if (getPlayerBounds().intersects(cl.get(i).getCoinsBounds())){
        	//new
        	if (coinOrNot(i)){
        		cl.remove(i);
                score += 10;
            }
        }
    }
    
  //new
    public boolean enemyOrNot(int i){
    	if(getBoundsDown().intersects(el.get(i).getEnemyBounds())){
    		return true;
    	} else if(getBoundsTop().intersects(el.get(i).getEnemyBounds())){
    		return true;
    	} else if(getBoundsRight().intersects(el.get(i).getEnemyBounds())){
    		return true;
    	} else if(getBoundsLeft().intersects(el.get(i).getEnemyBounds())){
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public void colisionEnemy(){
        for (int i = 0; i < el.size(); i++){
//            if  (getPlayerBounds().intersects(el.get(i).getEnemyBounds())){
            //new
        	if (enemyOrNot(i)){	
            	if (attack){
                    el.remove(i);
                    score += 15;
                }else {
                    playerHP -= 1;
                }
            }
        }
    }
    
  //new
    public void colisionBlocks(){
        for (int i = 0; i < bl.size(); i++){
            if (getBoundsDown().intersects(bl.get(i).getBlockBounds())){
                //currentFallSpeed = 0; 
                //currentJumpSpeed = 6;
                
                currentFallSpeed = 0; //original
                //if(count != 2 && jumping == false){
                if(falling){
                currentJumpSpeed = 6; 
                }// }
            	//y -= currentJumpSpeed;
            }
        }
        for (int i = 0; i < bl.size(); i++){
            if (getBoundsTop().intersects(bl.get(i).getBlockBounds())){
            	falling = true;
            	jumping = false;
                //y+=15; //original
            	//y += currentJumpSpeed;
            	//y += currentFallSpeed;
            	
            } 
        }
        for (int i = 0; i < bl.size(); i++){
            if (getBoundsLeft().intersects(bl.get(i).getBlockBounds())){
                x += 5;
            } 
        }
        for (int i = 0; i < bl.size(); i++){
            if (getBoundsRight().intersects(bl.get(i).getBlockBounds())){
                x -= 5;
            } 
        }
    }
    
    public void colisionItems() {
        for (int i = 0; i < il.size(); i++) {
            if (itemOrNot(i) == true && il.get(i).getType().equals("poison")) {
                playerHP -= 10;
                il.remove(i);
            }else   if (itemOrNot(i) == true && il.get(i).getType().equals("health")) {
                playerHP += 15;
                il.remove(i);
                if (playerHP > 100) {
                    playerHP = 100;
                }
            }
        }
    }

    public boolean itemOrNot(int i) {
        if (getBoundsDown().intersects(il.get(i).getItemsBounds())) {
            return true;
        } else if (getBoundsTop().intersects(il.get(i).getItemsBounds())) {
            return true;
        } else if (getBoundsRight().intersects(il.get(i).getItemsBounds())) {
            return true;
        } else if (getBoundsLeft().intersects(il.get(i).getItemsBounds())) {
            return true;
        } else {
            return false;
        }
    }
    
    public void fireBallEnemy(){
        for (int i = 0; i < el.size(); i++){
//            if  (getPlayerBounds().intersects(el.get(i).getEnemyBounds())){
            //new

                try{
                    if (fbl.get(0).getFireballBounds().intersects(el.get(i).getEnemyBounds())){	
                    el.remove(i);
                    fbl.remove(0);
                    score += 15;
                }
                    if (fbl.get(0).getX() > 17700) {
                        fbl.remove(0);
                    }
                }catch(Exception e){
                    
                }
            
        }
    }
    
    public void fireBallBlock(){
    	 for (int i = 0; i < bl.size(); i++) {
             try {
                 if (fbl.get(0).getFireballBounds().intersects(bl.get(i).getBlockBounds())) {
                     fbl.remove(0);
                 }
                 if (fbl.get(0).getX() > 17700) {
                     fbl.remove(0);
                 }
             } catch (Exception e) {

             }

         }
     }
    

}
=======
package Skerby;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Player {

    private Image playerR = new ImageIcon("Images\\Player\\playerR.png").getImage();
    private Image playerJump = new ImageIcon("Images\\Player\\playerJump.png").getImage();
    private Image playerAtk = new ImageIcon("Images\\Player\\playerAtk.png").getImage();
    private Image playerAtkStar = new ImageIcon("Images\\Player\\Fireballtwo.png").getImage();

    private boolean attack = false;
    private boolean right;
    private boolean left;

    private boolean jumping = true;
    private double jumpSpeed = 6;
    private double currentJumpSpeed = jumpSpeed;

    private boolean falling = true;
    private double maxFallSpeed = 6;
    private double currentFallSpeed = 0.1;

    private double x;
    private double y;
    private int playerHP;

    private EnemyManager em;
    private CoinsManager cm;
    private FireballManager fbm;
    private ItemsManager im;

    private int score = 0;

    static ArrayList<Coins> cl = CoinsManager.getCoinsBounds();
    static ArrayList<Enemy> el = EnemyManager.getEnemyListBounds();
    static ArrayList<Fireball> fbl = FireballManager.getFireballBounds();
    static ArrayList<Block> bl = BlockManager.getBlocksBounds();
    static ArrayList<Items> il = ItemsManager.getItemsBounds();

    private final int playerWidth = 64;
    private final int playerHeight = 64;

    private JOptionPane frame;

    private int count = 0;

    public Player(int hp) {
        x = 140;
        y = 200;
        this.playerHP = hp;
    }

    public void update() {
//        System.out.println(currentJumpSpeed);
//        System.out.println(x + " x");
//        System.out.println(y + " y");
        if (right) {
            x += 4;
        }
        if (left) {
            x -= 4;
        }
        if (attack) {
            fbm = new FireballManager(this); // oneRound
        }
        if (jumping) {
            y -= currentJumpSpeed;
            currentJumpSpeed -= 0.1;
            if (currentJumpSpeed <= 0) {
                currentJumpSpeed = jumpSpeed;
                jumping = false;
                falling = true;
            }
        }
        if (falling) {
            y += currentFallSpeed;
            if (currentFallSpeed < maxFallSpeed) {
                currentFallSpeed += 0.15;
            }
        }
        if (!falling) {
            currentFallSpeed = 0.1;
        }
        if (x < 140) {
            x = 140;
        }
        if (x > 17700) {
            x = 17700;
        }
        //new
        if (y > 450) {
            playerHP = 0;
        }
        if (y < 0) {
            y = 0;
        }
/*        if (y > 340) {
            y = 340;
        } */
        colisionCoins();
        colisionEnemy();
        colisionBlocks();
        colisionItems();
        fireBallEnemy();
        fireBallBlock();
        if (playerHP == 0) {
//            Game.dieP = new DiePanel();
//            Game.dieP.setVisible(true);
//            Game.window.dispose();
            //JOptionPane.showMessageDialog(null, EnterYourName.yourName+" is die.");
//            Object[] options = {"Yes, please",
//                    "No, thanks",
//                    "No eggs, no ham!"};
//                    int n = JOptionPane.showOptionDialog(frame,
//                    "Would you like some green eggs to go "
//                    + "with that ham?",
//                    "A Silly Question",
//                    JOptionPane.YES_NO_CANCEL_OPTION,
//                    JOptionPane.QUESTION_MESSAGE,
//                    null,
//                    options,
//                    options[2]);

        }
        if (playerHP < 0) {
            this.playerHP = 0;
        }
    }

    public void render(Graphics2D g2d) {
        if (jumping == true) {
            g2d.drawImage(playerJump, (int) x, (int) y, null);
        } else if (attack == true) {
            g2d.drawImage(playerR, (int) x, (int) y, null);
            fbm.render(g2d);
        } else {
            g2d.drawImage(playerR, (int) x, (int) y, null);
        }
        //add for test
        //g2d.drawImage(playerAtkStar, (int)x+80, (int)y+32, null);
//      g3d.draw(getBoundsRight());
//      g3d.draw(getBoundsLeft());
//      g3d.draw(getBoundsTop());

    }

    public double getX() {
        return x;
    }

    public int getY() {
        return (int) y;
    }

    public int getPlayerHeight() {
        return (int) playerHeight;
    }

    public int getPlayerWidth() {
        return (int) playerWidth;
    }

    public boolean getAttack() {
        return attack;
    }

    public int getScore() {
        return score;
    }

    public int getPlayerHP() {
        return playerHP;
    }

    public boolean doubleJump() {
        if (count <= 1) {
            falling = false;
            return true;
        } else {
            return false;
        }
    }

    public void keyPressed(KeyEvent k) {
        int key = k.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            right = true;
        }
        if ((key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP) && (canJump() || doubleJump())) {
            count++;
            jumping = true;
        }
        if (key == KeyEvent.VK_Z) {
            attack = true;
        }
    }

    public void keyReleased(KeyEvent k) {
        int key = k.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            left = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            right = false;
        }
        if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP) {

        }
        if (key == KeyEvent.VK_Z) {
            attack = false;
        }
    }

    public boolean canJump() {
        for (int i = 0; i < bl.size(); i++) {
            if (getBoundsDown().intersects(bl.get(i).getBlockBounds())) {
                count = 0;
                return true;
            }
        }
        return false;
    }

    public Rectangle getBoundsDown() {
        return new Rectangle((int) x + 5, (int) y + playerHeight, (int) playerWidth - 16, (int) 5);
    }

    public Rectangle getBoundsTop() {
        return new Rectangle((int) x + 11, (int) y + (playerHeight / 5), (int) playerWidth - 25, (int) 5);
    }

    public Rectangle getBoundsRight() {
        return new Rectangle((int) x + playerWidth - 8, (int) y + (playerHeight / 4), (int) 5, (int) playerHeight - 25);
    }

    public Rectangle getBoundsLeft() {
        return new Rectangle((int) x - 5, (int) y + (playerHeight / 4), (int) 5, (int) playerHeight - 25);
    }

    //new
    public boolean coinOrNot(int i) {
        if (getBoundsDown().intersects(cl.get(i).getCoinsBounds())) {
            return true;
        } else if (getBoundsTop().intersects(cl.get(i).getCoinsBounds())) {
            return true;
        } else if (getBoundsRight().intersects(cl.get(i).getCoinsBounds())) {
            return true;
        } else if (getBoundsLeft().intersects(cl.get(i).getCoinsBounds())) {
            return true;
        } else {
            return false;
        }
    }

    public void colisionCoins() {
        for (int i = 0; i < cl.size(); i++) {
            //           if (getPlayerBounds().intersects(cl.get(i).getCoinsBounds())){
            //new
            if (coinOrNot(i)) {
                cl.remove(i);
                score += 10;
            }
        }
    }

    //new
    public boolean enemyOrNot(int i) {
        if (getBoundsDown().intersects(el.get(i).getEnemyBounds())) {
            return true;
        } else if (getBoundsTop().intersects(el.get(i).getEnemyBounds())) {
            return true;
        } else if (getBoundsRight().intersects(el.get(i).getEnemyBounds())) {
            return true;
        } else if (getBoundsLeft().intersects(el.get(i).getEnemyBounds())) {
            return true;
        } else {
            return false;
        }
    }

    public void colisionEnemy() {
        for (int i = 0; i < el.size(); i++) {
//            if  (getPlayerBounds().intersects(el.get(i).getEnemyBounds())){
            //new
            if (enemyOrNot(i)) {
                if (attack) {
                    el.remove(i);
                    score += 15;
                } else {
                    playerHP -= 1;
                }
            }
        }
    }

    //new
    public void colisionBlocks() {
        for (int i = 0; i < bl.size(); i++) {
            if (getBoundsDown().intersects(bl.get(i).getBlockBounds())) {
                //currentFallSpeed = 0; 
                //currentJumpSpeed = 6;
                currentFallSpeed = 0; //original
                currentJumpSpeed = 6;
                //y -= currentJumpSpeed;
            }
        }
        for (int i = 0; i < bl.size(); i++) {
            if (getBoundsTop().intersects(bl.get(i).getBlockBounds())) {
                falling = true;
                jumping = false;
                //y+=15; //original
                //y += currentJumpSpeed;
                //y += currentFallSpeed;
            }
        }
        for (int i = 0; i < bl.size(); i++) {
            if (getBoundsLeft().intersects(bl.get(i).getBlockBounds())) {
                x += 5;
            }
        }
        for (int i = 0; i < bl.size(); i++) {
            if (getBoundsRight().intersects(bl.get(i).getBlockBounds())) {
                x -= 5;
            }
        }
    }

    public void colisionItems() {
        for (int i = 0; i < il.size(); i++) {
            if (itemOrNot(i) == true && il.get(i).getType().equals("poison")) {
                playerHP -= 10;
                il.remove(i);
            }
            if (itemOrNot(i) == true && il.get(i).getType().equals("health")) {
                playerHP += 15;
                il.remove(i);
                if (playerHP > 100) {
                    playerHP = 100;
                }
            }
        }
    }

    public boolean itemOrNot(int i) {
        if (getBoundsDown().intersects(il.get(i).getItemsBounds())) {
            return true;
        } else if (getBoundsTop().intersects(il.get(i).getItemsBounds())) {
            return true;
        } else if (getBoundsRight().intersects(il.get(i).getItemsBounds())) {
            return true;
        } else if (getBoundsLeft().intersects(il.get(i).getItemsBounds())) {
            return true;
        } else {
            return false;
        }
    }

    public void fireBallEnemy() {
        for (int i = 0; i < el.size(); i++) {
//            if  (getPlayerBounds().intersects(el.get(i).getEnemyBounds())){
            //new

            try {
                if (fbl.get(0).getFireballBounds().intersects(el.get(i).getEnemyBounds())) {
                    el.remove(i);
                    fbl.remove(0);
                    score += 15;
                }
                if (fbl.get(0).getX() > 17700) {
                    fbl.remove(0);
                }
            } catch (Exception e) {

            }

        }
    }

    public void fireBallBlock() {
        for (int i = 0; i < bl.size(); i++) {
            try {
                if (fbl.get(0).getFireballBounds().intersects(bl.get(i).getBlockBounds())) {
                    fbl.remove(0);
                }
                if (fbl.get(0).getX() > 17700) {
                    fbl.remove(0);
                }
            } catch (Exception e) {

            }

        }
    }

}
>>>>>>> 06492be59156b5c4a5572cd433435caf1274aceb
