package koalabr8game.gameobjects.collidable.noninteractable;

import fx.Assets;
import koalabr8game.gameobjects.GameObject;

import java.awt.*;

public class Wall extends GameObject {
    public Wall(int x, int y) {
        super(x, y);
        this.img = Assets.wall;
        this.rect = new Rectangle(x, y, img.getWidth(), img.getHeight());
    }

    @Override
    public void collision() {

    }

    @Override
    public void drawImage(Graphics g) {
        super.drawImage(g);
    }
}
