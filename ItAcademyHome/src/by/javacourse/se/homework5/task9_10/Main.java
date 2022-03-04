package by.javacourse.se.homework5.task9_10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    private static final Random RANDOM = new Random();

    private static final List<Box> BOXES = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        File inFirstFile = new File("src/by/javacourse/se/homework5/task9_10/OUTPUT.txt");
        File inSecondFile = new File("src/by/javacourse/se/homework5/task9_10/OUTPUT_2.txt");

        while (BOXES.size() < 5) {
            BOXES.add(createBox());
        }
        System.out.println(BOXES);
        SerializeAndDeserialize.serializeListOfObject(BOXES, inFirstFile);

        System.out.println(SerializeAndDeserialize.deserializeObjectFromFile(inFirstFile));

        writeMaxVolumeBox(inFirstFile, inSecondFile);
    }

    private static void writeMaxVolumeBox(File readFile, File writeFile) throws IOException {

        List<Box> listTmp = SerializeAndDeserialize.deserializeObjectFromFile(readFile);
        int maxVolume;

        if (!listTmp.isEmpty()) {
            Collections.sort(listTmp);
            System.out.println(listTmp);
            try (FileWriter fileWriter = new FileWriter(writeFile)) {
                maxVolume = listTmp.get(0).getVolume();
                System.out.println(maxVolume);
                fileWriter.write("maxVolume: " + maxVolume);
            } catch (IOException e) {
                System.err.println(e.getMessage() + Arrays.toString(e.getStackTrace()));
            }
        } else {
            System.out.println("Файл пуст");
        }
    }

    private static Box createBox() {
        return new Box(
                RANDOM.nextInt(10),
                RANDOM.nextInt(10),
                RANDOM.nextInt(10)
        );
    }
}
