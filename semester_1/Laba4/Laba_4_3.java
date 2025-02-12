package semester_1.Laba4;

import java.util.Arrays;

public class Laba_4_3 {
    public static void main(String[] args) {

        int[] Mass_A = {19,-6,80,0,89,21,3,62,67,100};

        int[] Mass_B = transformArray(Mass_A);

        System.out.println(Arrays.toString(Mass_B));

    }
    public static int[] transformArray(int[] array) {
        int[] newArray = new int[array.length];
        int max_a = 0;
        for (int a = 1; a < array.length; a++) {
            if (array[a] > max_a) {
                max_a = array[a];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                newArray[i] = array[i]+ max_a;
            } else if (array[i] == 0) {
                newArray[i] = 1;
            } else {
                newArray[i] = array[i] * 2;
            }
        }
        return newArray;
    }
}
