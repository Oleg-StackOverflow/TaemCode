package semester_1.Laba14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileCypher {
    public static void cypher(String source, String destination, byte key) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    buffer[i] = (byte) (buffer[i] ^ key);
                }
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Файл успішно зашифровано!");

        } catch (FileNotFoundException e) {
            System.err.println("Помилка: Файл не знайдено. Перевірте шлях до файлу: " + source);
        } catch (IOException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String source = "test.txt";
        String destination = "encrypted.txt";
        byte key = 42;

        cypher(source, destination, key);
    }
}
