package by.javacourse.se.homework5.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortNumbers {
    private static final String STOP = "stop";
    private static final String STATUS = "status";

    public static void main(String[] args) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        String intValue;
        String lineText;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.printf("Введите число. Чтобы закончить - введите \"%s\"." +
                "\nЧтобы вывести все введенные числа в отсортированном виде - введите  \"%s\".\n", STOP, STATUS);
        while ((intValue = br.readLine()) != null) {
            try {
                if (intValue.trim().equalsIgnoreCase(STOP)) {
                    break;
                } else if (intValue.trim().equalsIgnoreCase(STATUS)) {
                    Collections.sort(numbers);
                    System.out.println(numbers);
                    break;
                }
                int number = Integer.parseInt(intValue);
                numbers.add(number);

            } catch (NumberFormatException | ArithmeticException e) {
                e.printStackTrace();

            }
        }
        System.out.printf("Чтобы вывести все введенные числа в отсортированном виде - введите  \"%s\".\n", STATUS);
        while (true) {
            try {
                lineText = br.readLine();
                    if (lineText.trim().equalsIgnoreCase(STATUS)) {
                        Collections.sort(numbers);
                        System.out.println(numbers);
                        break;
                    } else {
                        System.out.println("Неверная команда");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
