package by.javacourse.se.homework1.task6;

public class SumAndDiffMatrix {

    public static void main(String[] args) {
        int inSizeN = 2;
        int[][] inMatrix1 = new int[inSizeN][inSizeN];
        int[][] inMatrix2 = new int[inSizeN][inSizeN];
        int[][] matrixSumResault = new int[inSizeN][inSizeN];
        int[][] matrixDiffResault = new int[inSizeN][inSizeN];

        System.out.println(" Матрица 1:");
        makeARendomMatrix(inMatrix1);
        System.out.println(" Матрица 2:");
        makeARendomMatrix(inMatrix2);
        System.out.println(" Сумма матриц 1 и 2:");
        sumMatrixs(inMatrix1, inMatrix2, matrixSumResault);
        System.out.println(" Разность матриц 1 и 2:");
        sumMatrixs(inMatrix1, inMatrix2, matrixDiffResault);
    }

    public static void makeARendomMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 20 - 5);
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void sumMatrixs(int[][] matrix, int[][] matrix2, int[][] matrixResault) {
        for (int i = 0; i < matrixResault.length; i++) {
            for (int j = 0; j < matrixResault[i].length; j++) {
                matrixResault[i][j] = matrix[i][j] + matrix2[i][j];
                System.out.print(" " + matrixResault[i][j]);
            }
            System.out.println();
        }
    }

    public static void diffMatrixs(int[][] matrix, int[][] matrix2, int[][] matrixResault) {
        for (int i = 0; i < matrixResault.length; i++) {
            for (int j = 0; j < matrixResault[i].length; j++) {
                matrixResault[i][j] = matrix[i][j] - matrix2[i][j];
                System.out.print(" " + matrixResault[i][j]);
            }
            System.out.println();
        }
    }
}
