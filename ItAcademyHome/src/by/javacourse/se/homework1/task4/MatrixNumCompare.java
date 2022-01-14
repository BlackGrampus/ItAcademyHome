package by.javacourse.se.homework1.task4;

public class MatrixNumCompare {

    public static void main(String[] args) {
        int inMatrix[][] = {{1, 2, 3, 4}, {-1, -2, 3, 4}, {1, 2, -3, -4}, {-1, -2, -3, -4}};
        compareNumMatrix(inMatrix);
    }

    public static void compareNumMatrix(int[][] matrix) {
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) {
                    counter++;
                } else if (matrix[i][j] < 0) {
                    counter--;
                }
            }
        }
        if (counter != 0) {
            if (counter > 0) {
                System.out.println("Больше положительных чисел ");
            } else if (counter < 0) {
                System.out.println("Больше отрицательных чисел ");
            }
        } else {
            System.out.println("Равное колличество или все элементы равны нулю");
        }
    }
}
