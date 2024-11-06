package Laba9;

import java.util.Scanner;

public class TextProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Виберіть опцію:");
            System.out.println("1. Перетворити бінарне число у звичайне число");
            System.out.println("2. Порахувати кількість чисел в реченні");
            System.out.println("3. Вихід");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Введіть бінарну строку: ");
                    String binaryString = scanner.nextLine();
                    try {
                        int result = BinaryStringConverter.binaryStringToInt(binaryString);
                        System.out.println("Результат: " + result);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Помилка: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Введіть речення: ");
                    String sentence = scanner.nextLine();
                    try {
                        int count = SentenceAnalyzer.countNumbersInSentence(sentence);
                        System.out.println("Кількість чисел: " + count);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Помилка: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Вихід з програми.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
            }
        }
    }
}