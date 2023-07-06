/**
 * @Author: ouyangyameng
 * @Date: 2023/7/5 09:36
 * @Version 1.0
 */
public class M33SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start =0;
        int end = nums.length-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //循环节在右侧
            if (nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid-1;
                } else {
                    start = mid +1;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;

                } else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}
