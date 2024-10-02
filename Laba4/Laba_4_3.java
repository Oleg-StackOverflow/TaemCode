package Laba4;

import java.util.Arrays;

public class Laba_4_3 {
    public static void main(String[] args) {

        int[] Mass_A = {19,-6,80,0,89,21,3,62,67,100};

        int[] Mass_B = transformArray(Mass_A);

        System.out.println(Arrays.toString(Mass_B));

    }
    public static int[] transformArray(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                newArray[i] = array[i];
            } else if (array[i] == 0) {
                newArray[i] = 1;
            } else {
                newArray[i] = array[i] * 2;
            }
        }
        return newArray;
    }
}
