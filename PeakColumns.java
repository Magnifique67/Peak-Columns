import java.util.Scanner;

public class PeakColumns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns: ");
        int n = validateInput(sc);
        int k = validateInput(sc);
        System.out.println("Matrix A: " + n + "," + k);
        int[][] A = getMatrixElement(sc, n, k);
        int[][] peakColumns = findPeakColumns(A);

        for (int[] peak : peakColumns) {
            System.out.print("\n(" + (peak[0] + 1) + "," + (peak[1] + 1) + ")" + " = " + peak[2]);
        }
    }

    // method to validate inputs
    public static int validateInput(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Invalid Input");
            sc.next();
        }
        return sc.nextInt();
    }

    // method for getting matrix elements
    public static int[][] getMatrixElement(Scanner sc, int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = validateInput(sc);

            }

        }
        return matrix;
    }

    // finding peakColumns (elements that are both a maximum in their row and a
    // minimum in their column. )
    public static int[][] findPeakColumns(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean isPeak = true;

                for (int k = 0; k < col; k++) {
                    if (matrix[i][j] < matrix[i][k]) {
                        isPeak = false;
                        break;
                    }
                }

                for (int k = 0; k < row; k++) {
                    if (matrix[i][j] > matrix[k][j]) {
                        isPeak = false;
                        break;
                    }
                }

                if (isPeak) {
                    count++;
                }
            }
        }

        int[][] peakColumns = new int[count][3];
        int index = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean isPeak = true;

                for (int k = 0; k < col; k++) {
                    if (matrix[i][j] < matrix[i][k]) {
                        isPeak = false;
                        break;
                    }
                }

                for (int k = 0; k < row; k++) {
                    if (matrix[i][j] > matrix[k][j]) {
                        isPeak = false;
                        break;
                    }
                }

                if (isPeak) {
                    peakColumns[index][0] = i;
                    peakColumns[index][1] = j;
                    peakColumns[index][2] = matrix[i][j];
                    index++;
                }
            }
        }

        return peakColumns;
    }
}