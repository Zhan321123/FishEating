package com.FishEating;

import java.awt.*;

/**
 * 自己鱼2
 */
public class myFish2 extends myFish {
    public myFish2(){
        this.img = GameUtils.myFish12;
        this.x = 700;
        this.y =400;
        this.width = 27;
        this.height = 30;
    }

    @Override
    public void moveLogic() {
        if (up && y>-40){
            this.y-=this.speed;
        }
        if (down && y<760){
            this.y += this.speed;
        }
        if (left && x>-40){
            this.x -= this.speed;
            this.img = GameUtils.myFish11;
        }
        if (right && x<960){
            this.x+= this.speed;
            this.img = GameUtils.myFish12;
        }
    }

}
