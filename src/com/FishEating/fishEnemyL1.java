package com.FishEating;

import java.awt.*;

/**
 * 敌方鱼
 * 等级：1
 * 向左运动
 */
public class fishEnemyL1 extends fishEnemy {
    public fishEnemyL1() {
        this.img = GameUtils.fish1;
        this.x = 1050;
        this.y = (int) (Math.random() * 700);
        this.height = 20;
        this.width = 22;
        this.speed = (int)(Math.random()*4)+7;
        this.type = 1;
        this.count = 1;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.x -= this.speed;
    }
}
