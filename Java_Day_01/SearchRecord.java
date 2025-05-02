import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchRecord{
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        String filePath = "employee.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter employee name to search: ");
            String searchName = scanner.nextLine().trim();
            String line = br.readLine(); 
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[1];
                if (name.equalsIgnoreCase(searchName)) {
                    String department = parts[2];
                    String salary = parts[3];
                    System.out.println("Department: " + department);
                    System.out.println("Salary: " + salary);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
