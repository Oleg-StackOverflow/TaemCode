package Laba7;

public class StalinSort implements SortingStrategy {
    @Override
    public short[] sort(short[] array) {
        int idx = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= array[idx]) {
                array[++idx] = array[i];
            }
        }
        for (int i = idx + 1; i < array.length; i++) {
            array[i] = 0;
        }
        return array;
    }
}
