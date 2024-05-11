package com.FishEating;

import java.awt.*;

/**
 * 自己鱼
 */
public class myFish {
    Image img = GameUtils.myFish1;
    int x = 400;
    int y =400;
    int width = 30;
    int height = 27;
    int speed = 15;
    int level = 1;

    boolean up = false;
    boolean down = false;
    boolean left = false;
    boolean right = false;

    public void moveLogic(){
        if (up && y>-40){
            this.y-=this.speed;
        }
        if (down && y<760){
            this.y += this.speed;
        }
        if (left && x>-40){
            this.x -= this.speed;
            img = GameUtils.myFish1;
        }
        if (right && x<960){
            this.x+= this.speed;
            img = GameUtils.myFish2;
        }
    }

    private int w = 0;
    public void paint(Graphics g){
        g.drawImage(img,x,y,width+w,height+w,null);
        moveLogic();

        w = (int) Math.pow(GameUtils.count,0.8);
    }
    public Rectangle getRec(){
        return new Rectangle(x,y,width+w,height+w);
    }
}
