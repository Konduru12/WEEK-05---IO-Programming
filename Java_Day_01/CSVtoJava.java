import java.io.*;
import java.util.*;
class Student {
    final private int id;
    final private String name;
    final private int marks;
    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    @Override
    public String toString() {
        return "Student{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                ", Marks=" + marks +
                '}';
    }
}
public class CSVtoJava{
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        String filePath = "student.csv";
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            @SuppressWarnings("unused")
            String header = br.readLine(); 
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int marks = Integer.parseInt(data[3].trim());
                Student student = new Student(id, name, marks);
                students.add(student);
            }
            students.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
