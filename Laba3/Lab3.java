package Laba3;

import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть значення t: ");
        double t = in.nextDouble();
        System.out.print("Введіть значення s: ");
        double s = in.nextDouble();
        System.out.print("Введіть значення k: ");
        double k = in.nextDouble();
        printResults(k, s, t);


    }

    public static double check(double k) {
        if (k < 3 || k > 25) {
            throw new IllegalArgumentException("param k = " + k);
        }
        return k;
    }

    static void printResults(double k, double s, double t) {
        double summ = 0;
        double summ_1 = 0;
        try {
            System.out.println("Ваше значення k = " + check(k));
        } catch (IllegalArgumentException e) {
            System.out.println("Ваше значення k не входить в заданний у прикладі проміжок! " + e.getMessage());
            return;
        }
        for (double i = 1; i <= k; i++) {
            summ_1 = summ + Math.log(-t * i) * Math.cos(Math.sqrt(s * (1 / Math.pow(i, 2))));
            summ = summ_1;
        }

        System.out.println("Значення прикладу при k = " + k + ": " + summ);

    }
}