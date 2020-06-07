package koalabr8game;


import fx.Assets;
import koalabr8game.gameobjects.Background;
import koalabr8game.gameobjects.GameObject;
import koalabr8game.gameobjects.collidable.interactables.Koala;
import koalabr8game.gameobjects.collidable.interactables.hazardous.saws.Saws;
import koalabr8game.map.MapLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 *
 */
public class GameWorld extends JPanel {
    private static GameWorld trex; //part of example collision
    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 960;
    private BufferedImage world;
    private Graphics2D buffer;
    private JFrame jf;
    private Koala k1, k2, k3, k4;

    //Background
    Background newBackground;

    //Map: Wall, Boulder, TNT, Saws
    public static ArrayList<GameObject> mapObjects;

    //koalas
    public static ArrayList<Koala> koalas;
    public static ArrayList<Koala> koalasRescued;
    public static ArrayList<Koala> koalasDied;

    public static void main(String[] args) {
        Thread x;
        trex = new GameWorld();
        trex.init();

        //initialize map lvl 1
        mapObjects = new ArrayList<GameObject>();
        MapLoader level = new MapLoader();
        level.loadMap();

        try {

            while (true) {
                trex.k1.update();
                trex.k2.update();
                trex.k3.update();
                trex.k4.update();
                trex.repaint();
                System.out.println(trex.k1);
                Thread.sleep(1000 / 144);
            }
        } catch (InterruptedException ignored) {

        }

    }

    private void init() {
        this.jf = new JFrame("KoalaBr8");
        this.world = new BufferedImage(GameWorld.SCREEN_WIDTH, GameWorld.SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Assets.init(); //initialize images from Assets.java

        System.out.println(System.getProperty("user.dir"));

        koalas = new ArrayList<Koala>();
        koalasRescued = new ArrayList<Koala>();
        koalasDied = new ArrayList<Koala>();

        //koala characters
        k1 = new Koala(630, 300, 0, 0, 0);// 30, 100
        k2 = new Koala( 325, 565, 0,0, 0);// 90, 160
        k3 = new Koala(400, 900,0,0,0);//30, 200
        k4 = new Koala(30, 100, 0,0,0);//90, 250


        //add to arraylist
        koalas.add(k1);
        koalas.add(k2);
        koalas.add(k3);
        koalas.add(k4);

        //keeps track of whether koalas have been rescued (entered the blue exit)
        koalasRescued.add(k1);
        koalasRescued.add(k2);
        koalasRescued.add(k3);
        koalasRescued.add(k4);

        //keeps track of whether any koala has died
        koalasDied.add(k1);
        koalasDied.add(k2);
        koalasDied.add(k3);
        koalasDied.add(k4);



        //koala controls
        KoalaControl kc1 = new KoalaControl(k1, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_ENTER);
        KoalaControl kc2 = new KoalaControl(k2, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_ENTER);
        KoalaControl kc3 = new KoalaControl(k3, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_ENTER);
        KoalaControl kc4 = new KoalaControl(k4, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_ENTER);

        //set up the visible game window
        this.jf.setLayout(new BorderLayout());
        this.jf.add(this);

        //add koala key listeners to the jframe
        this.jf.addKeyListener(kc1);
        this.jf.addKeyListener(kc2);
        this.jf.addKeyListener(kc3);
        this.jf.addKeyListener(kc4);

        this.jf.setSize(GameWorld.SCREEN_WIDTH, GameWorld.SCREEN_HEIGHT + 30);
        this.jf.setResizable(false);
        jf.setLocationRelativeTo(null);

        this.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jf.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        buffer = world.createGraphics();
        super.paintComponent(g2);

        //Draw background image of the game
        newBackground = new Background();
        this.newBackground.drawImage(buffer);

        //populate the screen with objects contained in mapObjects Arraylist
        for(int i = 0; i < mapObjects.size(); i++){
            mapObjects.get(i).drawImage(buffer);
            //move the saws
            if(mapObjects.get(i) instanceof Saws){
                ((Saws) mapObjects.get(i)).update();
            }
        }

        //Draw playable Koalas
        for(int i = 0; i < koalas.size(); i++){
            this.koalas.get(i).drawImage(buffer);

            //check collision between koalas
            for(int j = 0; j < koalas.size(); j++){
                this.koalas.get(i).koalaCollision(this.koalas.get(j));
            }
        }

        g2.drawImage(world, 0, 0, null);

    }
}
