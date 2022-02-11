import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/11 2:19 下午
 * @Version 1.0
 */
public class M34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        M34FindFirstAndLastPositionOfElementInSortedArray o = new M34FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(o.searchRange(new int[]{2,2}, 2)));
    }

    /**
     * 要求O(logn)使用两次二分法 分别找到最小的位置和最大的位置。注意由于mid是下取整,因此在找最大位置时需要额外的位置判断。
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int min = findMin(nums, target, 0, nums.length - 1);
        if (min >= 0) {
            int max = findMax(nums, target, 0, nums.length - 1);
            return new int[]{min, max};
        } else {
            return new int[]{min, min};
        }
    }

    private int findMin(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (start == end && nums[start] == target) {
            return start;
        }
        if (start == end && nums[start] != target) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return findMin(nums, target, start, mid);
        } else {
            if (nums[mid] > target) {
                return findMin(nums, target, start, mid - 1);
            } else {
                return findMin(nums, target, mid + 1, end);
            }
        }
    }

    private int findMax(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (start == end && nums[start] == target) {
            return start;
        }
        if (start == end && nums[start] != target) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            if (nums[mid + 1] == target) {
                return findMax(nums, target, mid + 1, end);
            } else {
                return mid;
            }
        } else {
            if (nums[mid] > target) {
                return findMax(nums, target, start, mid - 1);
            } else {
                return findMax(nums, target, mid + 1, end);
            }
        }
    }
}
