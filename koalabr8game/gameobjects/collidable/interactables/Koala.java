package koalabr8game.gameobjects.collidable.interactables;

import fx.Assets;
import koalabr8game.GameWorld;
import koalabr8game.gameobjects.GameObject;
import koalabr8game.gameobjects.collidable.Collision;
import koalabr8game.gameobjects.collidable.interactables.exits.BlueExit;
import koalabr8game.gameobjects.collidable.interactables.hazardous.TNT;
import koalabr8game.gameobjects.collidable.interactables.hazardous.saws.Saws;
import koalabr8game.gameobjects.collidable.interactables.objects.Boulder;
import koalabr8game.gameobjects.collidable.interactables.objects.locks.BlueLock;
import koalabr8game.gameobjects.collidable.interactables.objects.locks.Locks;
import koalabr8game.gameobjects.collidable.interactables.objects.locks.RedLock;
import koalabr8game.gameobjects.collidable.interactables.objects.switches.BlueSwitch;
import koalabr8game.gameobjects.collidable.interactables.objects.switches.RedSwitch;
import koalabr8game.gameobjects.collidable.noninteractable.Wall;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Koala extends GameObject implements Collision {
    protected int   x,
            y,
            vx,
            vy,
            angle;
    private boolean isRescued; //helps keep track of which koalas have been successfully rescued
    private boolean hasDied; //keeps track of whether this koala has died or not


    private final int R = 2;
    protected BufferedImage img;

    private boolean UpPressed;
    private boolean DownPressed;
    private boolean RightPressed;
    private boolean LeftPressed;


    public Koala(int x, int y, int vx, int vy, int angle) {
        super(x,y);
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.img = Assets.koala;
        this.angle = angle;
        this.rect = new Rectangle(x,y, img.getWidth(), img.getHeight());
        isRescued = false;
        hasDied = false;
    }


    public void toggleUpPressed() {
        this.UpPressed = true;
    }

    public void toggleDownPressed() {
        this.DownPressed = true;
    }

    public void toggleRightPressed() {
        this.RightPressed = true;
    }

    public void toggleLeftPressed() {
        this.LeftPressed = true;
    }

    public void unToggleUpPressed() {
        this.UpPressed = false;
    }

    public void unToggleDownPressed() {
        this.DownPressed = false;
    }

    public void unToggleRightPressed() {
        this.RightPressed = false;
    }

    public void unToggleLeftPressed() {
        this.LeftPressed = false;
    }



    public void update() {
            if (this.UpPressed) {
                this.moveUp();
            }
            if (this.DownPressed) {
                this.moveDown();
            }
            if (this.LeftPressed) {
                this.moveLeft();
            }
            if (this.RightPressed) {
                this.moveRight();
            }

        rect.setLocation(x,y);

        //check collision here
        collision();
    }

    private void moveUp() {
        y -= 3;
        checkBorder();
    }

    private void moveDown() {
        y += 3;
        checkBorder();
    }

    private void moveLeft() {
        vx = (int) Math.round(R * Math.cos(Math.toRadians(angle)));
        vy = (int) Math.round(R * Math.sin(Math.toRadians(angle)));
        x -= vx;
        y -= vy;
        checkBorder();
    }

    private void moveRight() {
        vx = (int) Math.round(R * Math.cos(Math.toRadians(angle)));
        vy = (int) Math.round(R * Math.sin(Math.toRadians(angle)));
        x += vx;
        y += vy;
        checkBorder();
    }

    public boolean isRescued() {
        return isRescued;
    }

    public void setRescued(boolean rescued) {
        isRescued = rescued;
    }

    public boolean isHasDied() {
        return hasDied;
    }

    public void setHasDied(boolean hasDied) {
        this.hasDied = hasDied;
    }


    private void checkBorder() {
        if (x < 30) {
            x = 30;
        }
        if (x >= GameWorld.SCREEN_WIDTH - 88) {
            x = GameWorld.SCREEN_WIDTH - 88;
        }
        //Top portion of the screen
        if (y < 120) {
            y = 120;
        }
        if (y >= GameWorld.SCREEN_HEIGHT - 20) { //88
            y = GameWorld.SCREEN_HEIGHT - 20;
        }
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y + ", angle=" + angle;
    }

    public void koalaCollision(Koala koala){
        if(this.getRect().intersects(koala.getRect())){
            if(y < koala.getRectY()){
                vx = 0; vy = 0; y-=3;
            }
            //if koalatop > objtop
            else if(y > koala.getRectY()){
                vx = 0; vy = 0; y+=3;
            }

            //Now check the horizontal axis..
            //right side
            if(x < koala.getRectX()){
                vx = 0; vy = 0; x-=3;
            }
            //left side
            else if(x > koala.getRectX()){
                vx = 0; vy = 0; x+=3;
            }
        }
    }
    @Override
    public void collision() {
        //iterate through the map object and check for collision
        for(int i = 0; i < GameWorld.mapObjects.size(); i++){
            //if tank intersect w/ obj
            if (this.getRect().intersects(GameWorld.mapObjects.get(i).getRect())){
                //collision happens

                //For Wall collisions...
                if(GameWorld.mapObjects.get(i) instanceof Wall){
                    //First we check the vertical axis
                    //if koalatop < objtop
                    if(y < GameWorld.mapObjects.get(i).getRectY()){
                        vx = 0; vy = 0; y-=3;
                    }
                    //if koalato > objtop
                    else if(y > GameWorld.mapObjects.get(i).getRectY()){
                        vx = 0; vy = 0; y+=3;
                    }

                    //Now check the horizontal axis..
                    //right side
                    if(x < GameWorld.mapObjects.get(i).getRectX()){
                        vx = 0; vy = 0; x-=3;
                    }
                    //left side
                    else if(x > GameWorld.mapObjects.get(i).getRectX()){
                        vx = 0; vy = 0; x+=3;
                    }
                }

                //Boulder collision
                /*could not get boulder collision to work right.
                boulders disappear anytime a koala interacts with it
                which should not be happening.
                * */
                /*if(GameWorld.mapObjects.get(i) instanceof Boulder){
                    //if koalatop < objtop
                    //touches top of the boulder
                    if(y < GameWorld.mapObjects.get(i).getRectY()){
                         vy = 0; y-=3;
                        ((Boulder) GameWorld.mapObjects.get(i)).moveDown();
                    }
                    //if koalato > objtop
                    else if(y > GameWorld.mapObjects.get(i).getRectY()){
                         vy = 0; y+=3;
                         ((Boulder) GameWorld.mapObjects.get(i)).moveUp();
                    }

                    //Now check the horizontal axis..
                    //right side
                    if(x < GameWorld.mapObjects.get(i).getRectX()){
                        vx = 0; x-=3;
                        ((Boulder) GameWorld.mapObjects.get(i)).moveRight();
                    }
                    //left side
                    else if(x > GameWorld.mapObjects.get(i).getRectX()){
                        vx = 0; x+=3;
                        ((Boulder) GameWorld.mapObjects.get(i)).moveLeft();
                    }

                }*/

                //TNT collision...
                if(GameWorld.mapObjects.get(i) instanceof TNT){
                    //Koala is destroyed
                    this.hasDied = true;
                    GameWorld.koalas.remove(this);
                    GameWorld.mapObjects.remove(i);
                }

                //Saw collision...
                if(GameWorld.mapObjects.get(i) instanceof Saws){
                    this.hasDied = true;
                    GameWorld.koalas.remove(this);
                }

                //Blue Exit Collision...
                if(GameWorld.mapObjects.get(i) instanceof BlueExit){
                    //Once the koala is rescued, its 'isRescued' will be set to true
                    //Background.java will run through the arrayList and paint each koala
                    //that has been rescued.
                    this.isRescued = true;
                    //Remove koala from the game
                    GameWorld.koalas.remove(this);
                }

                //Blue Lock Collision
                if(GameWorld.mapObjects.get(i) instanceof Locks){
                    //First we check the vertical axis
                    //if koalatop < objtop
                    if(y < GameWorld.mapObjects.get(i).getRectY()){
                        vx = 0; vy = 0; y-=3;
                    }
                    //if koalato > objtop
                    else if(y > GameWorld.mapObjects.get(i).getRectY()){
                        vx = 0; vy = 0; y+=3;
                    }

                    //Now check the horizontal axis..
                    //right side
                    if(x < GameWorld.mapObjects.get(i).getRectX()){
                        vx = 0; vy = 0; x-=3;
                    }
                    //left side
                    else if(x > GameWorld.mapObjects.get(i).getRectX()){
                        vx = 0; vy = 0; x+=3;
                    }
                }


                //Blue Switch Collision
                if(GameWorld.mapObjects.get(i) instanceof BlueSwitch){
                    ((BlueSwitch) GameWorld.mapObjects.get(i)).flipSwitchImg();

                    if(GameWorld.mapObjects.get(BlueLock.getMapObjIndex()) instanceof BlueLock){
                        GameWorld.mapObjects.remove(BlueLock.getMapObjIndex());

                        /*int rlIndex;
                        for(int j = 0; j < (GameWorld.mapObjects.size() ); j++){
                            if(GameWorld.mapObjects.get(j) instanceof RedLock){

                                ((RedLock) GameWorld.mapObjects.get(j)).setMapObjIndex(31);
                            }
                        }*/
                    }
                }

                //Red Switch Collision
                /*
                * Could not get switches and locks to work correctly when there are multiple.
                * if a Blue lever is triggered and the blue lock is unlocked, the Red lever will still activate
                * when triggered, however, the red lock does not unlock as it should.
                * This may be because when the first lock (in this case, blue lock) is triggered,
                * it is removed from the mapObjects arraylist which changes the indexes of the other locks
                * that are still untriggered.*/
                /*if(GameWorld.mapObjects.get(i) instanceof RedSwitch){
                    ((RedSwitch) GameWorld.mapObjects.get(i)).flipSwitchImg();
                    //doesn't work for some reason. need to check it out...
                    if(GameWorld.mapObjects.get(RedLock.getMapObjIndex()) instanceof RedLock){
                        GameWorld.mapObjects.remove(RedLock.getMapObjIndex());
                    }

                    int blIndex;
                    for(int j = 0; j < (GameWorld.mapObjects.size() ); j++){
                        if(GameWorld.mapObjects.get(j) instanceof BlueLock){
                            ((BlueLock) GameWorld.mapObjects.get(j)).setMapObjIndex(255);
                        }
                    }
                }*/

            }
        }

    }

    @Override
    public void drawImage(Graphics g) {
        AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
        rotation.rotate(Math.toRadians(angle), this.img.getWidth() / 2.0, this.img.getHeight() / 2.0);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.img, rotation, null);

        //make rectangle visible on the screen
       /* g2d.setColor(Color.blue);
        g2d.drawRect(this.getRectX(),this.getRectY(), img.getWidth(), img.getHeight());*/
    }
}
