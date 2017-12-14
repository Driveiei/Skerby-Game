<<<<<<< HEAD
package Skerby;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class FireballManager {
	
    static ArrayList<Fireball> fireballList = new ArrayList<>();
	
    private Fireball fb;
    
    public FireballManager(){}
    
    public FireballManager(Player player){
        if(fireballList.size() < 1 ){
            addFireball(new Fireball( player.getX() + 20, player.getY()));
        } 
    }
    
    public void render(Graphics2D g2d){
        for(int i = 0; i < fireballList.size(); i++){
            fb = fireballList.get(i);
            fb.render(g2d);
        }
    }
    
    public void update(){
        for (int i = 0; i < fireballList.size(); i++){
            fb = fireballList.get(i);
            fb.update();
        }
    }
    
    public void addFireball(Fireball a){
        fireballList.add(a);
    }
    
    public void removeFireball(Fireball a){
        fireballList.remove(a);
    }
    
    public static ArrayList<Fireball> getFireballBounds(){
        return fireballList;
    }

=======
package Skerby;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class FireballManager {
	
    static ArrayList<Fireball> fireballList = new ArrayList<>();
	
    private Fireball fb;
    
    public FireballManager(){}
    
    public FireballManager(Player player){
        if(fireballList.size() < 1 ){
            addFireball(new Fireball( player.getX() + 20, player.getY()));
        } 
    }
    
    public void render(Graphics2D g2d){
        for(int i = 0; i < fireballList.size(); i++){
            fb = fireballList.get(i);
            fb.render(g2d);
        }
    }
    
    public void update(){
        for (int i = 0; i < fireballList.size(); i++){
            fb = fireballList.get(i);
            fb.update();
        }
    }
    
    public void addFireball(Fireball a){
        fireballList.add(a);
    }
    
    public void removeFireball(Fireball a){
        fireballList.remove(a);
    }
    
    public static ArrayList<Fireball> getFireballBounds(){
        return fireballList;
    }

>>>>>>> 06492be59156b5c4a5572cd433435caf1274aceb
}