import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PhoneNumberReader {

    public static void readAndValidatePhoneNumbers(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Видалення зайвих пробілів
                String phoneNumber = line.trim();

                // Перевірка валідності телефонного номера
                if (PhoneValidator.validatePhoneNumber(phoneNumber)) {
                    System.out.println(phoneNumber);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}