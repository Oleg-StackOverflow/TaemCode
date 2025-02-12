package semester_1.Laba6;

import java.util.Arrays;

public class Selection_sort_Data {
    public static void main(String[] args) {
        short[][] data = {
                {},
                {1},
                {0, 3, 2, 1},
                {4, 3, 2, 1, 0},
                {6, 8, 3, 123, 5, 4, 1, 2, 0, 9, 7},
                {860,8,200,9,62, 24, 89, 19, 52, 54, 31, 91, 31, 36, 62, 24, 89, 19, 52, 54, 31, 91, 31, 36, 62, 24, 89, 19, 52, 54, 31, 91, 31, 36}
        };
        for (short[] arr : data) {
            System.out.print(Arrays.toString(arr) + " => ");
            SelectionSorter.sort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }

}
