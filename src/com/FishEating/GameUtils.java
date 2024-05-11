package com.FishEating;

import java.awt.*;
import java.util.ArrayList;

/**
 * 工具类
 */
public class GameUtils{
    public static Image seabed = Toolkit.getDefaultToolkit().createImage("src\\images\\seabed.jpeg");
    public static Image fish1 = Toolkit.getDefaultToolkit().createImage("src\\images\\fish1.png");
    public static Image myFish1 = Toolkit.getDefaultToolkit().createImage("src\\images\\fish5.png");
    public static Image myFish2 = Toolkit.getDefaultToolkit().createImage("src\\images\\fish52.png");
    public static Image fish3 =Toolkit.getDefaultToolkit().createImage("src\\images\\fish3.png");
    public static Image fishBoss = Toolkit.getDefaultToolkit().createImage("src\\images\\FishBoss.png");
    public static Image myFish11 = Toolkit.getDefaultToolkit().createImage("src\\images\\fish4.png");
    public static Image myFish12 = Toolkit.getDefaultToolkit().createImage("src\\images\\fish42.png");
    //当前分数
    static int count;

    public static ArrayList<fishEnemyL1> fishEnemyL1s = new ArrayList<>();
    public static ArrayList<fishEnemyR1> fishEnemyR1s = new ArrayList<>();


}
