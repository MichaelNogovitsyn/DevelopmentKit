package sem2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindows extends JFrame implements Listenaranable, Listenaranable2 {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOWS_WIDTH = 800;
    private static final int WINDOWS_HEIHGT = 600;

    Button buttLogin = new Button("Login");
    Button butSend = new Button("Send");
    Button butExt = new Button("Exit");
    JPanel panel = new JPanel(new GridLayout(1, 3));
    JTextField chat = new JTextField();

    public ChatWindows() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.GRAY);
        setBounds(POS_X, POS_Y, WINDOWS_WIDTH, WINDOWS_HEIHGT);
        setTitle("Chat");
        chat.setBackground(Color.PINK);
        //chat.setBounds(POS_X-100, POS_Y-100, WINDOWS_WIDTH, WINDOWS_HEIHGT-500); // не работает
        chat.setEditable(true);
        chat.setSize(WINDOWS_WIDTH, WINDOWS_HEIHGT - 500);
        panel.add(buttLogin);
        panel.add(butSend);
        panel.add(butExt);
        add(panel, BorderLayout.SOUTH);
        add(chat);

        setVisible(true);
        Server server = new Server(this);
        buttLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.login("admin", "12345");
            }
        });
        butSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.sendMsg("Hello Server");
            }
        });
        butExt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.disconnect();
                ChatWindows.super.dispose();
            }
        });
    }

    @Override
    public void interfaceMetod(String str) {
        System.out.println(str);
    }

    @Override
    public void interface2Metod() {
        System.out.println("Выполняю действия с интерфейса2");
    }
}

