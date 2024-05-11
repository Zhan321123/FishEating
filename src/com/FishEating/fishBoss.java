package com.FishEating;

import java.awt.*;

/**
 * 敌方鱼BOSS
 * 等级：∞
 */
public class fishBoss extends fishEnemy{
    public fishBoss(){
        this.x = 1200;
        this.y = (int)(Math.random()*760);
        this.width = 74;
        this.height = 77;
        this.img = GameUtils.fishBoss;
        this.speed = 30;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(220, 11, 11));
        g.drawLine(-100,this.y+38,1100,this.y+38);
        this.x -= speed;
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x+15,y+15,width-15,height-15);
    }
}
