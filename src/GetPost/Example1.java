package GetPost;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class Example1 {
    private static final int CONNECTION_TIMEOUT = 1000; // Таймаут подключения

    public static void main(String[] args) {
        try {
            // GET-запрос
            URL getUrl = new URL("http://jsonplaceholder.typicode.com/posts?_limit=10");
            HttpURLConnection getCon = (HttpURLConnection) getUrl.openConnection();

            getCon.setRequestMethod("GET");
            getCon.setRequestProperty("Content-Type", "application/json");
            getCon.setConnectTimeout(CONNECTION_TIMEOUT);
            getCon.setReadTimeout(CONNECTION_TIMEOUT);

            try (BufferedReader in = new BufferedReader(new InputStreamReader(getCon.getInputStream()))) {
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                System.out.println("GET Response: " + content.toString());
            } finally {
                getCon.disconnect(); // Закрываем соединение
            }

            // POST-запрос
            URL postUrl = new URL("http://jsonplaceholder.typicode.com/posts");
            HttpURLConnection postCon = (HttpURLConnection) postUrl.openConnection();

            postCon.setRequestMethod("POST");
            postCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            postCon.setConnectTimeout(CONNECTION_TIMEOUT);
            postCon.setReadTimeout(CONNECTION_TIMEOUT);
            postCon.setDoOutput(true);

            // Параметры для POST-запроса
            Map<String, String> parameters = new HashMap<>();
            parameters.put("title", "foo");
            parameters.put("body", "bar");
            parameters.put("userId", "1");

            // Отправка данных
            try (OutputStream out = postCon.getOutputStream()) {
                out.write(getParamsString(parameters).getBytes());
                out.flush();
            }

            // Чтение ответа
            try (BufferedReader in = new BufferedReader(new InputStreamReader(postCon.getInputStream()))) {
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                System.out.println("POST Response: " + content.toString());
            } finally {
                postCon.disconnect(); // Закрываем соединение
            }

        } catch (Exception ex) {
            ex.printStackTrace(); // Обработка ошибок
        }
    }

    // Метод для преобразования Map в строку параметров
    public static String getParamsString(final Map<String, String> params) {
        final StringBuilder result = new StringBuilder();

        params.forEach((name, value) -> {
            try {
                result.append(URLEncoder.encode(name, "UTF-8"));
                result.append('=');
                result.append(URLEncoder.encode(value, "UTF-8"));
                result.append('&');
            } catch (final UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });

        final String resultString = result.toString();
        return !resultString.isEmpty()
                ? resultString.substring(0, resultString.length() - 1) // Убираем последний символ '&'
                : resultString;
    }
}