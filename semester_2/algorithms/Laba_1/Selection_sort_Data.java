package semester_2.algorithms.Laba_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Selection_sort_Data {
    public static void main(String[] args) {
        int[][] data = readDataFromFile("data.txt");

        if (data.length == 0) {
            System.out.println("Файл порожній або неправильно відформатований.");
            return;
        }

        for (int[] arr : data) {
            System.out.print(Arrays.toString(arr) + " => ");
            SelectionSorter.sort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] readDataFromFile(String filename) {
        List<int[]> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] numbers = line.trim().split("\\s+|,");
                int[] array = Arrays.stream(numbers)
                        .mapToInt(Integer::parseInt)
                        .toArray();
                dataList.add(array);
            }
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Файл містить некоректні дані.");
        }

        return dataList.toArray(new int[0][]);
    }
}