package Laba3;

public class Lab3 {
    public static void main(String[] args) {
        double t = -1; //оскільки значення t не задано умовой деякий прикладів було вирішено взяти значення t як -1
                      // але по лабі треба буде зробити щоб була ще перевірка значень тож це значення тимчасове
        double s = 1; // як і це значення
        for(double k = 3; k <= 25; k++) {
            double summ = 0;
            double summ_1 = 0;
            for(double i = 1; i <= k; i++) {
                summ_1 = summ + Math.log(-t * i)*Math.cos(Math.sqrt(s*(1/Math.pow(i, 2))));
                summ = summ_1;
                System.out.println("Значення прикладу при k = " + k + " та при i = " + i +" :" + summ);
            }
        }

    }

}
