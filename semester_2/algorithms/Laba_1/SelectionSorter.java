package semester_2.algorithms.Laba_1;

public class SelectionSorter {
    public static void sort(short[] array) {
        long startTime = System.nanoTime();

        for (int i = 0; i < array.length; i++) {
            int pos = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    pos = j;
                    min = array[j];
                }
            }
            array[pos] = array[i];
            array[i] = (short) min;
        }

        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1_000_000_000.0; // Переведення в секунди
        System.out.println("Час виконання сортування: " + elapsedTime + " секунд");
    }
}