import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String relativePath  = "src/resurs/file.txt";
        PhoneNumberReader.readAndValidatePhoneNumbers(relativePath);

        String filePath = "src/resurs/fileName.txt";
        String outputPath = "src/resurs/user.json";
        List<User> users = readUsersFromFile(filePath);
        writeUsersToJson(users, outputPath);
        String filePathName = "src/resurs/words.txt";
        Map<String, Integer> wordFrequency = WordFrequencyCounter.countWordFrequency(filePathName);
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static List<User> readUsersFromFile(String filePath) {
        List<User> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String headerLine = reader.readLine(); // читаємо заголовок
            String[] headers = headerLine.split("\\s+");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split("\\s+");
                User user = new User(values[0], Integer.parseInt(values[1]));
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    private static void writeUsersToJson(List<User> users, String outputPath) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(outputPath)) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}