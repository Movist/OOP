public class Main {
    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Matrix matrix1 = new Matrix(matrix);
        matrix1.printMatrix();
        matrix1.checkingMatrixType();
        matrix1.getAnySizeMatrix(2, 2);
    }
}
