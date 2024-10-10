package Laba5;

public class Laba5_2 {

    public static int[][] multiply(int[][] a, int[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Кількість стовпців першої матриці має дорівнювати кількості рядків другої матриці.");
        }

        int[][] result = new int[rowsA][colsB];


        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] matrixA = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrixB = {
                {7, 8, 9},
                {9, 10, 11},
                {11, 12, 13}
        };

        int[][] product = multiply(matrixA, matrixB);


        System.out.println("Результат множення матриць:");
        for (int i = 0; i < product.length; i++) {
            for (int j = 0; j < product[0].length; j++) {
                System.out.print(product[i][j] + " ");
            }
            System.out.println();
        }
    }

}
