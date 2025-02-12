package semester_2.algorithms.Laba_1;

public class SelectionSorter {
    public static void sort(int[] array) {
        long startTime = System.nanoTime();

        int comparisons = 0;
        int swaps = 0;

        for (int i = 0; i < array.length; i++) {
            int pos = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                comparisons++;
                if (array[j] < min) {
                    pos = j;
                    min = array[j];
                }
            }
            if (pos != i) {
                int temp = array[i];
                array[i] = array[pos];
                array[pos] = temp;
                swaps++;
            }
        }

        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1_000_000_000.0;

        System.out.println("Час виконання сортування: " + elapsedTime + " секунд");
        System.out.println("Кількість порівнянь: " + comparisons);
        System.out.println("Кількість перестановок: " + swaps);
    }
}
