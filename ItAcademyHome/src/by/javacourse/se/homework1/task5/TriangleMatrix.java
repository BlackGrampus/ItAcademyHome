package by.javacourse.se.homework1.task5;

public class TriangleMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}};
        checkTriangleMatrix(matrix);
    }

    public static void checkTriangleMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            System.out.println("Матрица пуста");
            return;

        } else {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i].length != matrix.length) {
                    System.out.println("Матрица не квадратная");
                    return;
                }
            }

            int iteration = 0;
            int counterZero = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        counterZero++;
                    }
                    iteration++;
                }
            }

            if (iteration != 0) {
                if (iteration == counterZero) {
                    System.out.println("Все элементы матрицы равны нулю");
                    return;
                }
            }

            for (int i = 0, k = 1; i < matrix.length; i++, k++) {
                for (int j = k; j < matrix[i].length; j++) {
                    if (matrix[i][j] != 0) {
                        System.out.println("Матрица не нижняя треугольная");
                        return;
                    }
                }
            }
            System.out.println("Матрица нижняя треугольная");
        }
    }
}
