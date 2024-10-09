package Laba5;

public class Laba5_1 {

        public static void clearNE(int[][] matrix) {


            int rows = matrix.length;
            int cols = matrix[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = i; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        public static void printMatrix(int[][] matrix) {
            for(int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++){
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }
        }


        public static void main(String[] args) {
            int[][] matrix = {
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}
            };

            System.out.println("Матриця оригінальна:");

            printMatrix(matrix);



            clearNE(matrix);

            System.out.println("\nМатриця після заміни елементів на головній діагоналі та вище нулями:");

            printMatrix(matrix);
        }

}
