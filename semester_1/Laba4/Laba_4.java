package semester_1.Laba4;

public class Laba_4 {

    public static void main(String[] args) {

        int[] Mass_A = {19,6,80,72,89,21,3,82,67,93};

        int max = MaxArray(Mass_A);

        System.out.println(max);

    }
    public static int MaxArray(int[] array) {
        int max_a = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max_a && array[i] % 2 == 0) {
                max_a = array[i];

            }
        }
        return max_a;
    }
}
