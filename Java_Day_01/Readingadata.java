import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Readingadata{
    @SuppressWarnings("UnnecessaryReturnStatement")
    public static void main(String[] args) {
        String line;
        String csvFile = "student.csv"; 
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String id = data[0];
                    String name = data[1];
                    String age = data[2];
                    String marks = data[3];

                    System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks);
                }
            }
        } catch (IOException e) {
            return;
        }
    }
}
