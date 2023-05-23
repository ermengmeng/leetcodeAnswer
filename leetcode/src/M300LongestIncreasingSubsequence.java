import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2023/4/25 15:48
 * @Version 1.0
 */
public class M300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(new M300LongestIncreasingSubsequence().lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }
    public int lengthOfLIS(int[] nums) {
        int[] max = new int[nums.length + 1];
        Arrays.fill(max, Integer.MAX_VALUE);
        max[0] = Integer.MIN_VALUE;
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i; j >= 0; j--) {
                if (max[j] < num) {
                    max[j + 1] = Math.min(num, max[j + 1]);
                    l = Math.max(l,j + 1);
                }
            }
        }
        return l;
    }
}
