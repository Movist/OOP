import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {


    @Test
    void testIsSquare() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int[][] mtr = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Matrix matrix = new Matrix(mtr);
        Method method = Matrix.class.getDeclaredMethod("isSquare");
        method.setAccessible(true);
        assertEquals(method.invoke(matrix), Boolean.TRUE);
    }

    @Test
    void testIsDiagonal() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int[][] mtr = new int[][]{
                {4, 0, 0},
                {0, 5, 0},
                {0, 0, 0}
        };
        Matrix matrix = new Matrix(mtr);
        Method method = Matrix.class.getDeclaredMethod("isDiagonal");
        method.setAccessible(true);
        assertEquals(method.invoke(matrix), Boolean.TRUE);
    }

    @Test
    void testIsZero() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int[][] mtr = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        Matrix matrix = new Matrix(mtr);
        Method method = Matrix.class.getDeclaredMethod("isZero");
        method.setAccessible(true);
        assertEquals(method.invoke(matrix), Boolean.TRUE);
    }

    @Test
    void testIsUnit() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int[][] mtr = new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        Matrix matrix = new Matrix(mtr);
        Method method = Matrix.class.getDeclaredMethod("isUnit");
        method.setAccessible(true);
        assertEquals(method.invoke(matrix), Boolean.TRUE);
    }

    @Test
    void testE() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int[][] mtr = new int[][]{
                {1, 2, 3},
                {4, 1, 6},
                {7, 8, 1}
        };
        Matrix matrix = new Matrix(mtr);
        Method method = Matrix.class.getDeclaredMethod("E");
        method.setAccessible(true);
        assertEquals(method.invoke(matrix), Boolean.TRUE);
    }

    @Test
    void testIsSymmetric() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int[][] mtr = new int[][]{
                {9, 3, 0},
                {3, 9, 6},
                {0, 6, 9}
        };
        Matrix matrix = new Matrix(mtr);
        Method method = Matrix.class.getDeclaredMethod("isSymmetric");
        method.setAccessible(true);
        assertEquals(method.invoke(matrix), Boolean.TRUE);
    }

    @Test
    void testIsUpperTriangular() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int[][] mtr = new int[][]{
                {1, 2, 3},
                {0, 5, 6},
                {0, 0, 9}
        };
        Matrix matrix = new Matrix(mtr);
        Method method = Matrix.class.getDeclaredMethod("isUpperTriangular");
        method.setAccessible(true);
        assertEquals(method.invoke(matrix), Boolean.TRUE);
    }

    @Test
    void testIsLowerTriangular() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int[][] mtr = new int[][]{
                {1, 0, 0},
                {4, 5, 0},
                {7, 8, 9}
        };
        Matrix matrix = new Matrix(mtr);
        Method method = Matrix.class.getDeclaredMethod("isLowerTriangular");
        method.setAccessible(true);
        assertEquals(method.invoke(matrix), Boolean.TRUE);
    }

    @Test
    void testGetAnySizeMatrix() {
    }
}