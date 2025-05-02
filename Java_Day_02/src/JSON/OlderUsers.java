package JSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
public class OlderUsers{
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(new File("data.json"));
            if (root.isArray()) {
                for (JsonNode user : root) {
                    if (user.has("age") && user.get("age").isInt()) {
                        int age = user.get("age").asInt();
                        if (age > 25) {
                            System.out.println(user.toPrettyString());
                        }
                    }
                }
            } else {
                System.out.println("The JSON content is not an array.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
