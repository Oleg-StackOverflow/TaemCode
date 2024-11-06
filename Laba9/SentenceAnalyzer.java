package Laba9;

public class SentenceAnalyzer {
    public static int countNumbersInSentence(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Речення не може бути порожнім");
        }

        String[] words = sentence.split("\\s+");
        int count = 0;

        for (String word : words) {
            if (word.matches("\\b\\d+\\b")) {
                count++;
            }
        }

        return count;
    }
}