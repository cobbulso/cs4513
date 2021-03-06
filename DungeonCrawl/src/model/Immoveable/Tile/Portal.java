/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Immoveable.Tile;

import controller.ImageFinder;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.GameData;
import model.GameObject;
import DungeonCrawl.DungeonCrawl;

/**
 *
 * @author russe_000
 */
public class Portal extends Tile {

    public BufferedImage portalImg;
    
    public Portal(float x, float y){
        super(x, y);
        
        loadImages();
    }
    
    public void loadImages(){
        try{            
            BufferedImage image = (BufferedImage)ImageFinder.getImage("ImagesFolder", "Portal.png");
            portalImg = image;
        } catch(Exception e){
            DungeonCrawl.thread.interrupt();
        }
    }
    
    @Override
    public void render(Graphics2D g) {
        g.drawImage(portalImg, (int)super.x, (int)super.y, (int)super.WIDTH, (int)super.HEIGHT, null);
        g.draw(this.getCollisionBox());
    }

    @Override
    public void collide(GameObject O) {
        if(GameData.chipsLeft == 0){
            // Need to display banner explaining level is complete
            DungeonCrawl.bannerPanel.setBannerText("You Completed Level " + GameData.currentLevel.getLevelValue());
            GameData.goToNextLevel();
        }
    }
}
