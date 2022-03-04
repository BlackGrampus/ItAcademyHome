package by.javacourse.se.homework5.task8;

import java.io.*;
import java.util.*;

public class CheckFileAndWrite {

    private static final List<String> TMP_LINE_TEXT = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        File inFirstFile = new File("src/by/javacourse/se/homework5/task8/INPUT_1.txt");
        File inSecondFile = new File("src/by/javacourse/se/homework5/task8/INPUT_2.txt");
        File outFile = new File("src/by/javacourse/se/homework5/task8/OUTPUT.txt");
        String firstLineText;
        String secondLineText;

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(inFirstFile)));

             BufferedReader br2 = new BufferedReader(
                     new InputStreamReader(
                             new FileInputStream(inSecondFile)));

             FileWriter fileWriter = new FileWriter(outFile)) {

            while ((firstLineText = br.readLine()) != null) {
                TMP_LINE_TEXT.add(firstLineText);
            }

            while ((secondLineText = br2.readLine()) != null) {
                for (String lineText : TMP_LINE_TEXT) {
                    if (secondLineText.equals(lineText)) {
                        fileWriter.write(secondLineText + "\n");
                        break;
                    }
                }
            }
            System.out.println("Successfully");

        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
