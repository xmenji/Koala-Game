package koalabr8game.gameobjects.collidable.interactables.exits;

import fx.Assets;

import java.awt.*;

public class BlueExit extends ExitObj {
    public BlueExit(int x, int y) {
        super(x, y);
        this.img = Assets.blue_exit;
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
