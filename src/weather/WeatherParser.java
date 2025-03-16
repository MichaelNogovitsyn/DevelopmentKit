package weather;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class WeatherParser {

    static Weather tomorrowWeather;
    static String accessKey = "f6e70d27-f3f1-4ed1-9fb7-dcb9418c5155";
    WeatherParser(WFrame f) {

        tomorrowWeather = new Weather();
    }

    public static void parse(String cityID) {
        Weather todayWeather = new Weather();
        NodeList nl = null;
        try {
            Document doc = null;
            URL url = new URL("https://api.weather.yandex.ru/v2/forecast?lat=54.7065&lon=20.511");

            //попробуйте пройти по ссылке и посмотреть, что именно мы парсим
            // да и вообще саму структуру
            URLConnection uc = url.openConnection();
            uc.setRequestProperty("X-Yandex-Weather-Key", accessKey); // header
            InputStream is = uc.getInputStream();//создали поток
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = (Document) db.parse(is);
            ((org.w3c.dom.Document) doc).getDocumentElement().normalize();

            nl = ((org.w3c.dom.Document) doc).getElementsByTagName("forecast").item(0).getChildNodes();
            //из этого родителя нам и нужно содердимое
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Ошибка при запросе к Яндекс АПИ");
            ex.printStackTrace();
        }

        for (int i = 0; i < nl.getLength(); i++) {
            Node child = nl.item(i);

            if (child instanceof Element) {
                if (child.getNodeName().equals("fact")) {
                    Node childOfChild = null;
                    for (int j = 0; j < child.getChildNodes().getLength(); j++) {
                        childOfChild = child.getChildNodes().item(j);

                        if ("station".equals(childOfChild.getNodeName())) {
                            todayWeather.city = childOfChild.getTextContent();
                        }
                        if ("temperature".equals(childOfChild.getNodeName()))
                            todayWeather.temperature = Integer
                                    .parseInt(childOfChild.getTextContent());
                        if ("weather_type_short".equals(childOfChild
                                .getNodeName())) {
                            todayWeather.weatherType = childOfChild
                                    .getTextContent();
                        }
                        if ("image".equals(childOfChild.getNodeName())) {
                            todayWeather.imgType = childOfChild
                                    .getTextContent();
                        }
                        if ("humidity".equals(childOfChild.getNodeName())) {
                            todayWeather.humidity = childOfChild
                                    .getTextContent();
                        }

                    }
                }

                if (child.getNodeName().equals("informer")) {
                    Node childOfChild = null;
                    for (int j =0; j<child.getChildNodes().getLength(); j++){
                        childOfChild = child.getChildNodes().item(j);
                        if ((childOfChild.getNodeName().equals("temperature")) &&
                                (childOfChild.getAttributes().item(1).getTextContent().equals("night")))
                        { todayWeather.tomNight = childOfChild.getTextContent(); }

                        if (childOfChild.getNodeName().equals("temperature") &&
                                (childOfChild.getAttributes().item(1).getTextContent().equals("tomorrow")))
                        { todayWeather.tom = childOfChild.getTextContent();}

                    }
                }


            }
        }
        WFrame.today = todayWeather;

    }

}
