package koalabr8game.gameobjects;

import fx.Assets;
import koalabr8game.GameWorld;

import java.awt.*;
import java.awt.image.BufferedImage;

import static javax.imageio.ImageIO.read;

public class Background {
    private static final int imgW = 640;// img width
    private static final int imgH = 480;// img height
    private BufferedImage tile,
                          rescued;

    public Background(){
        this.tile = Assets.background;
        this.rescued = Assets.num_rescued;
    }

    public void drawImage(Graphics g) {
        //Populates the game screen with the background tiles when called from GameWorld.java
        for(int row = 0; row <= GameWorld.SCREEN_WIDTH; row += imgW){
            for (int col = 0; col <= GameWorld.SCREEN_HEIGHT; col += imgH){
                g.drawImage(tile, row, col, null);
            }
        }

        //Draw "Rescued" UI sticker
        g.drawImage(rescued, 20,20,null);
        //then maybe an arraylist drawing how many koalas are rescured belowww
        int width = 170; int numRescued = 0;
        for(int i = 0; i < GameWorld.koalasRescued.size(); i++){
            if(GameWorld.koalasRescued.get(i).isRescued()){
                g.drawImage(Assets.rescued_koala, width, 20, null);
                width += 40;
                numRescued++;
            }
            else if(GameWorld.koalasDied.get(i).isHasDied()){
                g.drawImage(Assets.koalaDied, width, 20, null);
                width += 40;
            }
        }

        //Draw objective
        g.setFont(new Font("TimesRoman", Font.BOLD, 16));
        g.drawString("Objective: Get all of the Koalas to safety at the Blue Exit!", 800, 20);
    }

}
