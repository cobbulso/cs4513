
package controller;

import DungeonCrawl.DungeonCrawl;
import model.GameData;
import model.GameObject;

public class Animator implements Runnable {

    public boolean running;
    private final int FRAMES_PER_SECOND = 15;

    @Override
    public void run() {
        running = true;

        while (running && GameData.time > 0) {
            long startTime = System.currentTimeMillis();

            if (GameData.levelInProgress) {
                DungeonCrawl.gameData.update();
                processCollisions();
                DungeonCrawl.gamePanel.gameRender();
                DungeonCrawl.gamePanel.printScreen();
                DungeonCrawl.inventoryPanel.updateInventoryPanel();
            } else {
                DungeonCrawl.bannerPanel.setVisible(true);
                DungeonCrawl.gamePanel.requestFocus();
            }

            long endTime = System.currentTimeMillis();
            int sleepTime = (int) (1.0 / FRAMES_PER_SECOND * 1000)
                    - (int) (endTime - startTime);

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime); // ms
                } catch (InterruptedException e) {

                }
            }
        }
    }

    private void processCollisions() {
        for (GameObject object : GameData.gameObjects) {
            for (GameObject go : GameData.gameObjects) {
                if (object != go && object.getCollisionBox().intersects(
                        go.getCollisionBox())) {
                    //System.out.println(object.getClass() + " " + go.getClass());
                    object.collide(go);
                }
            }            
        }                                
    }
}
