package koalabr8game.gameobjects.collidable.interactables.objects.locks;

import koalabr8game.gameobjects.GameObject;

import java.awt.*;

public abstract class Locks extends GameObject {
    public static boolean locked;
    //private static int mapObjIndex;

    public Locks(int x, int y) {
        super(x, y);
        locked = true;
    }

    public void unlock(){
        locked = false;
    }




}
