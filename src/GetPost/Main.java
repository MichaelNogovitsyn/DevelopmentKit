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
            System.out.println("GET Response: " + getResponse);

            // POST-запрос
            Post post = new Post();
            Map<String, String> parameters = new HashMap<>();
            parameters.put("title", "foo");
            parameters.put("body", "bar");
            parameters.put("userId", "1");

            String postResponse = post.sendPostRequest("http://jsonplaceholder.typicode.com/posts", parameters);
            System.out.println("POST Response: " + postResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}