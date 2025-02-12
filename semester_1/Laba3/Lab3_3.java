package semester_1.Laba3;

public class Lab3_3 {
    public static void main(String[] args) {
        double epsilon = 1e-5;
        double result = computeSeries(epsilon);
        System.out.printf("Сума ряду: %.10f\n", result);
    }

    public static double computeSeries(double epsilon) {
        double sumSeries = 0.0;
        double term;
        int i = 1;

        do {
            term = Math.pow(-1, i) / factorial(i);
            sumSeries += term;
            i++;
        } while (Math.abs(term) >= epsilon);

        return sumSeries;
    }

    public static double factorial(int n) {
        double result = 1.0;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
