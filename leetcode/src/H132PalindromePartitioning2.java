import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/20 11:52
 * @Version 1.0
 */
public class H132PalindromePartitioning2 {
    public static void main(String[] args) {
        System.out.println(new H132PalindromePartitioning2().minCut("aab"));
    }

    /**
     * 关于回文数的题核心在于遍历单中心和双中心点
     * 并根据提议找到最优解(一般动归)，或所有组合（一般DFS）
     * @param s
     * @return
     */
    public int minCut(String s) {
        char[] charArray = s.toCharArray();
        int[] minPalindromeArray = new int[s.length() + 1];
        Arrays.fill(minPalindromeArray, Integer.MAX_VALUE);
        minPalindromeArray[0] = 0;
        for (int i = 0; i < charArray.length; i++) {
            minPalindromeArray[i + 1] = Math.min(minPalindromeArray[i] + 1, minPalindromeArray[i + 1]);
            int j = 1;
            while (i - j >= 0 && i + j < charArray.length && charArray[i - j] == charArray[i + j]) {
                minPalindromeArray[i + j + 1] = Math.min(minPalindromeArray[i - j] + 1, minPalindromeArray[i + j + 1]);
                j++;
            }
            if (i + 1 < charArray.length && charArray[i] == charArray[i + 1]) {
                minPalindromeArray[i + 2] = Math.min(minPalindromeArray[i] + 1, minPalindromeArray[i + 2]);
                j = 1;
                while (i - j >= 0 && i + (j + 1) < charArray.length && charArray[i - j] == charArray[i + (j + 1)]) {
                    minPalindromeArray[i + j + 2] = Math.min(minPalindromeArray[i - j] + 1, minPalindromeArray[i + j + 2]);
                    j++;
                }
            }
        }
        return minPalindromeArray[s.length()] - 1;
    }
}
