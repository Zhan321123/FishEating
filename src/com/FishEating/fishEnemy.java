package com.FishEating;

import java.awt.*;

/**
 * 敌方鱼的父类
 * 包含draw方法和getRec方法
 */
public class fishEnemy {

    //定义图片
    Image img;
    //定义坐标
    int x;
    int y;
    int width;
    int height;
    //定义鱼的移动速度
    int speed;
    //定义鱼运动的方向,true是向右，false是向左
    boolean right;
    //鱼的类型
    int type;
    //鱼的分数
    int count;

    public void paint(Graphics g){
        g.drawImage(img,x,y,width,height,null);
    }
    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }

}
