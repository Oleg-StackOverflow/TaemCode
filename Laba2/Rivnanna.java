package Laba2;

public class Rivnanna {
    public static void main(String[] args) {
        double a = 0.58d;
        double b = -0.34d;
        double c = 1.25d;
        double d = 0.89d;
        double result1 = Math.sqrt(c)/Math.tan(a)+Math.sqrt(1/Math.tanh(2*c)/ Logarithm.log(a, d));

        System.out.println(result1);

        d = 7.89d;
        a = -0.58d;

        double result2_1 = Math.abs(b)*c/Logarithm.log(c, d);

        double result2_2 = Math.abs(2*c/a+Math.sqrt(Math.tanh(result2_1)));

        double result2 = Math.log(result2_2);

        System.out.println(result2);

        a = 2.54d;
        b = -1.34;
        c = 1.05d;
        d = 0.78d;

        double result3_1 = Math.sqrt(c);

        double result3_2 = Math.abs(b)*c/Logarithm.log(result3_1, d);

        double result3_3 = Math.abs(2*c/a+Math.sqrt(Math.tanh(result3_2)));

        double result3 = Logarithm.log(a, result3_3);

        System.out.println(result3);

    }

}
