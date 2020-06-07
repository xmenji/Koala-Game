package koalabr8game.gameobjects.collidable.interactables.exits;

import fx.Assets;

import java.awt.*;

public class RedExit extends ExitObj {
    public RedExit(int x, int y) {
        super(x, y);
        this.img = Assets.red_exit;
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
