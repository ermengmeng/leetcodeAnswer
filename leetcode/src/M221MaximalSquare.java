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


    //自左上角向右下角判断填写临时表。
    //临时表i,j的值为以i,j为右下角的正方形的最大边长
    //而i+1,j+1的最大边长为i,j的最大边长+1
    //通过从i+1,j+1的点逐步判断该行列的值可以得到最大的边长。
    //并Max记录过程中出现的最大值即可
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
