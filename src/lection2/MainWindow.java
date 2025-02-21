package lection2;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOWS_WIDTH = 800;
    private static final int WINDOWS_HEIHGT = 600;
    private final Sprite[] sprites = new Sprite[10];

    public MainWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.GRAY);
        setBounds(POS_X, POS_Y, WINDOWS_WIDTH, WINDOWS_HEIHGT);
        setTitle("Circles");
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
        MainCanvas canvas = new MainCanvas(this);
        add(canvas);
        setVisible(true);
    }

    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
    }

    public static void main(String[] args) {
        new MainWindow();
    }


}
