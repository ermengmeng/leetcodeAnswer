/**
 * @Author: ouyangyameng
 * @Date: 2022/6/30 10:32
 * @Version 1.0
 */
public class M152MaximumProductSubarray {
    public static void main(String[] args) {
        System.out.println(new M152MaximumProductSubarray().maxProduct(new int[]{0}));
    }


    /**
     * 理解题意,由于不存在小数,因此影响乘积可能变小的因素只有 0和负数.
     * 子数组一旦包含0则任何乘积为0，因此,大于0的子数组乘积只可能在由0分隔的子数组中。
     * 由0分隔的子数组不包含0,因此如果有0个或偶数个负数，则完整的乘积最大。
     * 若负数个数为奇数,则最大的正数组乘积为Math.max(完整乘积/第一个负数乘积，完整乘积/最后一个负数乘积)
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int start = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(0, max);
                max = Math.max(max, computeMaxProduct(nums, start, i));
                start = i + 1;
            }
        }
        if (start < nums.length) {
            max = Math.max(max, computeMaxProduct(nums, start, nums.length));
        }
        return max;
    }

    private int computeMaxProduct(int[] nums, int start, int end) {
        if (start >= end - 1) {
            return nums[start];
        }
        int first = 0;
        int last = 0;
        int cur = 1;
        for (int i = start; i < end; i++) {
            if (nums[i] < 0) {
                cur *= nums[i];
                if (first == 0) {
                    first = cur;
                }
                last = nums[i];
            } else {
                cur *= nums[i];
                last *= nums[i];
            }
        }
        if (cur > 0) {
            return cur;
        } else {
            return Math.max(cur / first , cur / last);
        }
    }
}
