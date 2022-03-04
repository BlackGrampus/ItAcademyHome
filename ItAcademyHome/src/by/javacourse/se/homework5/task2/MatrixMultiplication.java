package by.javacourse.se.homework5.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixMultiplication {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите размер матрицы: ");
            int n;
            int[][] matrix;
            int[][] matrix2;
            int[][] resultMatrix;
            try {
                n = Integer.parseInt(reader.readLine());
                matrix = new int[n][n];
                matrix2 = new int[n][n];
                resultMatrix = new int[n][n];

                System.out.println("Первая матрица:");
                fillArray(matrix, n);
                printArray(matrix);

                System.out.println("Вторая матрица:");
                fillArray(matrix2, n);
                printArray(matrix2);

                for (int i = 0; i < resultMatrix.length; i++) {
                    for (int j = 0; j < resultMatrix[i].length; j++) {
                        resultMatrix[i][j] = matrix[i][j] * matrix2[i][j];
                    }
                }
                System.out.println("Перемноженная матрица:");
                printArray(resultMatrix);

            } catch (NumberFormatException e) {
                System.out.println("Вы должны ввести число:");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fillArray(int[][] array, int n) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.printf("Введите %d цифр (через  Enter), чтобы заполнить матрицу: ", (n * n));
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    array[i][j] = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException | IOException e) {
                    System.out.println("Это не число. Попробуйте еще.");
                    array[i][j] = Integer.parseInt(reader.readLine());
                }
            }
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
