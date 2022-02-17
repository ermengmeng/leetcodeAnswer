import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/17 4:50 下午
 * @Version 1.0
 */
public class M59SpiralMatrix2 {
    public static void main(String[] args) {
        int[][] res = new M59SpiralMatrix2().generateMatrix(3);
        Arrays.stream(res).forEach(array -> System.out.println(Arrays.toString(array)));
    }

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int mode = 0;
        int j = 0;
        int k = 0;
        int cur = 1;
        ans[j][k] = cur++;

        while (cur <= n * n) {
            switch (mode) {
                case 1:
                    while (j < n - 1 && ans[j + 1][k] == 0) {
                        ans[++j][k] = cur++;
                    }
                    break;
                case 0:
                    while (k < n - 1 && ans[j][k + 1] == 0) {
                        ans[j][++k] = cur++;
                    }
                    break;
                case 3:
                    while (j > 0 && ans[j - 1][k] == 0) {
                        ans[--j][k] = cur++;
                    }
                    break;
                case 2:
                    while (k > 0 && ans[j][k - 1] == 0) {
                        ans[j][--k] = cur++;
                    }
                    break;
            }
            mode = (mode + 1) % 4;
        }
        return ans;
    }
}
