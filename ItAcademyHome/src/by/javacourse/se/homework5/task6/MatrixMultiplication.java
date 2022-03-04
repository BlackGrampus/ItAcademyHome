package by.javacourse.se.homework5.task6;

import java.io.*;

public class MatrixMultiplication {

    public static void main(String[] args) throws IOException {
        File file = new File("src/by/javacourse/se/homework5/task6/INPUT_1.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {

            String[] sizes = br.readLine().split(" ");
            int size = Integer.parseInt(sizes[0]);
            String[][] matrix = new String[size][size];
            String[][] matrix2 = new String[size][size];
            int[][] resultMatrix = new int[size][size];
            boolean isFull = false;

            br.readLine();

            while (!isFull) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i] = br.readLine().split(" ");
                    isFull = true;
                }
            }

            br.readLine();
            isFull = false;

                while (!isFull) {
                    for (int i = 0; i < matrix2.length; i++) {
                        try {
                            matrix2[i] = br.readLine().split(" ");
                            isFull = true;
                        } catch (NumberFormatException | IOException e) {
                            System.out.println("Нет числа");
                            e.printStackTrace();
                        }
                    }
                }

            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    resultMatrix[i][j] = Integer.parseInt(matrix[i][j]) * Integer.parseInt(matrix2[i][j]);
                }
            }

            System.out.println("Перемноженная матрица:");
            printArray(resultMatrix);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printArray(int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }
    }
}
