package weather;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WFrame extends JFrame {
    static Weather today;
    JPanel panel;
    JTextField idField;
    JButton btn;
    JLabel label;
    JLabel tLabel;
    JLabel iLabel;
    Box b;
    static String id;
    static int t;
    Container contentPane;

    public WFrame() {

        today = null;
        JPopupMenu menu = new JPopupMenu();
        menu.add(new AbstractAction("Пенза") {

            @Override
            public void actionPerformed(ActionEvent e) {
                setCity("27962");
            }
        });
        //несомненно, можно добавить любой город, список которых можно найти здесь
        // http://weather.yandex.ru/static/cities.xml


        GridBagLayout layout = new GridBagLayout(); // выбрал его, потому что раньше с ним не работал, вот и экперементирую
        setTitle("Weather");
        setPreferredSize(new Dimension(350, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        contentPane = getContentPane();

        panel = new JPanel();
        panel.setLayout(layout);
        idField = new JTextField();
        idField.setColumns(6);
        idField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent arg0) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btn.doClick();
                }
            }

            @Override
            public void keyPressed(KeyEvent arg0) {
            }
        });

        // парсим содержимое xml, вытаскиваем от туда необходимые данные
        // заполняем метки
        btn = new JButton("Хочу все знать");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String cityID = idField.getText();
                    if (cityID == null)
                        throw new IOException("Не введен ID города");
                    WeatherParser.parse(cityID); // процесс присваивания переменным необходимыми значениями
                    label.setText(today.city + "(сейчас): " + today.temperature
                            + " С; " + today.weatherType + " Влж:"
                            + today.humidity + " %");

                    iLabel = new JLabel(new ImageIcon(ImageIO.read(new URL(
                            "http://img.yandex.net/i/wiz" + today.imgType
                                    + ".png"))));
                    tLabel.setText("Погода завтра ночь/день: "+ today.tomNight+"/"+ today.tom);
                    //некорректные конечно названия переменных
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                contentPane.add(iLabel);

            }
        });

        // расположение элементов, в GUI я не силен, критику приму
        label = new JLabel("Наберите в поле ID вашего города");
        label.setFont(new Font("Verdana", Font.PLAIN, 14));

        tLabel = new JLabel("Погода завтра");
        tLabel.setFont(new Font("Verdana", Font.PLAIN, 14));

        iLabel = new JLabel();

        panel.add(label,
                new GBC(0, 0, 2, 1).setFill(GBC.NORTH).setWeight(100, 0));
        panel.add(iLabel,
                new GBC(0, 1, 2, 1).setFill(GBC.NORTH).setWeight(100, 0));

        panel.add(btn, new GBC(0, 3, 2, 1).setFill(GBC.NORTH).setWeight(100, 0));

        panel.add(idField,
                new GBC(0, 2, 2, 1).setAnchor(GBC.NORTH)
                        .setFill(GBC.HORIZONTAL).setIpad(50, 0));

        panel.add(tLabel,
                new GBC(0, 4, 2, 1).setAnchor(GBC.NORTH)
                        .setFill(GBC.HORIZONTAL).setIpad(50, 0));
        add(panel);

        panel.setComponentPopupMenu(menu);
        pack();

    }

    public static void main(String[] args) {
        // loginWithProxy();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WFrame frame = new WFrame();
                frame.setDefaultLookAndFeelDecorated(true);
            }
        });
    }

    public void setCity(String id) {
        this.id = id;
        idField.setText(id);
    }

}
