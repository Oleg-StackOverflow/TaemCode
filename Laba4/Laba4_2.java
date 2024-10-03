package Laba4;

public class Laba4_2 {
    public static void main(String[] args) {
        int[] array = {12, 45, 18, 22, 89, 54, 33, 76, 27, 48,
                55, 62, 97, 21, 10, 98, 847, 192, 543, 406, 615,
                804, 623, 431, 150, 291, 786, 58, 219, 943, 650,
                377, 504, 86, 725, 300, 909, 16, 763, 871, 254,
                35, 681, 470, 588, 102, 240, 755, 538, 907, 439,
                10, 124, 853, 690, 306, 461, 298, 821, 943, 567,
                92, 433, 766, 203, 998, 812, 77, 312, 465, 134,
                582, 714, 956, 245, 382, 646, 190, 37, 720, 509,
                837, 418, 652, 309, 101, 76, 612, 945, 500, 263,
                158, 301, 890, 23, 641, 268, 564, 732, 487, 279,
                68, 936, 154, 481, 396, 530, 415, 604, 886, 948};


        int maxElement = MaxArray(array);

        System.out.println(maxElement);

    }

    public static int MaxArray(int[] array) {
        int max_a = 0;
        for (int num : array) {
            if (num > max_a && num % 6 == 0) {
                max_a = num;

            }
        }
        return max_a;
    }
}
