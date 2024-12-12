package Laba14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileCypher {
    public static void cypher(String source, String destination, byte key) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {


            int data;
            while ((data = fis.read()) != -1) {
                int encryptedData = data ^ key;

                fos.write(encryptedData);
            }

            System.out.println("Файл успішно зашифровано!");
        } catch (FileNotFoundException e) {
            System.err.println("Помилка: Файл не знайдено. Перевірте шлях до файлу: " + source);
        } catch (IOException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String source = "K:\\код\\Laba14\\test.txt";
        String destination = "K:\\код\\Laba14\\encrypted.txt";
        byte key = 42;

        cypher(source, destination, key);
    }
}
