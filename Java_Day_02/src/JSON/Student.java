package JSON;

import org.json.JSONArray;
import org.json.JSONObject;

public class Student{
    public static void main(String[] args) {
        JSONObject student = new JSONObject();
        student.put("name", "Abhinaya");
        student.put("age", 21);

        JSONArray subjects = new JSONArray();
        subjects.put("Math");
        subjects.put("Physics");
        subjects.put("Computer Science");

        student.put("subjects", subjects);

        System.out.println(student.toString(2)); 
    }
}
