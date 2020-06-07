package fx;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage background,
                                koala,
                                koalaDied,
                                wall,
                                tnt,
                                boulder,
                                saw_h,
                                saw_v,
                                red_exit,
                                blue_exit,
                                num_rescued,
                                rescued_koala,
                                blue_switch,
                                flipped_blue_switch,
                                blue_lock,
                                red_switch,
                                flipped_red_switch,
                                red_lock;

    //loads all of the images for the game
    public static void init(){
        background = ImageLoader.loadImage("resources/Background.bmp");
        koala = ImageLoader.loadImage("resources/koala_down_1.png");
        koalaDied = ImageLoader.loadImage("resources/koala_dead.png");
        wall = ImageLoader.loadImage("resources/wall2.png");
        tnt = ImageLoader.loadImage("resources/TNT.png");
        boulder = ImageLoader.loadImage("resources/rock.png");
        saw_h = ImageLoader.loadImage("resources/saw.png");
        saw_v = ImageLoader.loadImage("resources/saw - v.png");
        red_exit = ImageLoader.loadImage("resources/Exit1.gif");
        blue_exit = ImageLoader.loadImage("resources/Exit2.gif");
        num_rescued = ImageLoader.loadImage("resources/rescued.png");
        rescued_koala = ImageLoader.loadImage("resources/koala_stan.png");
        blue_switch = ImageLoader.loadImage("resources/switch_blue.png");
        flipped_blue_switch = ImageLoader.loadImage("resources/switch_blue - switched.png");
        blue_lock = ImageLoader.loadImage("resources/lock_blue.png");
        red_switch = ImageLoader.loadImage("resources/switch_red.png");
        flipped_red_switch = ImageLoader.loadImage("resources/switch_red - flipped.png");
        red_lock = ImageLoader.loadImage("resources/lock_red.png");
    }

}