package lection2;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOWS_WIDTH = 800;
    private static final int WINDOWS_HEIHGT = 600;

    public MainWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.GRAY);
        setBounds(POS_X, POS_Y, WINDOWS_WIDTH, WINDOWS_HEIHGT);
        setTitle("Circles");

        MainCanvas canvas = new MainCanvas();
        add(canvas);
        setVisible(true);
    }

    public void onDrawFrame() {
        update();
        render();
    }

    private void update() {
    }

    private void render() {
    }

    public static void main(String[] args) {
        new MainWindow();
    }


}
