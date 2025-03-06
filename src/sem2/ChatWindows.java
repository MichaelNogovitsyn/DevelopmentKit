package sem2;

import javax.swing.*;
import java.awt.*;

public class ChatWindows extends JFrame implements Listenaranable{
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOWS_WIDTH = 800;
    private static final int WINDOWS_HEIHGT = 600;

    Button button = new Button("Push me");

    public ChatWindows() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.GRAY);
        setBounds(POS_X, POS_Y, WINDOWS_WIDTH, WINDOWS_HEIHGT);
        setTitle("Chat");
        add(button);
        setVisible(true);
        Server server = new Server(this);
    }

    @Override
    public void buttonAction(String str) {

    }
}

