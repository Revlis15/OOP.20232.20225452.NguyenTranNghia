import java.util.Scanner;
public class EX66 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns for the matrices: ");
        int rows = sr.nextInt();
        int columns = sr.nextInt();

        int[][] matrix1 = new int[rows][columns];
        int[][] matrix2 = new int[rows][columns];

        System.out.println("Enter the elements of the first matrix:");
        inputMatrix(sr, matrix1);

        System.out.println("Enter the elements of the second matrix:");
        inputMatrix(sr, matrix2);

        int[][] sumMatrix = addMatrices(matrix1, matrix2);

        System.out.println("The sum of the matrices is:");
        printMatrix(sumMatrix);
    }

    public static void inputMatrix(Scanner sr, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = sr.nextInt();
            }
        }
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;
        int[][] sumMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return sumMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}