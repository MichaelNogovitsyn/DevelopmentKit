package lection2;

import java.awt.*;
import java.util.Random;

public class Ball extends Sprite {
    private static Random rnd = new Random();
    private final Color color;
    private float vX;
    private float vY;

    Ball() {
        halfHeight = 20 + (float) (Math.random() * 50f);
        halfWidth = halfHeight;
        color = new Color(rnd.nextInt());
        vX = 100f + (float) (Math.random() * 200f);
        vX = 100f + (float) (Math.random() * 200f);
    }

    @Override
    void render(MainCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int)getLeft(),(int)getRight(),(int)getWeigth(),(int)getHeight());
    }

    @Override
    void update(MainCanvas canvas, float deltaTime){
        x += vX * deltaTime;
        y += vY * deltaTime;
        if (getLeft()<canvas.getLeft()) {setLeft(canvas.getLeft());
        vX = - vX;}
        if (getRight()>canvas.getRight()) {setRight(canvas.getRight());
            vX = - vX;}
        if (getTop()<canvas.getTop()) {setLeft(canvas.getTop());
            vY = - vY;}
        if (getBottom()>canvas.getBottom()) {setBottom(canvas.getBottom());
            vY = - vY;}
    }
}
