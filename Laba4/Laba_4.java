package Laba4;

public class Laba_4 {

    public static void main(String[] args) {

        int[] Mass_A = new int[]{19,6,80,72,89,21,3,62,67,93};

        int max = Mass_A[0];
        for (int i = 1; i < Mass_A.length; i++) {
            if (Mass_A[i] > max && Mass_A[i] % 2 == 0) {
                max = Mass_A[i];

            }
        }
        System.out.println(max);

    }

}
