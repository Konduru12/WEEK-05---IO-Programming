import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilteringRecords{
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        String filePath = "student.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); 
            System.out.println("Students with marks > 80:");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[1];
                int marks = Integer.parseInt(parts[3]);

                if (marks > 80) {
                    System.out.println(name + " - " + marks);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
