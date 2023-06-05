import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2023/6/5 16:47
 * @Version 1.0
 */
public class M307RangeSumQueryMutable {
    int[] nums;
    int left = -1;
    int right = -1;
    int sum = 0;

    public M307RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        left = 0;
        right = nums.length - 1;
        sum = Arrays.stream(nums).sum();
    }

    public void update(int index, int val) {
        if (index <= right && index >= left) {
            sum += val - nums[index];
        }
        nums[index] = val;
    }

    /**
     * 每次计算range时从上次生成的sum中增量生成
     * @param left
     * @param right
     * @return
     */
    public int sumRange(int left, int right) {
        if (left < this.left) {
            for (int i = left; i < this.left; i++) {
                sum += nums[i];
            }
        } else if (left > this.left) {
            for (int i = this.left; i < left ; i++) {
                sum-=nums[i];
            }
        }

        if (right > this.right) {
            for (int i = this.right + 1; i <= right; i++) {
                sum += nums[i];
            }
        } else if (right < this.right) {
            for (int i = right + 1; i <= this.right; i++) {
                sum -= nums[i];
            }
        }
        this.left = left;
        this.right = right;
        return sum;
    }

    public static void main(String[] args) {
        M307RangeSumQueryMutable object = new M307RangeSumQueryMutable(new int[]{0,9,5,7,3});
        object.sumRange(4,4);
        object.sumRange(2,4);
        object.sumRange(3,3);

    }
}
