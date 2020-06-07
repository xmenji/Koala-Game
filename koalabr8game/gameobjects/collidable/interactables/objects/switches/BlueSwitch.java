package koalabr8game.gameobjects.collidable.interactables.objects.switches;

import fx.Assets;

import java.awt.*;

public class BlueSwitch extends Switch {
    public BlueSwitch(int x, int y) {
        super(x, y);
        this.img = Assets.blue_switch;
    }

    @Override
    public void flipSwitchImg() {
        this.img = Assets.flipped_blue_switch;
    }

    @Override
    public void collision() {

    }

    @Override
    public void drawImage(Graphics g) {
        super.drawImage(g);
    }
}
