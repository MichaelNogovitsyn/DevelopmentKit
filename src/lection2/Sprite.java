package lection2;

import java.awt.*;

public class Sprite implements Interactable{
    protected float x;
    protected float y;
    protected float halfWidth;
    protected float halfHeight;

    protected float getLeft(){return  x - halfWidth;}
    protected void setLeft(float left){x= left + halfWidth;}
    protected float getRight(){return  x + halfWidth;}
    protected void setRight (float right){x= right - halfWidth;}

    protected float getTop(){return  y - halfHeight;}
    protected void setTop (float hight){y = hight + halfHeight;}
    protected float getBottom(){return  y + halfHeight;}
    protected void setBottom (float hight){y = hight - halfHeight;}

    protected float getWeigth() {return  2f*halfWidth;}
    protected float getHeight() {return  2f*halfHeight;}

    public void update (MainCanvas canvas, float deltaTime){}
    public void render (MainCanvas canvas, Graphics g){}
}
