/**
 * @Author: ouyangyameng
 * @Date: 2023/1/18 17:33
 * @Version 1.0
 */
public class M53MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(new M53MaximumSubarray().maxSubArray(new int[]{1, -1, 1}));
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int cache = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = (cache > 0 ? cache : 0) + nums[i];
            max = Math.max(max, cur);
            cache = cur;
        }
        return max;
    }
}
