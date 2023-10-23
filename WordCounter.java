import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Bruha\\OneDrive\\Pictures\\Desktop\\Wordcounter.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            int wordCount = 0;
            int charCount = 0;
            int lineCount = 0;
            Map<String, Integer> wordFrequency = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                String[] words = line.split("\\s+"); // Split the line into words
                for (String word : words) {
                    wordCount++;
                    word = word.toLowerCase(); // Convert to lowercase to make it case-insensitive
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }

            // Display the results
            System.out.println("Word count: " + wordCount);
            System.out.println("Character count: " + charCount);
            System.out.println("Line count: " + lineCount);

            // To display word frequencies
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
