package JSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParsingJSON{
    public static void main(String[] args) {
        String jsonData = """
                [
                  {"name": "Abhinaya", "age": 21},
                  {"name": "Sasanka", "age": 20},
                  {"name": "Bharath", "age": 30}
                ]
                """;
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonData);
            System.out.println("People with age > 25:");
            for (JsonNode node : root) {
                if (node.get("age").asInt() > 25) {
                    System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
