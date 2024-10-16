package Laba6;

public class InsertionSort {
    public static void main(String a[]) {
        short[] myArray  = {860,8,200,9,62, 24, 89, 19, 52, 54,
                31, 91, 31, 36, 62, 24, 89, 19, 52, 54, 31, 91,
                31, 36, 62, 24, 89, 19, 52, 54, 31, 91, 31, 36};

        System.out.println("До сортування");

        printArray(myArray);

        insertionSort(myArray);

        System.out.println("Після сортування");

        printArray(myArray);
    }
    public static void insertionSort(short[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            System.out.println(i);
            short key = arr[i];
            int j = i-1;

            while ( (j > -1) && ( arr [j] > key ) ) {
                System.out.println("Порівняння "+ key  + " та " + arr [j]);
                arr [j+1] = arr [j];
                j--;
            }
            arr[j+1] = key;
            System.out.println("Перероблений масив");
            printArray(arr);
        }
    }
    static void printArray(short[] array) {

        for (int i=0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }
}
