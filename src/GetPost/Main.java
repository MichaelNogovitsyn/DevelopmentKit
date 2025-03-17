package GetPost;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // GET-запрос
            Get get = new Get();
            String getResponse = get.sendGetRequest("http://jsonplaceholder.typicode.com/posts?_limit=10");
            System.out.println("GET Response (Raw JSON): " + getResponse);

            // Парсинг JSON-ответа
            GetParser parser = new GetParser();
            Post[] posts = parser.parseJson(getResponse);

            // Вывод распарсенных данных
            System.out.println("\nParsed Posts:");
            for (Post post : posts) {
                System.out.println(post);
            }

            // POST-запрос
            Post postRequest = new Post();
            Map<String, String> parameters = new HashMap<>();
            parameters.put("title", "foo");
            parameters.put("body", "bar");
            parameters.put("userId", "1");

            String postResponse = postRequest.sendPostRequest("http://jsonplaceholder.typicode.com/posts", parameters);
            System.out.println("\nPOST Response: " + postResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}