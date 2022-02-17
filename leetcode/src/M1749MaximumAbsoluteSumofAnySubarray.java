/**
 * @Author: ouyangyameng
 * @Date: 2021/5/19 2:03 下午
 * @Version 1.0
 */
public class M1749MaximumAbsoluteSumofAnySubarray {
    public static void main(String[] args) {
        M1749MaximumAbsoluteSumofAnySubarray o = new M1749MaximumAbsoluteSumofAnySubarray();
        System.out.println();
    }

    public int maxAbsoluteSum(int[] nums) {
        int negativeCache = 0;
        int positiveCache = 0;
        int max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            negativeCache = nums[i] + negativeCache < 0 ? nums[i] + negativeCache : 0;
            positiveCache = nums[i] + positiveCache > 0 ? nums[i] + positiveCache : 0;
            max = Math.max(max, -negativeCache);
            max = Math.max(max, positiveCache);
        }
        return max;
    }
}
