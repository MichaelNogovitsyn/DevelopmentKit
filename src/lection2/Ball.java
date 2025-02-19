package lection2;

import java.awt.*;
import java.util.Random;

public class Ball extends  Sprite{
    private  static Random rnd = new Random();
    private final Color color;
    private float vX;
    private float vY;

    Ball(){
        halfHeight = 20 + (float) (Math.random()*50f);
        halfWidth = halfHeight;
        color = new Color(rnd.nextInt());
        vX = 100f + (float) (Math.random()*200f);
        vX = 100f + (float) (Math.random()*200f);
    }
}
