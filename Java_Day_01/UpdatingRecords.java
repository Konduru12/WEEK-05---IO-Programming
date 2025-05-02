import java.io.*;
public class UpdatingRecords{
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        String inputFile = "employee.csv";
        String outputFile = "updated_employees.csv";
        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String header = br.readLine();
            bw.write(header);
            bw.newLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[1];
                String department = data[2];
                double salary = Double.parseDouble(data[3]);
                if (department.equalsIgnoreCase("IT")) {
                    salary *= 1.10; 
                }
                bw.write(name + "," + department + "," + String.format("%.2f", salary));
                bw.newLine();
            }
            System.out.println("Updated records saved to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
