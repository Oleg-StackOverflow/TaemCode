package Laba7;

import java.util.ArrayList;

public class StalinSort implements SortingStrategy {

    @Override
    public short[] sort(short[] array) {
        if (array.length == 0) {
            return array;
        }

        ArrayList<Short> sortedList = new ArrayList<>();
        short currentMax = array[0];
        sortedList.add(currentMax);

        for (short i = 1; i < array.length; i++) {
            if (array[i] >= currentMax) {
                currentMax = array[i];
                sortedList.add(currentMax);
            }
        }

        short[] resultArray = new short[sortedList.size()];
        for (short i = 0; i < sortedList.size(); i++) {
            resultArray[i] = sortedList.get(i);
        }

        return resultArray;
    }
}
