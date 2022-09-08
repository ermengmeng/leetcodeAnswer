/**
 * @Author: ouyangyameng
 * @Date: 2022/9/8 17:02
 * @Version 1.0
 */
public class M215KthLargestElementInAnArray {
    //有界的第k大数使用基数排序。
    //如果界很大可以分段
    public int findKthLargest(int[] nums, int k) {
        if (nums.length < k) {
            return -1;
        }
        int[] base = new int[20001];
        for (int num : nums) {
            base[num + 10000]++;
        }
        int sum = 0;
        for (int i = 20000; i >= 0; i--) {
            if (sum < k) {
                sum += base[i];
            }
            if (sum >= k) {
                return i - 10000;
            }
        }
        return -1;
    }
}
