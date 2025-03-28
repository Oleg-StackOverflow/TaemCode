package semester_2.laba7op;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class WordFrequencyParallel {

    private static final Map<String, Integer> fileWordCounts = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        String[] files = {
                "file1.txt",
                "file2.txt",
                "file3.txt",
                "file4.txt",
                "file5.txt",
                "file6.txt"
        };

        // Виконуємо паралельну обробку
        long startParallel = System.currentTimeMillis();
        processFilesInParallel(files);
        long endParallel = System.currentTimeMillis();

        // Вивід результатів для кожного файлу
        for (String file : files) {
            System.out.println("Кількість слів у " + file + ": " + fileWordCounts.getOrDefault(file, 0));
        }

        System.out.println("Паралельна обробка завершена за " + (endParallel - startParallel) + " мс");

        // Послідовна обробка
        long startSequential = System.currentTimeMillis();
        Map<String, Integer> sequentialResults = processFilesSequentially(files);
        long endSequential = System.currentTimeMillis();

        for (String file : files) {
            System.out.println("Кількість слів у " + file + " (послідовно): " + sequentialResults.getOrDefault(file, 0));
        }

        System.out.println("Послідовна обробка завершена за " + (endSequential - startSequential) + " мс");
    }

    // Паралельна обробка файлів за допомогою ExecutorService
    private static void processFilesInParallel(String[] files) {
        int numThreads = files.length; // можна експериментувати із кількістю потоків
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<?>> futures = new ArrayList<>();

        for (String file : files) {
            Future<?> future = executor.submit(() -> {
                Map<String, Integer> localFrequency = processFile(file);
                int wordCount = localFrequency.values().stream().mapToInt(Integer::intValue).sum();
                fileWordCounts.put(file, wordCount);
            });
            futures.add(future);
        }

        // Очікуємо завершення всіх завдань
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }

    // Послідовна обробка файлів
    private static Map<String, Integer> processFilesSequentially(String[] files) {
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String file : files) {
            Map<String, Integer> localFrequency = processFile(file);
            int wordCount = localFrequency.values().stream().mapToInt(Integer::intValue).sum();
            wordCounts.put(file, wordCount);
        }
        return wordCounts;
    }

    // Метод зчитування файлу та підрахунку слів
    private static Map<String, Integer> processFile(String filename) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            // Читаємо файл рядок за рядком
            while ((line = br.readLine()) != null) {
                // Розбиваємо рядок на слова (за пробілами та іншими пропусками)
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase();
                        frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не знайдено: " + filename);
        } catch (IOException e) {
            System.err.println("Помилка вводу-виводу при читанні файлу: " + filename);
        }
        return frequencyMap;
    }
}
