package Laba14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WordCounter {
    public static long numberOfWords(String filename) {
        long wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                wordCount += words.length;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Помилка: Файл не знайдено. Перевірте шлях до файлу: " + filename);
        } catch (IOException e) {
            System.err.println("Помилка при читанні файлу: " + e.getMessage());
        }
        return wordCount;
    }

    public static void main(String[] args) {
        String filename = "test.txt";
        long result = numberOfWords(filename);

        if (result > 0) {
            System.out.println("Кількість слів у файлі: " + result);
        } else {
            System.out.println("Файл не був оброблений або у файлі немає слів.");
        }
    }
}
