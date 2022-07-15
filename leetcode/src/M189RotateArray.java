/**
 * @Author: ouyangyameng
 * @Date: 2022/7/15 15:03
 * @Version 1.0
 */
public class M189RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length);
        reverse(nums, 0, k);
        reverse(nums, k, nums.length);
    }


    private void reverse(int[] nums, int start, int end) {
        int s = start;
        int e = end - 1;
        while (s < e) {
            swap(nums, s++, e--);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
