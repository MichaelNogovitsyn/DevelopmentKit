package GetPost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Example2 {
    private static final int CONNECTION_TIMEOUT = 1000;
    static String accessKey = "f6e70d27-f3f1-4ed1-9fb7-dcb9418c5155";

    public static void main(String[] args) throws IOException {

        final URL url = new URL("https://api.weather.yandex.ru/v2/forecast?lat=54.7065&lon=20.511");
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        // Добавление заголовков
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(CONNECTION_TIMEOUT);
        con.setReadTimeout(CONNECTION_TIMEOUT);
        con.setRequestProperty("X-Yandex-Weather-Key", accessKey); // header
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            //return content.toString();
            System.out.println(content.toString());
        } catch (final Exception ex) {
            ex.printStackTrace();
            System.out.println("");
            //return "";
        }
    }
}
