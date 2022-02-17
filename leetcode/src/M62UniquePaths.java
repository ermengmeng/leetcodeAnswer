import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/17 5:25 下午
 * @Version 1.0
 */
public class M62UniquePaths {
    public static void main(String[] args) {
        System.out.println(new M62UniquePaths().uniquePaths(2,3));
    }

    public int uniquePaths(int m, int n) {
        int[] t = new int[n];
        Arrays.fill(t, 1);
        for (int i = 0; i < m -1; i++) {
            for (int j = 1; j < n; j++) {
                t[j] = t[j - 1] + t[j];
            }
        }
        return t[n - 1];
    }
}
