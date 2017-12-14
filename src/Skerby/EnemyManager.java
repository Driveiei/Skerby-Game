<<<<<<< HEAD
package Skerby;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class EnemyManager {
	
    static ArrayList<Enemy> enemyList = new ArrayList<>();
	
    private Enemy enemy;
	
    public EnemyManager(){
        addEnemy(new Enemy(1050, 340, "x"));
        addEnemy(new Enemy(1750, 340, "x"));
        addEnemy(new Enemy(3250, 115, "x"));
        addEnemy(new Enemy(3100, 340, "x"));
        addEnemy(new Enemy(3500, 340, "x"));
        addEnemy(new Enemy(4500, 210, "x"));
        addEnemy(new Enemy(6241, 340, "x"));
        addEnemy(new Enemy(9620, 158, "x"));
        addEnemy(new Enemy(9840, 158, "x"));
        addEnemy(new Enemy(13688, 202, "x"));
        addEnemy(new Enemy(14432, 337, "x"));
        addEnemy(new Enemy(16702, 340, "x"));
        
        addEnemy(new Enemy(480, 30, "y"));
        addEnemy(new Enemy(800, 40, "y"));
        addEnemy(new Enemy(1300, 60, "y"));
        addEnemy(new Enemy(1650, 30, "y"));
        addEnemy(new Enemy(2500, 30, "y"));
        addEnemy(new Enemy(4200, 100, "y"));
        addEnemy(new Enemy(5100, 45, "y"));
        addEnemy(new Enemy(5540, 55, "y"));
        addEnemy(new Enemy(6310, 30, "y"));
        addEnemy(new Enemy(6497, 60, "y"));
        addEnemy(new Enemy(7598, 100, "y"));
        addEnemy(new Enemy(8747, 150, "y"));
        addEnemy(new Enemy(8894, 160, "y"));
        addEnemy(new Enemy(9034, 150, "y"));
        addEnemy(new Enemy(9150, 160, "y"));
        addEnemy(new Enemy(11196, 55, "y"));
        addEnemy(new Enemy(11508, 30, "y"));
        addEnemy(new Enemy(16044, 30, "y"));
    }
    
    public void render(Graphics2D g2d){
        for(int i = 0; i < enemyList.size(); i++){
            enemy = enemyList.get(i);
            enemy.render(g2d);
        }
    }
    
    public void update(){
        for (int i = 0; i < enemyList.size(); i++){
            enemy = enemyList.get(i);
            enemy.update();
        }
    }
    
    public void addEnemy(Enemy e){
        enemyList.add(e);
    }
    
    public void removeEnemy(Enemy e){
        enemyList.remove(e);
    }
    
    public static ArrayList<Enemy> getEnemyListBounds(){
        return enemyList;
    }

=======
package Skerby;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class EnemyManager {
	
    static ArrayList<Enemy> enemyList = new ArrayList<>();
	
    private Enemy enemy;
	
    public EnemyManager(){
        addEnemy(new Enemy(1050, 340, "x"));
        addEnemy(new Enemy(1750, 340, "x"));
        addEnemy(new Enemy(3250, 115, "x"));
        addEnemy(new Enemy(3100, 340, "x"));
        addEnemy(new Enemy(3500, 340, "x"));
        addEnemy(new Enemy(4500, 210, "x"));
        addEnemy(new Enemy(6241, 340, "x"));
        addEnemy(new Enemy(9620, 158, "x"));
        addEnemy(new Enemy(9840, 158, "x"));
        addEnemy(new Enemy(13688, 202, "x"));
        addEnemy(new Enemy(14432, 337, "x"));
        addEnemy(new Enemy(16702, 340, "x"));
        
        addEnemy(new Enemy(480, 30, "y"));
        addEnemy(new Enemy(800, 40, "y"));
        addEnemy(new Enemy(1300, 60, "y"));
        addEnemy(new Enemy(1650, 30, "y"));
        addEnemy(new Enemy(2500, 30, "y"));
        addEnemy(new Enemy(4200, 100, "y"));
        addEnemy(new Enemy(5100, 45, "y"));
        addEnemy(new Enemy(5540, 55, "y"));
        addEnemy(new Enemy(6310, 30, "y"));
        addEnemy(new Enemy(6497, 60, "y"));
        addEnemy(new Enemy(7598, 100, "y"));
        addEnemy(new Enemy(8747, 150, "y"));
        addEnemy(new Enemy(8894, 160, "y"));
        addEnemy(new Enemy(9034, 150, "y"));
        addEnemy(new Enemy(9150, 160, "y"));
        addEnemy(new Enemy(11196, 55, "y"));
        addEnemy(new Enemy(11508, 30, "y"));
        addEnemy(new Enemy(16044, 30, "y"));
    }
    
    public void render(Graphics2D g2d){
        for(int i = 0; i < enemyList.size(); i++){
            enemy = enemyList.get(i);
            enemy.render(g2d);
        }
    }
    
    public void update(){
        for (int i = 0; i < enemyList.size(); i++){
            enemy = enemyList.get(i);
            enemy.update();
        }
    }
    
    public void addEnemy(Enemy e){
        enemyList.add(e);
    }
    
    public void removeEnemy(Enemy e){
        enemyList.remove(e);
    }
    
    public static ArrayList<Enemy> getEnemyListBounds(){
        return enemyList;
    }

>>>>>>> 06492be59156b5c4a5572cd433435caf1274aceb
}