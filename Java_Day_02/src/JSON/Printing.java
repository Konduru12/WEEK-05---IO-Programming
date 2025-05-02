package JSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
public class Printing{
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(new File("data.json"));
            printJson(rootNode, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void printJson(JsonNode node, String path) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                printJson(entry.getValue(), path + "/" + entry.getKey());
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                printJson(node.get(i), path + "[" + i + "]");
            }
        } else {
            System.out.println(path + " : " + node.asText());
        }
    }
}
