import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/16 3:03 下午
 * @Version 1.0
 */
public class M48RotateImage {
    public static void main(String[] args) {
        M48RotateImage o = new M48RotateImage();
        int[][] matrix = new int[][]{new int[]{5, 1, 9, 11}, new int[]{2, 4, 8, 10}, new int[]{13, 3, 6, 7}, new int[]{15, 14, 12, 16}};
        Arrays.stream(matrix).forEach(array -> System.out.println(Arrays.toString(array)));
        o.rotate(matrix);
        Arrays.stream(matrix).forEach(array -> System.out.println(Arrays.toString(array)));

    }

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            rotate(matrix, i);
        }
    }

    private void rotate(int[][] matrix, int n) {
        for (int k = 0; k < matrix.length - 2 * n - 1; k++) {
            int i = n;
            int j = n + k;
            int t = matrix[i][j];
            for (int m = 0; m < 4; m++) {
                int tt = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = t;
                t = tt;
                int ttt = i;
                i = j;
                j = matrix.length - 1 - ttt;
            }
        }
    }


    //rotate = 对称+翻转
    //[1,2,3]   [1,4,7]   [7,4,1]
    //[4,5,6] ->[2,5,8] ->[8,5,2]
    //[7,8,9]   [3,6,9]   [9,6,3]
    //代码略
}
