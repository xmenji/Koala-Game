package koalabr8game.gameobjects.collidable.interactables.hazardous;

import fx.Assets;
import koalabr8game.gameobjects.GameObject;

import java.awt.*;

public class TNT extends GameObject {
    public TNT(int x, int y) {
        super(x, y);
        this.img = Assets.tnt;
        this.rect = new Rectangle(x, y, img.getWidth(), img.getHeight());
    }

    @Override
    public void collision() {

    }
}
