/**
 * @Author: ouyangyameng
 * @Date: 2022/9/8 16:30
 * @Version 1.0
 */
public class M213HouseRobber2 {
    public static void main(String[] args) {
        System.out.println(new M213HouseRobber2().rob(new int[]{1,2,3}));
    }

    public int rob(int[] nums) {
        int[] withEnd = new int[nums.length];
        int[] noEnd = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //without0;
        withEnd[1] = nums[1];
        noEnd[2] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            withEnd[i] = Math.max(withEnd[i - 2], noEnd[i - 1]) + nums[i];
            noEnd[i] = Math.max(withEnd[i - 1], noEnd[i - 1]);
        }
        int max0 = Math.max(withEnd[nums.length - 1], noEnd[nums.length - 1]);
        //with0
        withEnd[0] = nums[0];
        withEnd[1] = nums[0];
        noEnd[1] = nums[0];
        for (int i = 2; i < nums.length - 1; i++) {
            withEnd[i] = Math.max(withEnd[i - 2], noEnd[i - 1]) + nums[i];
            noEnd[i] = Math.max(withEnd[i - 1], noEnd[i - 1]);
        }
        int max1 = Math.max(withEnd[nums.length - 2], noEnd[nums.length - 2]);
        return Math.max(max0, max1);
    }
}
