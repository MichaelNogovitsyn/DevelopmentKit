package GetPost;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class Post {
    private static final int CONNECTION_TIMEOUT = 1000; // Таймаут подключения

    public String sendPostRequest(String url, Map<String, String> parameters) throws IOException {
        HttpURLConnection con = null;
        BufferedReader in = null;
        StringBuilder content = new StringBuilder();

        try {
            URL postUrl = new URL(url);
            con = (HttpURLConnection) postUrl.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setConnectTimeout(CONNECTION_TIMEOUT);
            con.setReadTimeout(CONNECTION_TIMEOUT);
            con.setDoOutput(true);

            // Отправка данных
            try (OutputStream out = con.getOutputStream()) {
                out.write(getParamsString(parameters).getBytes());
                out.flush();
            }

            // Чтение ответа
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

    // Метод для преобразования Map в строку параметров
    private String getParamsString(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }
        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1) // Убираем последний символ '&'
                : resultString;
    }
}
