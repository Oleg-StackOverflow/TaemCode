package Laba2;

public class Math {
    public static void main(String[] args) {
        double a = 0.58d;
        double b = -0.34d;
        double c = 1.25d;
        double d = 0.89d;
        double result1 = java.lang.Math.sqrt(c)/java.lang.Math.tan(a)+java.lang.Math.sqrt(1/java.lang.Math.tanh(2*c)/ Logarithm.log(a, d));

        System.out.println(result1);

        d = 7.89d;
        a = -0.58d;

        double result2 = java.lang.Math.log(java.lang.Math.abs(2*c/a+java.lang.Math.sqrt(java.lang.Math.tanh(java.lang.Math.abs(b)*c)/Logarithm.log(c, d))));

        System.out.println(result2);

        a = 2.54d;
        b = -1.34;
        c = 1.05d;
        d = 0.78d;

        double result3 = Logarithm.log(a, java.lang.Math.abs(c/a*java.lang.Math.sqrt(java.lang.Math.tanh(java.lang.Math.abs(b)*c)/Logarithm.log(java.lang.Math.sqrt(c), d))));

        System.out.println(result3);

    }

}
