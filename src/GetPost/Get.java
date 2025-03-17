package GetPost;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Get {
    private static final int CONNECTION_TIMEOUT = 1000; // Таймаут подключения

    public String sendGetRequest(String url) throws IOException {
        HttpURLConnection con = null;
        BufferedReader in = null;
        StringBuilder content = new StringBuilder();

        try {
            URL getUrl = new URL(url);
            con = (HttpURLConnection) getUrl.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(CONNECTION_TIMEOUT);
            con.setReadTimeout(CONNECTION_TIMEOUT);

            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (con != null) {
                con.disconnect();
            }
        }

        return content.toString();
    }
}
