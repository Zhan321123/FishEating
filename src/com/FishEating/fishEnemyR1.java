package com.FishEating;

import java.awt.*;

/**
 * 敌方向右的鱼
 * 等级：1
 */
public class fishEnemyR1 extends fishEnemy{
    public fishEnemyR1(){
        this.x = -200;
        this.y = (int)(Math.random()*960);
        this.width = 46;
        this.height = 35;
        this.img = GameUtils.fish3;
        this.speed = (int)(Math.random()*8)+6;
        this.count = 4;
        this.type = 2;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.x +=this.speed;
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x+5,y+5,this.width-5,this.height-5);
    }


}
