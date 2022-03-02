import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/25 7:05 下午
 * @Version 1.0
 */
public class M81SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        System.out.println(new M81SearchInRotatedSortedArrayII().search(new int[]{1}, 1));
    }

    //s + (e - s) / 2防止溢出
    //转化为找到循环节,并化为两段二分查找
    public boolean search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int rotate = findRotate(nums);
        if (rotate == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        } else if (nums[e] >= target) {
            return binarySearch(nums, rotate, e, target);
        } else {
            return binarySearch(nums, 0, rotate - 1, target);
        }
    }

    public boolean binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }
        return false;
    }

    private int findRotate(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        if (nums[e] > nums[0]) {
            return -1;
        }
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] > nums[e]) {
                if (nums[mid+1] < nums[mid]) {
                    return mid + 1;
                } else {
                    s = mid + 1;
                }
            } else if (nums[s] > nums[mid]) {
                if (nums[mid - 1] > nums[mid]) {
                    return mid;
                } else {
                    e = mid - 1;
                }
            } else if (nums[mid] == nums[s] && nums[mid] == nums[e]) {
                if (s < e && nums[s+1] < nums[s]) {
                    return s + 1;
                }
                s++;
                if (s < e && nums[e - 1] > nums[e]) {
                    return e;
                }
                e--;
            }
        }
        return -1;
    }
}
