package semester_1.Laba9;

public class BinaryStringConverter {
    public static int binaryStringToInt(String binaryString) {
        if (binaryString == null || !binaryString.matches("[01]+")) {
            throw new IllegalArgumentException("Неправильна бінарна строка");
        }
        return Integer.parseInt(binaryString, 2);
    }
}
