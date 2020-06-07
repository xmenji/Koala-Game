package koalabr8game.gameobjects.collidable.interactables.hazardous.saws;

import fx.Assets;
import koalabr8game.GameWorld;
import koalabr8game.gameobjects.collidable.noninteractable.Wall;

import java.awt.*;

public class HorizontalSaw extends Saws {
    private boolean moveRight;
    private boolean moveLeft;

    public HorizontalSaw(int x, int y) {
        super(x, y);
        this.img = Assets.saw_h;
//        this.rect = new Rectangle(x,y, 32, 32);
        moveRight = true;
        moveLeft = false;
    }

    @Override
    public void update() {
        move();
        collision();
        rect.setLocation(x, y);
    }

    @Override
    public void move() {
        if(moveRight){
            x += 3;
        }
        else if(moveLeft){
            x -= 3;
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
                    //check the horizontal axis..

                    //right side
                    if(x < GameWorld.mapObjects.get(i).getRectX()){
                        moveRight = false;
                        moveLeft = true;
                    }
                    //left side
                    else if(x > GameWorld.mapObjects.get(i).getRectX()){
                        moveLeft = false;
                        moveRight = true;
                    }
                }

            }
        }
    }
}
