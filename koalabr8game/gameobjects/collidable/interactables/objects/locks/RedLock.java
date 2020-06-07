package koalabr8game.gameobjects.collidable.interactables.objects.locks;

import fx.Assets;

import java.awt.*;

public class RedLock extends Locks {
    private static int mapObjIndex;
    public RedLock(int x, int y) {
        super(x, y);
        this.img = Assets.red_lock;
        this.rect = new Rectangle(x,y, img.getWidth(), img.getHeight());
    }

    @Override
    public void collision() {

    }

    public static int getMapObjIndex() {
        return mapObjIndex;
    }

    public void setMapObjIndex(int mapObjIndex) {
        RedLock.mapObjIndex = mapObjIndex;
    }

    public void decrementMapObjIndex(){
        RedLock.mapObjIndex--;
    }

    @Override
    public void drawImage(Graphics g) {
        super.drawImage(g);
    }
}
