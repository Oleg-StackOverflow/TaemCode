package semester_2.algorithms.Laba3;

import java.util.ArrayList;

public class ThreePivotQuickSort {

    public static long comparisons = 0;

    public static void sort(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        threePivotQuickSort(A, 0, A.length - 1);
    }

    private static void threePivotQuickSort(int[] A, int left, int right) {
        if (left >= right) {
            return;
        }
        // Якщо підмасив містить менше трьох елементів то виконується просте сортування
        if (right - left + 1 < 3) {
            comparisons++;
            if (A[left] > A[right]) {
                swap(A, left, right);
            }
            return;
        }

        // Вибір опорних елементів: A[left], A[left+1] та A[right]
        int q1 = A[left];
        int q2 = A[left + 1];
        int q3 = A[right];

        // Впорядкування опорних елементів, щоб виконувалось: q1 < q2 < q3
        comparisons++;
        if (q1 > q2) {
            int temp = q1;
            q1 = q2;
            q2 = temp;
        }
        comparisons++;
        if (q2 > q3) {
            int temp = q2;
            q2 = q3;
            q3 = temp;
        }
        comparisons++;
        if (q1 > q2) {
            int temp = q1;
            q1 = q2;
            q2 = temp;
        }

        ArrayList<Integer> seg1 = new ArrayList<>();
        ArrayList<Integer> seg2 = new ArrayList<>();
        ArrayList<Integer> seg3 = new ArrayList<>();
        ArrayList<Integer> seg4 = new ArrayList<>();

        for (int i = left + 2; i <= right - 1; i++) {
            comparisons++; // порівняння A[i] з q1
            if (A[i] < q1) {
                seg1.add(A[i]);
            } else {
                comparisons++; // порівняння A[i] з q2
                if (A[i] < q2) {
                    seg2.add(A[i]);
                } else {
                    comparisons++; // порівняння A[i] з q3
                    if (A[i] < q3) {
                        seg3.add(A[i]);
                    } else {
                        seg4.add(A[i]);
                    }
                }
            }
        }

        // Об'єднання сегментів разом з опорними елементами у порядку:
        // [seg1, q1, seg2, q2, seg3, q3, seg4]
        int index = left;
        index = copyList(seg1, A, index);
        int pos_q1 = index;
        A[index++] = q1;
        index = copyList(seg2, A, index);
        int pos_q2 = index;
        A[index++] = q2;
        index = copyList(seg3, A, index);
        int pos_q3 = index;
        A[index++] = q3;
        index = copyList(seg4, A, index);

        // Рекурсивне сортування отриманих підмасивів
        threePivotQuickSort(A, left, pos_q1 - 1);
        threePivotQuickSort(A, pos_q1 + 1, pos_q2 - 1);
        threePivotQuickSort(A, pos_q2 + 1, pos_q3 - 1);
        threePivotQuickSort(A, pos_q3 + 1, right);
    }

    private static int copyList(ArrayList<Integer> list, int[] dest, int index) {
        for (int num : list) {
            dest[index++] = num;
        }
        return index;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
