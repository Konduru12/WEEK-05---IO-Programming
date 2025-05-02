import java.io.*;
import java.util.*;
class StudentDetails {
    final String name;
    final int age;
    final int marks;
    final String grade;
    public StudentDetails(String name, int age, int marks, String grade) {
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = grade;
    }
    @Override
    public String toString() {
        return name + "," + age + "," + marks + "," + grade;
    }
}
public class MergingTwoCsvFiles{
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        String file1 = "student1.csv";
        String file2 = "student2.csv";
        String outputFile = "merged_students.csv";
        Map<String, StudentDetails> studentMap = new HashMap<>();
        try (
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {
            @SuppressWarnings("unused")
            String header1 = br1.readLine();
            @SuppressWarnings("unused")
            String header2 = br2.readLine(); 
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();
            String line;
            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0].trim();
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());
                studentMap.put(id, new StudentDetails(name, age, -1, ""));
            }
            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0].trim();
                int marks = Integer.parseInt(data[1].trim());
                String grade = data[2].trim();
                if (studentMap.containsKey(id)) {
                    StudentDetails student = studentMap.get(id);
                    student = new StudentDetails(student.name, student.age, marks, grade);
                    studentMap.put(id, student);
                }
            }
            for (Map.Entry<String, StudentDetails> entry : studentMap.entrySet()) {
                StudentDetails student = entry.getValue();
                bw.write(entry.getKey() + "," + student.toString());
                bw.newLine();
            }
            System.out.println("Merged CSV file saved as: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
