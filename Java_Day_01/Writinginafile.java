
import java.io.*;
public class Writinginafile{
    @SuppressWarnings("UnnecessaryReturnStatement")
    public static void main(String[] args) {
        String filePath = "student.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("106,Laxmi,Finance,62000\n");
            writer.write("107,Venkat,Sales,58000\n");
            writer.write("108,Pranav,SOftware,900000\n");
            writer.write("109,Mounika,IT Manager,25000\n");
            writer.write("110,Nikitha,Fashion,10000\n");
            System.out.println("CSV file written successfully!");
        } catch (IOException e) {
            return;
        }
    }
}

