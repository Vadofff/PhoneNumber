import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {

    public static boolean validatePhoneNumber(String phoneNumber) {
        // Паттерни для перевірки форматів телефонних номерів
        Pattern pattern1 = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}");
        Pattern pattern2 = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");

        // Перевірка на валідність номера
        Matcher matcher1 = pattern1.matcher(phoneNumber);
        Matcher matcher2 = pattern2.matcher(phoneNumber);

        return matcher1.matches() || matcher2.matches();
    }
}