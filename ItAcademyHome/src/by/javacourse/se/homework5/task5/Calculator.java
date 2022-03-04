package by.javacourse.se.homework5.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class Calculator {

    public static void main(String[] args) throws IOException{
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int x;
            double y;
            String sign;

            while (true) {
                try {
                    System.out.println("Введите число:");
                    x = Integer.parseInt(reader.readLine());
                } catch (InputMismatchException | NumberFormatException exception) {
                    System.out.println("Это не число. Попробуйте снова.");
                    x = Integer.parseInt(reader.readLine());
                }

                System.out.println("Введите знак(+ - * / ) :");
                sign = reader.readLine();
                if (!(sign.equals("+") || sign.equals("/") || sign.equals("*") || sign.equals("-"))) {
                    System.out.println("Вы ввели неверный знак. Попробуйте снова.");
                    sign = reader.readLine();
                }

                try {
                    System.out.println("Введите число:");
                    y = Integer.parseInt(reader.readLine());
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Это не число. Попробуйте снова.");
                    y = Integer.parseInt(reader.readLine());
                }

                switch (sign) {
                    case "+" -> System.out.println("Результат: " + (x + y));
                    case "-" -> System.out.println("Результат: " + (x - y));
                    case "*" -> System.out.println("Результат: " + (x * y));
                    case "/" -> System.out.println("Результат: " + (x / y));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
