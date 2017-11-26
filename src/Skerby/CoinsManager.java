package Skerby;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class CoinsManager {
	
    static ArrayList<Coins> coinsList = new ArrayList<>();
    private Coins coins;
    
    public CoinsManager(){
        for (int i = 0; i < 180; i += 60){
            addCoin(new Coins(255 + i, 360));
        }
        addCoin(new Coins(445, 310));
        
        for (int i = 0; i < 210; i+=70){
            addCoin(new Coins(550 + i, 200));
        }
        
        for (int i = 0; i < 250; i+=50){
            addCoin(new Coins(550 + i, 90));
        }
        
        addCoin(new Coins(1450, 130));
        addCoin(new Coins(1500, 130));
        addCoin(new Coins(1550, 130));
        
        for (int i = 0; i < 350; i+=50){
            addCoin(new Coins(1800 + i, 350));
        }
        
        addCoin(new Coins(1950, 220));
        addCoin(new Coins(2000, 220));
        
        for (int i = 0; i < 150; i+=50){
            addCoin(new Coins(2200 + i, 80));
        }
        
        addCoin(new Coins(2400, 130));
        addCoin(new Coins(2450, 180));
        addCoin(new Coins(2490, 230));
        addCoin(new Coins(2530, 270));
        addCoin(new Coins(2570, 320));
        
        addCoin(new Coins(3100, 270));
        addCoin(new Coins(3150, 270));
        addCoin(new Coins(3200, 270));
                
        addCoin(new Coins(3550, 270));
        addCoin(new Coins(3600, 270));
        
        for (int i = 0; i < 550; i+=50){
            addCoin(new Coins(4350 + i, 220));
        }
        
        for (int i = 0; i < 550; i+=50){
            addCoin(new Coins(4350 + i, 90));
        }
        
        addCoin(new Coins(5300, 50));
    }
    
    public void render(Graphics2D g2d){
        for (int i = 0; i < coinsList.size(); i++){
            coins = coinsList.get(i);
            coins.render(g2d);
        }
    }
    
    public void addCoin(Coins c){
        coinsList.add(c);
    }
    
    public void removeCoin(Coins c){
        coinsList.remove(c);
    }
    
    public static ArrayList<Coins> getCoinsBounds(){
        return coinsList;
    }

}
