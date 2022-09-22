import java.util.Scanner;

public class Matrix {
    private int rows;
    private int cols;

    private final int[][] matrix;

    private enum TypeMatrix {unknownType, square, diagonal, zero, unit, symmetric, upperTriangular, lowerTriangular}

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public Matrix() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество строк матрицы: ");
        rows = sc.nextInt();
        System.out.println("Введите количество столбцов матрицы: ");
        cols = sc.nextInt();

        matrix = new int[rows][cols];
        System.out.println("Введите элементы матрицы: ");
        for (int i = 0; i < rows; i++) {
            System.out.println("Введите " + (cols) + " элемента(ов) строки " + (i + 1) + "(" + rows + ")");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    public Matrix(int[][] mtr) {
        matrix = mtr;
        this.rows = mtr.length;
        this.cols = mtr[0].length;
    }

    public void printMatrix() {
        System.out.println("Матрица: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void fillRandom() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) ((Math.random() * 9) + 1);
            }
        }
    }

    public void checkingMatrixType() {
        System.out.println("Тип матрицы:");
        TypeMatrix type = TypeMatrix.unknownType;
        if (isSquare()) {
            type = TypeMatrix.square;
            System.out.println(type + " matrix");
        }
        if (isDiagonal()) {
            type = TypeMatrix.diagonal;
            System.out.println(type + " matrix");
        }
        if (isZero()) {
            type = TypeMatrix.zero;
            System.out.println(type + " matrix");
        }
        if (isUnit()) {
            type = TypeMatrix.unit;
            System.out.println(type + " matrix");
        }
        if (isSymmetric()) {
            type = TypeMatrix.symmetric;
            System.out.println(type + " matrix");
        }
        if (isUpperTriangular()) {
            type = TypeMatrix.upperTriangular;
            System.out.println(type + " matrix");
        }
        if (isLowerTriangular()) {
            type = TypeMatrix.lowerTriangular;
            System.out.println(type + " matrix");
        }
        if (type == TypeMatrix.unknownType) {
            System.out.println(type + " matrix");
        }
    }

    private boolean isSquare() {
        return rows == cols;
    }

    private boolean isDiagonal() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i != j) {
                    if (matrix[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isZero() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }

            }
        }
        return true;
    }

    private boolean isUnit() {
        return E() && isDiagonal();
    }

    private boolean E() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == j) {
                    if (!(matrix[i][j] == 1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isSymmetric() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int similar = matrix[i][j];
                boolean temp = false;
                if (i < j) {
                    if ((matrix[i][j] == similar)) {
                        temp = true;
                    }
                }
                int temp2 = i;
                i = j;
                j = temp2;
                if (i > j) {
                    for (int k = 0; k < i; k++) {
                        if (!(matrix[i][j] == similar)) {
                            if (temp) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    //Верхней треугольной матрицей называется матрица, все элементы которой ниже главной диагонали равны нулю.
    private boolean isUpperTriangular() {
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == j) {
                    for (int k = 0; k < j; k++) {
                        if (!(matrix[i][k] == 0)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    //Нижней треугольной матрицей называется матрица, все элементы которой выше главной диагонали равны нулю.
    private boolean isLowerTriangular() {
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                if (!(matrix[i][j] == 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void getAnySizeMatrix(int rows, int cols) {
        if (rows <= this.rows || cols <= this.cols) {
            System.out.println("Полученная матрица размера " + rows + "x" + cols);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        } else System.out.println("Размеры подматрицы не могут быть выше, чем " + this.rows + "x" + this.cols + "!");
    }
}
