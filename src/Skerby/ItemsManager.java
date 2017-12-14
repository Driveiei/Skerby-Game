/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skerby;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author WIN10PRO
 */
public class ItemsManager {
    
    static ArrayList<Items> itemsList = new ArrayList<>();
    
    private Items item;
    
    public ItemsManager(){
        addItem(new Items(1350, 90, "poison"));
        addItem(new Items(2150, 90, "poison"));
        addItem(new Items(2900, 130, "poison"));
        addItem(new Items(3580, 50, "health"));
        addItem(new Items(4000, 100, "health"));
        addItem(new Items(4600, 150, "health"));
        addItem(new Items(4700, 150, "poison"));
        addItem(new Items(5500, 50, "poison"));
        addItem(new Items(6385, 140, "health"));
        addItem(new Items(8055, 110, "poison"));
        addItem(new Items(8753, 160, "health"));
        addItem(new Items(11667, 110, "poison"));
        addItem(new Items(14749, 360, "health"));
        addItem(new Items(15525, 360, "poison"));
        addItem(new Items(16353, 360, "health"));
        addItem(new Items(16757, 360, "poison"));
        addItem(new Items(16873, 360, "poison"));
        addItem(new Items(17154, 200, "poison"));
    }
    
    public void render(Graphics2D g2d){
        for (int i = 0; i < itemsList.size(); i++){
            item = itemsList.get(i);
            item.render(g2d);
        }
    }
    
    public void addItem(Items i){
        itemsList.add(i);
    }
    
    public void removeItem(Items i){
        itemsList.remove(i);
    }
    
    public static ArrayList<Items> getItemsBounds(){
        return itemsList;
    }
}