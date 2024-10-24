package Laba7;


public class InsertionSort implements SortingStrategy {
    public short[] sort(short[] array) {
        for (int i = 1; i < array.length; i++) {
            short key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }
}


