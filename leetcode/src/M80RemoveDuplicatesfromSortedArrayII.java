/**
 * @Author: ouyangyameng
 * @Date: 2022/2/25 6:57 下午
 * @Version 1.0
 */
public class M80RemoveDuplicatesfromSortedArrayII {
    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        int cur = 1;
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num && count < 2) {
                nums[cur++] = nums[i];
                count++;
            } else if (nums[i] != num){
                nums[cur++] = nums[i];
                num = nums[i];
                count = 1;
            }
        }
        return cur;
    }
}
