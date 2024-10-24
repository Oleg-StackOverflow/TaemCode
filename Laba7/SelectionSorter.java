package Laba7;

public class SelectionSorter implements SortingStrategy {
    @Override
    public short[] sort(short[] array) {
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
        return array;
    }
}

