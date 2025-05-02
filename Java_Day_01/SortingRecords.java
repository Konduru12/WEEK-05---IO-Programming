import java.io.*;
import java.util.*;
public class SortingRecords{
    static class Employee {
        String name;
        String department;
        double salary;
        Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
        @Override
        public String toString() {
            return name + " | " + department + " | " + salary;
        }
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        String filePath = "employee.csv";
        List<Employee> employeeList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            @SuppressWarnings("unused")
            String header = br.readLine(); 
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[1];
                String dept = data[2];
                double salary = Double.parseDouble(data[3]);
                employeeList.add(new Employee(name, dept, salary));
            }
            employeeList.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));

            System.out.println("Top 5 Highest-Paid Employees:");
            employeeList.stream()
                        .limit(5)
                        .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
