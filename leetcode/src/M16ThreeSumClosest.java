import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2023/1/16 10:22
 * @Version 1.0
 */
public class M16ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                if (Math.abs(result - target) - Math.abs(temp - target) > 0) {
                    result = temp;
                }
                if (temp == target) {
                    return result;
                }
                if (temp > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}
