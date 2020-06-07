package koalabr8game.gameobjects.collidable.interactables.objects;

import fx.Assets;
import koalabr8game.GameWorld;
import koalabr8game.gameobjects.GameObject;
import koalabr8game.gameobjects.collidable.interactables.hazardous.TNT;
import koalabr8game.gameobjects.collidable.interactables.hazardous.saws.Saws;
import koalabr8game.gameobjects.collidable.noninteractable.Wall;

import java.awt.*;

public class Boulder extends GameObject {
    private static final int MOVE_AMOUNT = 7;
    public Boulder(int x, int y) {
        super(x, y);
        this.img = Assets.boulder;
        this.rect = new Rectangle(x, y, img.getWidth(), img.getHeight());
    }

    public void moveDown(){
        y += MOVE_AMOUNT;
        setRectY(y);
        //collision();
    }

    public void moveUp(){
        y -= MOVE_AMOUNT;
        setRectY(y);
        //collision();
    }

    public void moveRight(){
        x += MOVE_AMOUNT;
        setRectX(x);
        //collision();
    }

    public void moveLeft(){
        x -= MOVE_AMOUNT;
        setRectX(x);
        //collision();
    }

    @Override
    public void collision() {
        for(int i = 0; i < GameWorld.mapObjects.size(); i++){
            //For Wall collisions...
            if(GameWorld.mapObjects.get(i) instanceof Wall){
                //First we check the vertical axis
                //if koalatop < objtop
                if(y <= GameWorld.mapObjects.get(i).getRectY()){
                    moveDown(); System.out.println("CONDITION 1");
                }
                //if koalato > objtop
                if(y >= GameWorld.mapObjects.get(i).getRectY()){
                    moveUp(); System.out.println("CONDITION 2");
                }

                //Now check the horizontal axis..
                //right side
                if(x < GameWorld.mapObjects.get(i).getRectX()){
                    moveRight(); System.out.println("CONDITION 3");
                }
                //left side
                if(x > GameWorld.mapObjects.get(i).getRectX()){
                    moveLeft(); System.out.println("CONDITION 4");
                }
            }
            // Hazard Collisions...
            /*if(GameWorld.mapObjects.get(i) instanceof Saws || GameWorld.mapObjects.get(i) instanceof TNT){
                if(this.getRect().intersects(GameWorld.mapObjects.get(i).getRect())){
                    GameWorld.mapObjects.remove(i);
                }
            }*/
        }
    }

    @Override
    public void drawImage(Graphics g) {
        super.drawImage(g);
    }
}
