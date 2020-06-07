package koalabr8game.gameobjects.collidable.interactables.objects.locks;

import fx.Assets;

import java.awt.*;

public class BlueLock extends Locks {
    private static int mapObjIndex;
    public BlueLock(int x, int y) {
        super(x, y);
        this.img = Assets.blue_lock;
        this.rect = new Rectangle(x,y, img.getWidth(), img.getHeight());
    }

    @Override
    public void collision() {

    }

    public static int getMapObjIndex() {
        return mapObjIndex;
    }

    public void setMapObjIndex(int mapObjIndex) {
        BlueLock.mapObjIndex = mapObjIndex;
    }

    public void decrementMapObjIndex(){
        BlueLock.mapObjIndex--;
    }


    @Override
    public void drawImage(Graphics g) {
        super.drawImage(g);
    }


}
