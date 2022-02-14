/**
 * @Author: ouyangyameng
 * @Date: 2022/2/14 4:42 下午
 * @Version 1.0
 */
public class M45JumpGame2 {
    public static void main(String[] args) {
        M45JumpGame2 o = new M45JumpGame2();
        System.out.println(o.jump(new int[]{2, 3, 0, 0, 1, 4}));
    }

    public int jump(int[] nums) {
        int[] res = new int[nums.length];
        res[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int step = nums[i];
            int min = Integer.MAX_VALUE - 1;
            for (int j = i + 1; j <= i + step && j < nums.length; j++) {
                min = Math.min(min, res[j] + 1);
            }
            res[i] = min;
        }
        return res[0];
    }
}
