/**
 * @Author: ouyangyameng
 * @Date: 2022/7/15 16:41
 * @Version 1.0
 */
public class M198HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] noEnd = new int[nums.length];
        int[] withEnd = new int[nums.length];
        withEnd[0] = nums[0];
        withEnd[1] = nums[1];
        noEnd[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            noEnd[i] = Math.max(withEnd[i - 1], noEnd[i - 1]);
            withEnd[i] = Math.max(withEnd[i - 2] + nums[i], noEnd[i - 1] + nums[i]);
        }
        return Math.max(withEnd[nums.length - 1], noEnd[nums.length - 1]);
    }
}
