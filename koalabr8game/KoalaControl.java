package koalabr8game;

import koalabr8game.gameobjects.collidable.interactables.Koala;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KoalaControl implements KeyListener {

    private Koala koala;
    private final int up;
    private final int down;
    private final int right;
    private final int left;
    private final int shoot;

    public KoalaControl(Koala koala, int up, int down, int left, int right, int shoot) {
        this.koala = koala;
        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
        this.shoot = shoot;
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int keyPressed = ke.getKeyCode();
        if (keyPressed == up) {
            this.koala.toggleUpPressed();
        }
        if (keyPressed == down) {
            this.koala.toggleDownPressed();
        }
        if (keyPressed == left) {
            this.koala.toggleLeftPressed();
        }
        if (keyPressed == right) {
            this.koala.toggleRightPressed();
        }


    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int keyReleased = ke.getKeyCode();
        if (keyReleased  == up) {
            this.koala.unToggleUpPressed();
        }
        if (keyReleased == down) {
            this.koala.unToggleDownPressed();
        }
        if (keyReleased  == left) {
            this.koala.unToggleLeftPressed();
        }
        if (keyReleased  == right) {
            this.koala.unToggleRightPressed();
        }

    }
}

