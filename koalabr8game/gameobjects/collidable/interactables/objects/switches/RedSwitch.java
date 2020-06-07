package koalabr8game.gameobjects.collidable.interactables.objects.switches;

import fx.Assets;

import java.awt.*;

public class RedSwitch extends Switch {
    public RedSwitch(int x, int y) {
        super(x, y);
        this.img = Assets.red_switch;
    }

    @Override
    public void flipSwitchImg() {
        this.img = Assets.flipped_red_switch;
    }

    @Override
    public void collision() {

    }

    @Override
    public void drawImage(Graphics g) {
        super.drawImage(g);
    }
}
