/**
 * @Author: ouyangyameng
 * @Date: 2021/5/20 2:33 下午
 * @Version 1.0
 */
public class M413ArithmeticSlices {
    public static void main(String[] args) {
        M413ArithmeticSlices o = new M413ArithmeticSlices();
    }

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int curNum = 2;
        int sum = 0;
        int Dvalue = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == Dvalue) {
                curNum++;
                if (curNum >= 3) {
                    sum += curNum - 2;
                }
            } else {
                Dvalue = nums[i] - nums[i - 1];
                curNum = 2;
            }
        }
        return sum;
    }
}
