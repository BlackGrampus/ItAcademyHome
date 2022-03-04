package by.javacourse.se.homework5.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

    private static final String STOP = "stop";
    private static String lineText;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.printf("Введите строку. Чтобы закончить - введите \"%s\". \n", STOP);
        while (true) {
            try {
                lineText = br.readLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
            if (lineText.equalsIgnoreCase(STOP)) {
                break;
            }
            System.out.println(lineText);
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
