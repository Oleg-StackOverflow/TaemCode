package semester_2.algorithms.Laba3;

import java.io.*;
import java.util.*;

public class SortingComparison {
    public static void main(String[] args) {
        int[] array = readDataFromFile("data.txt");
        if (array == null || array.length == 0) {
            System.out.println("Файл порожній або неправильно відформатований.");
            return;
        }

        int[] arr1 = array.clone();
        int[] arr2 = array.clone();
        int[] arr3 = array.clone();

//        QuickSorter.comparisons = 0;
//        MedianQuickSorter.comparisons = 0;
        ThreePivotQuickSort.comparisons = 0;

//        QuickSorter.sort(arr1);
//        MedianQuickSorter.sort(arr2);
        ThreePivotQuickSort.sort(arr3);

//        long comp1 = QuickSorter.comparisons;
//        long comp2 = MedianQuickSorter.comparisons;
        long comp1 = 0;
        long comp2 = 0;
        long comp3 = ThreePivotQuickSort.comparisons;

        writeOutputToFile("output.txt", comp1, comp2, comp3);
    }

    public static int[] readDataFromFile(String filename) {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            if (line == null) return null;
            int n = Integer.parseInt(line.trim());
            for (int i = 0; i < n; i++) {
                line = br.readLine();
                if (line == null) break;
                list.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
            return null;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void writeOutputToFile(String filename, long comp1, long comp2, long comp3) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(comp1 + " " + comp2 + " " + comp3);
        } catch (IOException e) {
            System.err.println("Помилка запису файлу: " + e.getMessage());
        }
    }
}