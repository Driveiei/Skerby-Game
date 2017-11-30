package Skerby;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class AttackManager {
	
    static ArrayList<Attack> attackList = new ArrayList<>();
	
    private Attack atk;
    
    public AttackManager(Player player){
        if(attackList.size() < 1 ){
        addStar(new Attack( player.getX() + 20, player.getY()));
        } 
    }
    
    public void render(Graphics2D g2d){
        for(int i = 0; i < attackList.size(); i++){
            atk = attackList.get(i);
            atk.render(g2d);
        }
    }
    
    public void update(){
        for (int i = 0; i < attackList.size(); i++){
            atk = attackList.get(i);
            atk.update();
        }
    }
    
    public void addStar(Attack a){
        attackList.add(a);
    }
    
    public void removeStar(Attack a){
        attackList.remove(a);
    }
    
    public static ArrayList<Attack> getFireBounds(){
        return attackList;
    }

}