import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/24 6:26 下午
 * @Version 1.0
 */
public class M73SetMatrixZeroes {
    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        Boolean rowZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if (i > 0) {
                        matrix[i][0] = 0;
                    } else {
                        rowZero = true;
                    }
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0)
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;

        if (rowZero)
            for (int j = 0; j < matrix[0].length; j++)
                matrix[0][j] = 0;
    }
}
