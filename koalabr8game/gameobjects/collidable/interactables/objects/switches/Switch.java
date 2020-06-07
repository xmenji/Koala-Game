package koalabr8game.gameobjects.collidable.interactables.objects.switches;

import koalabr8game.gameobjects.GameObject;

import java.awt.*;

public abstract class Switch extends GameObject {
    public Switch(int x, int y) {
        super(x, y);
        this.rect = new Rectangle(x,y, 32, 32);
    }

    public abstract void flipSwitchImg();

    @Override
    public void drawImage(Graphics g) {
        super.drawImage(g);
    }
}
