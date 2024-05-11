package com.FishEating;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 项目：大鱼吃小鱼
 * 窗口类
 */
public class MyFrame extends JFrame {
    public static void main(String[] args) {
        new MyFrame().launch();
    }

    /*
    定义游戏状态
    1：游戏未开始  2：游戏已开始  3：游戏失败
     */
    static int state = 1;
    //随机数控制鱼生成的概率
    static double probability = 0;
    //屏幕大小
    final int ScreenWidth = 1000;
    final int ScreenHeight = 800;

    //启动
    public void launch() {
        this.setTitle("FishEating");
        this.setVisible(true);
        this.setSize(ScreenWidth, ScreenHeight);
        /*
        setLocationRelativeTo（对象），
        设置窗口位置居中
        必须要先设置窗口大小，否则就是先居中后大小
         */
        this.setLocationRelativeTo(null);
        this.setResizable(false);//设置窗口大小不可改变
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //鼠标监听
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (state == 1 && e.getButton() == 1) {
                    state = 2;
                    repaint();
                }
                if (state == 3 && e.getButton()==1){
                    state = 1;
                    GameUtils.count = 0;
                }
            }
        });
        //键盘监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                {
                    if (e.getKeyChar() == 'i') {
                        myFish2.up = true;
                    }
                    if (e.getKeyChar() == 'j') {
                        myFish2.left = true;
                    }
                    if (e.getKeyChar() == 'k') {
                        myFish2.down = true;
                    }
                    if (e.getKeyChar() == 'l') {
                        myFish2.right = true;
                    }
                }
                {
                    if (e.getKeyChar() == 'w') {
                        myFish.up = true;
                    }
                    if (e.getKeyChar() == 'a') {
                        myFish.left = true;
                    }
                    if (e.getKeyChar() == 's') {
                        myFish.down = true;
                    }
                    if (e.getKeyChar() == 'd') {
                        myFish.right = true;
                    }
                }
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                {
                    if (e.getKeyChar() == 'i') {
                        myFish2.up = false;
                    }
                    if (e.getKeyChar() == 'j') {
                        myFish2.left = false;
                    }
                    if (e.getKeyChar() == 'k') {
                        myFish2.down = false;
                    }
                    if (e.getKeyChar() == 'l') {
                        myFish2.right = false;
                    }
                }
                {
                    if (e.getKeyChar() == 'w') {
                        myFish.up = false;
                    }
                    if (e.getKeyChar() == 'a') {
                        myFish.left = false;
                    }
                    if (e.getKeyChar() == 's') {
                        myFish.down = false;
                    }
                    if (e.getKeyChar() == 'd') {
                        myFish.right = false;
                    }
                }
            }
        });
        //重画
        while (true) {
            probability = Math.random() * 100;
            repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /*
    创建鱼的对象
    后期一个一个添加到容器中，并新建对象
     */
    fishEnemyL1 fl1 = new fishEnemyL1();
    myFish myFish = new myFish();
    fishEnemyR1 fr1 = new fishEnemyR1();
    fishBoss fb = new fishBoss();
    myFish2 myFish2 = new myFish2();

    /**
     * 窗口绘制
     * 有双缓冲解决屏幕闪烁
     * 先将所有要画的画到offScreenImage上，再把它画到屏幕上
     */
    Image offScreenImage;

    @Override
    public void paint(Graphics gg) {
        offScreenImage = createImage(ScreenWidth, ScreenHeight);
        Graphics g = offScreenImage.getGraphics();

        g.drawImage(GameUtils.seabed, 0, 0, null);

        switch (state) {
            case 1:
                g.setFont(new Font("黑体", Font.BOLD, 40));
                g.setColor(new Color(15, 229, 52));
                g.drawString("开始游戏", 400, 600);
                g.setFont(new Font("微软雅黑", Font.BOLD, 30));
                g.setColor(new Color(229, 213, 29));
                g.drawString("点击任何地方开始", 370, 660);
                break;
            case 2:
                g.setFont(new Font("黑体", Font.BOLD, 40));
                g.setColor(new Color(17, 236, 229));
                g.drawString("分数：" + GameUtils.count, 100, 100);
                addFishEnemyL1(g);
                addFishEnemyR1(g);
                myFish.paint(g);
                myFish2.paint(g);
                addFishBoss(g);
                break;
            case 3:
                g.setFont(new Font("黑体", Font.BOLD, 50));
                g.setColor(new Color(17, 53, 236));
                g.drawString("游戏结束",450,350);
                break;
            default:
        }
        gg.drawImage(offScreenImage, 0, 0, null);
    }

    private void addFishBoss(Graphics g) {
        if (fb == null && Math.random() * 100 < 2) {
            fb = new fishBoss();
        }
        if (fb != null) {
            fb.paint(g);
            if (fb.getRec().intersects(myFish2.getRec())){
                fb.x = -300;
                GameUtils.count += 30;
            }
            if (fb.getRec().intersects(myFish.getRec())){
                fb.x = -300;
                state = 3;
                GameUtils.fishEnemyL1s.clear();
                GameUtils.fishEnemyR1s.clear();
            }
            if (fb.x < -200) {
                fb = null;
            }
        }
    }

    private void addFishEnemyR1(Graphics g) {
        if (Math.random() * 100 > 95) {
            fr1 = new fishEnemyR1();
            GameUtils.fishEnemyR1s.add(fr1);
        }
        for (fishEnemyR1 fr1 : GameUtils.fishEnemyR1s) {
            fr1.paint(g);
            if (fr1.getRec().intersects(myFish.getRec())) {
                fr1.x = 1200;
                GameUtils.count += fr1.count;
            }
        }
        for (int i = 0; i < GameUtils.fishEnemyR1s.size(); i++) {
            if (GameUtils.fishEnemyR1s.get(i).x > 1200) {
                GameUtils.fishEnemyR1s.remove(i);
                i--;
            }
        }
    }

    //鱼1的添加
    private void addFishEnemyL1(Graphics g) {
        if (Math.random() * 100 < 10) {
            fl1 = new fishEnemyL1();
            GameUtils.fishEnemyL1s.add(fl1);
        }
        for (fishEnemyL1 fl1 : GameUtils.fishEnemyL1s) {
            fl1.paint(g);
            if (fl1.getRec().intersects(myFish.getRec())) {
                fl1.x = -200;
                GameUtils.count += fl1.count;
            }
        }
        for (int i = 0; i < GameUtils.fishEnemyL1s.size(); i++) {
            if (GameUtils.fishEnemyL1s.get(i).x < -200) {
                GameUtils.fishEnemyL1s.remove(i);
                i--;
            }
        }
    }


}
