package koalabr8game.gameobjects.collidable.interactables.hazardous.saws;

import koalabr8game.gameobjects.GameObject;

import java.awt.*;

public abstract class Saws extends GameObject {
    public Saws(int x, int y) {
        super(x, y);
        this.rect = new Rectangle(x,y, 32, 32);
    }

    public abstract void update();

    public abstract void move();

    @Override
    public void collision() {
    }

    @Override
    public void drawImage(Graphics g) {
        super.drawImage(g);
    }
}
