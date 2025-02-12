package semester_1.Laba7;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        short[][] data = {
                {},
                {1},
                {0, 3, 2, 1},
                {4, 3, 2, 1, 0},
                {6, 8, 3, 123, 5, 4, 1, 2, 0, 9, 7},
                {860, 8, 200, 9, 62, 24, 89, 19, 52, 54, 31, 91, 31, 36}
        };

        SortContext context = new SortContext(new SelectionSorter());
        Scanner scanner = new Scanner(System.in);

        for (short[] arr : data) {
            System.out.println("Виберіть тип сортування:");
            System.out.println("1. SelectionSort");
            System.out.println("2. InsertionSort");
            System.out.println("3. StalinSort");
            System.out.println("4. MergeSort");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    context.setStrategy(new SelectionSorter());
                    break;
                case 2:
                    context.setStrategy(new InsertionSort());
                    break;
                case 3:
                    context.setStrategy(new StalinSort());
                    break;
                case 4:
                    context.setStrategy(new MergeSort());
                    break;
                default:
                    System.out.println("Неправильний вибір. Через це буде використано SelectionSort.");
                    context.setStrategy(new SelectionSorter());
            }

            System.out.println("До: " + Arrays.toString(arr));
            arr = context.sortArray(arr);
            System.out.println("Після: " + Arrays.toString(arr));
        }

        scanner.close();
    }
}

