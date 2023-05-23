/**
 * @Author: ouyangyameng
 * @Date: 2023/4/25 16:12
 * @Version 1.0
 */
public class M304RangeSumQuery2DImmutable {

    public static void main(String[] args) {
       NumMatrix nm = new NumMatrix(new int[][]{new int[]{3,0,1,4,2},new int[]{5,6,3,2,1},new int[]{1,2,0,1,5},new int[]{4,1,0,1,7},new int[]{1,0,3,0,5}});
       System.out.println(nm.sumRegion(2,1,4,3));
    }
    static class NumMatrix {
        int[][] m;

        public NumMatrix(int[][] matrix) {
            this.m = matrix;
            computeSum(m);
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 > 0 && col1 > 0) {
                return m[row2][col2] + m[row1-1][col1-1] - m[row1-1][col2] - m[row2][col1-1];
            }
            if (row1 > 0) {
                return m[row2][col2] - m[row1 - 1][col2];
            }
            if (col1 > 0) {
                return m[row2][col2] - m[row2][col1 - 1];
            }
            return m[row2][col2];

        }

        private void computeSum(int[][] m) {
            for (int i = 1; i < m.length; i++) {
                m[i][0] = m[i][0] + m[i - 1][0];
            }
            for (int i = 1; i < m[0].length; i++) {
                m[0][i] = m[0][i] + m[0][i - 1];
            }
            for (int i = 1; i < m.length; i++) {
                for (int j = 1; j < m[0].length; j++) {
                    m[i][j] = m[i][j] + m[i][j - 1] + m[i - 1][j] - m[i - 1][j - 1];
                }
            }
        }
    }
}
