/**
 * @Author: ouyangyameng
 * @Date: 2021/5/31 4:57 下午
 * @Version 1.0
 */
public class M221MaximalSquare {
    public static void main(String[] args) {
        M221MaximalSquare o = new M221MaximalSquare();
        System.out.println(o.maximalSquare(new char[][]{new char[]{'1','0','1','1','0','1'}, new char[]{'1','1','1','1','1','1'},
                new char[]{'0','1','1','0','1','1'}, new char[]{'1','1','1','0','1','0'},new char[]{'0','1','1','1','1','1'},new char[]{'1','1','0','1','1','1'}}));
    }


    
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = matrix[i][j] - '0';
                } else {
                    cache[i][j] = squareSize(i , j, matrix[i][j] - '0', cache);
                }
                max = Math.max(max, cache[i][j]);
            }
        }
        return max * max;
    }

    private int squareSize(int i, int j, int cur, int[][] cache) {
        if (cur == 0) {
            return 0;
        }
        boolean isSquare = true;
        int size = cache[i - 1][j - 1];
        int curSize = 0;
        for (int k = 1; k <= size; k++) {
            isSquare &= cache[i][j - k] > 0;
            isSquare &= cache[i - k][j] > 0;
            if (isSquare) {
                curSize++;
            }
        }
        return curSize + cur;
    }
}
