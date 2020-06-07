package koalabr8game.gameobjects.collidable.interactables.hazardous.saws;

import fx.Assets;
import koalabr8game.GameWorld;
import koalabr8game.gameobjects.collidable.noninteractable.Wall;

import java.awt.*;

public class VerticalSaw extends Saws {
    private boolean moveUp;
    private boolean moveDown;

    public VerticalSaw(int x, int y) {
        super(x, y);
        this.img = Assets.saw_v;
//        this.rect = new Rectangle(x,y, 32, 32);
        moveUp = true;
        moveDown = false;
    }

    @Override
    public void update() {
        move();
        collision();
        rect.setLocation(x, y);
    }

    @Override
    public void move() {
        if(moveUp){
            y += 3;
        }
        else if(moveDown){
            y -= 3;
        }
    }

    @Override
    public void collision() {
        for(int i = 0; i < GameWorld.mapObjects.size(); i++){
            //if saw intersect w/ wall
            if (this.getRect().intersects(GameWorld.mapObjects.get(i).getRect())){
                //collision happens

                //For Wall collisions...
                if(GameWorld.mapObjects.get(i) instanceof Wall){
                    //First we check the vertical axis
                    //if saw < objtop
                    if(y < GameWorld.mapObjects.get(i).getRectY()){
                        moveUp = false;
                        moveDown = true;
                    }
                    //if saw > objtop
                    else if(y > GameWorld.mapObjects.get(i).getRectY()){
                        moveDown = false;
                        moveUp = true;
                    }
                }

            }
        }
    }
}
