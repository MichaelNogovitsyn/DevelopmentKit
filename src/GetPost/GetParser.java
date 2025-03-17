package GetPost;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class GetParser {
    // Метод для парсинга JSON-ответа в массив объектов Post
    public Post[] parseJson(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Post[].class);
    }
}