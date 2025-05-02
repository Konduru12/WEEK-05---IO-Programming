package JSON;
import org.json.JSONObject;
public class MergingtwoJsonfiles{
    public static void main(String[] args) {
        JSONObject json1 = new JSONObject();
        json1.put("name", "Abhinaya");
        json1.put("age", 21);
        JSONObject json2 = new JSONObject();
        json2.put("email", "sriabhinaya2003@gmail.com");
        json2.put("city", "Kavali");
        for (String key : json2.keySet()) {
            json1.put(key, json2.get(key));
        }
        System.out.println(json1.toString(2));
    }
}
