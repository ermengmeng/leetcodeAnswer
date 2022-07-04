/**
 * @Author: ouyangyameng
 * @Date: 2022/7/1 19:15
 * @Version 1.0
 */
public class M153FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new M153FindMinimumInRotatedSortedArray().findMin(new int[] {11,13,15,17}));
    }

    /**
     * 分开判断循环在头尾和在中部两种情况，
     * 在头尾直接判断
     * 在中部，利用单调性判断二分查找。
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length;
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }
        while (s < e) {
            int m = (s + (e - s) / 2);
            if (m > 0 && nums[m] < nums[m - 1]) {
                return nums[m];
            }
            if (nums[m] < nums[s]) {
                e = m;
            } else {
                s = m;
            }
        }
        return nums[s];
    }
}
