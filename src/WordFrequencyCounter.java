import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordFrequencyCounter {



    public static Map<String, Integer> countWordFrequency(String filePath) {
        Map<String, Integer> wordFrequency = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Розділити рядок на слова
                String[] words = line.split("\\s+");

                // Обробити кожне слово
                for (String word : words) {
                    // Видалити можливі символи пунктуації
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

                    // Додати слово до мапи і оновити його частоту
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordFrequency;
    }
}