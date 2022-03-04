package by.javacourse.se.homework5.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AverageIntegerValue {

    private static final String STOP = "stop";

    public static void main(String[] args) throws IOException {
        int counter = 0;
        double sumResult = 0;
        String intValue;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.printf("Введите целое число. Чтобы закончить - введите \"%s\". \n", STOP);
        while ((intValue = br.readLine()) != null) {
            try {
                if (intValue.trim().equalsIgnoreCase(STOP)) {
                    System.out.println(sumResult / counter);
                    break;
                }
                int number = Integer.parseInt(intValue);
                sumResult = sumResult + number;
                counter++;
            } catch (NumberFormatException | ArithmeticException e) {
                e.printStackTrace();
                System.out.println(sumResult / counter);
            }
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
