package by.javacourse.se.homework5.task7;

import java.io.*;
import java.util.*;

public class ReverseFileAndWrite {

    private static final List<String> TMP_LINE_TEXT = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        File inFile = new File("src/by/javacourse/se/homework5/task7/INPUT.txt");
        File outFile = new File("src/by/javacourse/se/homework5/task7/OUTPUT.txt");
        String lineText;

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(inFile)));
             FileWriter fileWriter = new FileWriter(outFile)) {

            while ((lineText = br.readLine()) != null) {
                TMP_LINE_TEXT.add(lineText);
            }
            for (int i = TMP_LINE_TEXT.size() - 1; i > -1; i--) {
                fileWriter.write(TMP_LINE_TEXT.get(i) + "\n");
            }
            System.out.println("Successfully");
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
