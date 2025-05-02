import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberOfRecords{
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        String filePath = "student.csv";
        int rowCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            @SuppressWarnings("unused")
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                rowCount++;
            }
            System.out.println("Number of records: " + rowCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
