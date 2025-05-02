import java.io.*;
public class LargeCsv{
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        String filePath = "student.csv";
        int chunkSize = 100; 
        int recordCount = 0;
        int chunkCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentLine = 0;
            @SuppressWarnings("unused")
            String header = br.readLine();  
            while ((line = br.readLine()) != null) {
                currentLine++;
                System.out.println(line); 
                recordCount++;
                if (currentLine % chunkSize == 0) {
                    chunkCount++;
                    System.out.println("Processed " + chunkSize + " records in chunk " + chunkCount);
                }
            }
            if (recordCount % chunkSize != 0) {
                chunkCount++;
                System.out.println("Processed " + (recordCount % chunkSize) + " records in chunk " + chunkCount);
            }

            System.out.println("Total records processed: " + recordCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
