package Laba6;

import java.util.Arrays;

public class Selection_sort_Data {
    public static void main(String[] args) {
        short[][] data = {
                {},
                {1},
                {0, 3, 2, 1},
                {4, 3, 2, 1, 0},
                {6, 8, 3, 123, 5, 4, 1, 2, 0, 9, 7},
        };
        for (short[] arr : data) {
            System.out.print(Arrays.toString(arr) + " => ");
            SelectionSorter.sort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }

}
