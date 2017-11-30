package Skerby;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class EnemyManager {
	
    static ArrayList<Enemy> enemyList = new ArrayList<>();
	
    private Enemy enemy;
	
    public EnemyManager(){
        addEnemy(new Enemy(1050, 340));
        addEnemy(new Enemy(1750, 340));
        addEnemy(new Enemy(3250, 115));
        addEnemy(new Enemy(3100, 340));
        addEnemy(new Enemy(3500, 340));
        addEnemy(new Enemy(4500, 210));
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

}