package koalabr8game.gameobjects;

import java.awt.*;
import java.awt.image.BufferedImage;
/*
* LIST OF GAME OBJECTS TO BE IMPLEMENTED
*
* PLAYABLE
* -koalas   X
*
* FATAL HAZARDS
* -explosiveTNTs    X
* -moving circuilar saws    X
*
* NON FATAL HAZARDS aka powerups
* -red exits: allow any number of koalas to exit the lvl
* -blue exits: allow a single koala to exit the lvl
* -locks: block to the path of koalas (red, blue, & green)
* -boulders: can be pushed by koalas& destroy other hazards     X
*
* */

public abstract class GameObject /*implements Collision*/ {

    protected int   x,
            y,
            vx,
            vy,
            angle;
    protected BufferedImage img;
    protected Rectangle rect;

    public GameObject(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRectX(){
        return (int) rect.getX();
    }
    public int getRectY(){
        return (int) rect.getY();
    }

    public void setRectX(int x){
        rect.setLocation(x, y);
    }
    public void setRectY(int y){
        rect.setLocation(x, y);
    }

    //trying edujava tutorial...
    public Rectangle getRect(){
        return rect;
    }

    //allso tutorial
    public abstract void collision();

    public void drawImage(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.img, x, y,null);

        //make rectangle visible on the screen
        /*g2d.setColor(Color.blue);
        g2d.drawRect(this.getRectX(),this.getRectY(), img.getWidth(), img.getHeight());*/
    }
}
