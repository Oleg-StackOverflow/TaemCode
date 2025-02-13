package semester_2.algorithms.Laba_1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomArrayToFile {
    public static void main(String[] args) {
        int size = 50000;
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }

        shuffleArray(array);

        writeArrayToFileSingleLine(array, "data.txt");

        System.out.println("Масив записано у файл data.txt");
    }

    private static void shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private static void writeArrayToFileSingleLine(int[] array, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]);
                if (i < array.length - 1) {
                    sb.append(" ");
                }
            }
            bw.write(sb.toString());
        } catch (IOException e) {
            System.err.println("Помилка запису у файл: " + e.getMessage());
        }
    }
}
