import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2021/8/2 12:19 下午
 * @Version 1.0
 */
public class NextPermutation31 {
    public static void main(String[] args) {
        NextPermutation31 o = new NextPermutation31();
        o.nextPermutation(new int[]{1, 2, 3});
    }

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        while (i > 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (nums[i] < nums[i + 1]) {
            int site = i + 1;
            int min = nums[i + 1];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i] && nums[j] < min) {
                    min = nums[j];
                    site = j;
                }
            }
            nums[site] = nums[i];
            nums[i] = min;
            Arrays.sort(nums, i + 1, nums.length);
        } else {
            Arrays.sort(nums);
        }
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation2(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        //找到解空间位置,最后一个字典序i=-1;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i>=0) {
            int j = nums.length -1;
            while (nums[j]<=nums[i]) {
                j--;
            }
            //由于i后面是一个递减数组,从后找出第一个比nums[i]大的既是最小值。交换后依然是一个递减数组
            swap(nums, i, j);
        }
        //如果i>=0则翻转i后面的递减数组变为字典序第一个，如果i=-1则全翻转
        reverse(nums, i+1, nums.length-1);
    }

    private void swap(int[] nums, int i , int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int [] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++,j--);
        }
    }


}
