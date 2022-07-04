/**
 * @Author: ouyangyameng
 * @Date: 2022/7/4 10:24
 * @Version 1.0
 */
public class M162FindPeakElement {
    public int findPeakElement(int[] nums) {
        boolean greater = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (greater && nums[i] > nums[i + 1]) {
                return i;
            } else {
                greater = nums[i] < nums[i + 1];
            }
        }
        return greater ? nums.length - 1 : -1;
    }
}
