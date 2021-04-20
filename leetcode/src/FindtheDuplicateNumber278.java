/**
 * @Author: ouyangyameng
 * @Date: 2021/4/20 1:43 下午
 * @Version 1.0
 */
public class FindtheDuplicateNumber278 {
    public static void main(String[] args) {
        FindtheDuplicateNumber278 o = new FindtheDuplicateNumber278();
        o.findDuplicate(new int[]{});
    }

    public int findDuplicate(int[] nums) {
        int[] t = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (t[nums[i]]++ > 0) {
                return nums[i];
            }
        }
        return 0;
    }
}
