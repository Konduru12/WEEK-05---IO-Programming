import java.io.*;
import java.util.regex.*;

public class ValidatingRecords{
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        String filePath = "contacts.csv";
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            @SuppressWarnings("unused")
            String header = br.readLine(); 
            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] data = line.split(",");
                if (data.length < 3) {
                    System.out.println("Line " + lineNumber + ": Missing fields -> " + line);
                    continue;
                }
                @SuppressWarnings("unused")
                String name = data[0].trim();
                String email = data[1].trim();
                String phone = data[2].trim();
                boolean emailValid = emailPattern.matcher(email).matches();
                boolean phoneValid = phonePattern.matcher(phone).matches();
                if (!emailValid || !phoneValid) {
                    System.out.println("Line " + lineNumber + " - Invalid Record:");
                    if (!emailValid)
                        System.out.println("Invalid Email: " + email);
                    if (!phoneValid)
                        System.out.println("Invalid Phone: " + phone);
                    System.out.println("Full Record: " + line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
