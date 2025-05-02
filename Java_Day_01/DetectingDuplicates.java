import java.io.*;
import java.util.*;
public class DetectingDuplicates{
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        String filePath = "student.csv"; 
        Set<String> seenIds = new HashSet<>(); 
        List<String> duplicateRecords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false; 
                    continue;
                }
                String[] data = line.split(",");
                String id = data[0].trim();
                if (seenIds.contains(id)) {
                    duplicateRecords.add(line);
                } else {
                    seenIds.add(id);
                }
            }
            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records:");
                for (String record : duplicateRecords) {
                    System.out.println(record);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
