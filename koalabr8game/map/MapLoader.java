package koalabr8game.map;


import koalabr8game.GameWorld;
import koalabr8game.gameobjects.collidable.interactables.exits.BlueExit;
import koalabr8game.gameobjects.collidable.interactables.exits.ExitObj;
import koalabr8game.gameobjects.collidable.interactables.hazardous.TNT;
import koalabr8game.gameobjects.collidable.interactables.hazardous.saws.HorizontalSaw;
import koalabr8game.gameobjects.collidable.interactables.hazardous.saws.Saws;
import koalabr8game.gameobjects.collidable.interactables.hazardous.saws.VerticalSaw;
import koalabr8game.gameobjects.collidable.interactables.objects.Boulder;
import koalabr8game.gameobjects.collidable.interactables.objects.locks.BlueLock;
import koalabr8game.gameobjects.collidable.interactables.objects.locks.RedLock;
import koalabr8game.gameobjects.collidable.interactables.objects.switches.BlueSwitch;
import koalabr8game.gameobjects.collidable.interactables.objects.switches.RedSwitch;
import koalabr8game.gameobjects.collidable.noninteractable.Wall;

import java.io.*;
import java.util.Scanner;

public class MapLoader {
    private String file = "resources/Lvl1.txt";

    private Scanner scanner;

    public void loadMap(){
        try {//Read in the Lvl1.txt file
            scanner = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;        //Holds each line of txt as it's being read from the file
        int w = 0, h = 0;   //Marks the position (w,h) of the map object to be painted on the screen

        //Start loading file contents
        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            System.out.println(line); //test line

            char c;

            for(int x = 0; x < line.length(); x++){
                c = line.charAt(x);
                // 0 : Wall
                if(c == '0'){
                    Wall wall = new Wall(w, h);
                    GameWorld.mapObjects.add(wall);
                }
                // 1 : Boulder
                if(c == '1'){
                    Boulder boulder = new Boulder(w, h);
                    GameWorld.mapObjects.add(boulder);
                }
                // 2 : Explosive TNT
                if(c == '2'){
                    TNT tnt = new TNT(w, h);
                    GameWorld.mapObjects.add(tnt);
                }
                //3 : Horizontal Saw
                if(c == '3'){
                    Saws h_saw = new HorizontalSaw(w, h);
                    GameWorld.mapObjects.add(h_saw);
                }
                // 4 : Vertical Saw
                if(c == '4'){
                    Saws v_saw = new VerticalSaw(w, h);
                    GameWorld.mapObjects.add(v_saw);
                }
                // 5: Blue Exit
                if(c == '5'){
                    BlueExit blueExit = new BlueExit(w, h);
                    GameWorld.mapObjects.add(blueExit);
                }
                // 6: Blue Switch
                if(c == '6'){
                    BlueSwitch blueSwitch = new BlueSwitch(w, h);
                    GameWorld.mapObjects.add(blueSwitch);
                }
                // 7: Blue Lock
                if(c == '7'){
                    BlueLock blueLock = new BlueLock(w, h);
                    GameWorld.mapObjects.add(blueLock);
                    blueLock.setMapObjIndex(GameWorld.mapObjects.indexOf(blueLock));
                    System.out.println("BLUE LOCK INDEX: " + blueLock.getMapObjIndex());
                }
                // 8: Red Switch
                if(c == '8'){
                    RedSwitch redSwitch = new RedSwitch(w, h);
                    GameWorld.mapObjects.add(redSwitch);
                }
                // 9: Red Lock
                if(c == '9'){
                    RedLock redLock = new RedLock(w, h);
                    GameWorld.mapObjects.add(redLock);
                    redLock.setMapObjIndex(GameWorld.mapObjects.indexOf(redLock));
                    System.out.println("RED LOCK INDEX: " + redLock.getMapObjIndex());
                }
                w += 42;
            }
            w = 0;
            h+=42;
        }

    }
}
