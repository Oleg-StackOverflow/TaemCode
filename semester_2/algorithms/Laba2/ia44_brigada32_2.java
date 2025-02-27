package semester_2.algorithms.Laba2;
import java.io.*;
import java.util.*;

public class ia44_brigada32_2 {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        int[][] matrix = readMatrixFromFile(inputFilePath);

        if (matrix == null || matrix.length == 0) {
            System.out.println("Помилка. Некоректні данні в коді");
            return;
        }

        int userIndex = 1;
        if (userIndex >= 0 && userIndex < matrix.length) {
            int[] inversions = countInversions(matrix, userIndex);

            List<int[]> indexedInversions = new ArrayList<>();
            for (int i = 0; i < inversions.length; i++) {
                if (i != userIndex) {
                    indexedInversions.add(new int[]{i + 1, inversions[i]});
                }
            }

            indexedInversions.sort(Comparator.<int[]>comparingInt(a -> a[1]).thenComparingInt(a -> a[0]));

            writeResultsToFile(outputFilePath, userIndex + 1, indexedInversions);
        } else {
            System.out.println("Помилка. Некоректний індекс користувача.");
        }
    }

    public static int[][] readMatrixFromFile(String filePath) {
        List<int[]> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            if (line == null) {
                System.out.println("Помилка: Файл пустий.");
                return null;
            }

            String[] dimensions = line.trim().split("\\s+");
            if (dimensions.length != 2) {
                System.out.println("Помилка: Перша строка не задовольняє умови.");
                return null;
            }

            int rowCount, colCount;
            try {
                rowCount = Integer.parseInt(dimensions[0]);
                colCount = Integer.parseInt(dimensions[1]);
            } catch (NumberFormatException e) {
                System.out.println("Помилка. Некоректний формат матриці");
                return null;
            }

            for (int i = 0; i < rowCount; i++) {
                line = br.readLine();
                if (line == null) {
                    System.out.println("Помилка. Недостатньо строк у файлі");
                    return null;
                }

                String[] values = line.trim().split("\\s+");
                if (values.length != colCount) {
                    System.out.println("Помилка: В строці " + (i + 1) + " некоректна кількість чисел.");
                    return null;
                }

                int[] row = Arrays.stream(values).mapToInt(Integer::parseInt).toArray();
                rows.add(row);
            }
        } catch (IOException e) {
            System.out.println("Помилка в читанні файлу.");
            return null;
        }
        return rows.toArray(new int[0][]);
    }

    public static int[] countInversions(int[][] matrix, int userIndex) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int[] inversions = new int[numRows];
        int[] userRow = matrix[userIndex];

        for (int i = 0; i < numRows; i++) {
            if (i == userIndex) continue;

            int count = 0;
            for (int j = 0; j < numCols; j++) {
                for (int k = j + 1; k < numCols; k++) {
                    if ((userRow[j] < userRow[k] && matrix[i][j] > matrix[i][k]) ||
                            (userRow[j] > userRow[k] && matrix[i][j] < matrix[i][k])) {
                        count++;
                    }
                }
            }
            inversions[i] = count;
        }
        return inversions;
    }

    public static void writeResultsToFile(String filePath, int user, List<int[]> indexedInversions) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Кількість інверсій порівняно з користувачем " + user + " (у порядку зростання):\n");
            for (int[] pair : indexedInversions) {
                writer.write(pair[0] + " " + pair[1] + "\n");
            }
            System.out.println("Результати збережено у файл: " + filePath);
        } catch (IOException e) {
            System.out.println("Помилка запису у файл.");
        }
    }
}
