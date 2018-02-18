/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Moveable;

import controller.ImageFinder;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.GameObject;

/**
 *
 * @author russe_000
 */
public class Block extends MoveableObject {
    
    public BufferedImage blockImg;
    
    public Block(float x, float y) {
        super(x, y);
        
        try{
            blockImg = (BufferedImage)ImageFinder.getImage("ImagesFolder", "Block.png");
        }
        catch(Exception e){ }
        
    }
    
    @Override
    public void render(Graphics2D g) {
        if(this.isAlive()){            
            g.drawImage(blockImg, (int)super.x, (int)super.y, (int)super.width, (int)super.height, null);
            
            //Draw Collision Box
            //g.setColor(Color.blue);
            //g.draw(this.getCollisionBox());        
        }                
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void collide(GameObject O){
    
    }
}
