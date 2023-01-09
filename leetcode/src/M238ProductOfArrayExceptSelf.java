import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2023/1/6 14:10
 * @Version 1.0
 */
public class M238ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int pre = 1;
        int post = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] *= pre;
            pre *= nums[i];
            result[nums.length - i - 1] *= post;
            post *= nums[nums.length - i - 1];
        }
        return result;
    }
}
