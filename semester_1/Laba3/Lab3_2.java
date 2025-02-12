package semester_1.Laba3;

import java.util.Scanner;

public class Lab3_2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введіть значення t: ");
        double t = in.nextDouble();
        System.out.print("Введіть значення n: ");
        double n = in.nextDouble();
        printResults(n, t);

    }

    static void printResults(double n, double t) {

        double summ = 0;
        double summ_1 = 0;

        if(t < 0) {

            for (double i = 1; i < n; i++) {

                summ_1 = summ + Math.pow(t, 2)*i;
                summ = summ_1;

            }
            System.out.println("Значення прикладу при n = " + n + ": " + summ);

        } else {

            for (double i = 1; i < n; i++) {

                summ_1 = summ + Math.sqrt(t*i);
                summ = summ_1;

            }

            System.out.println("Значення прикладу при n = " + n + ": " + summ);

        }


    }
}
