/**
 * @Author: ouyangyameng
 * @Date: 2022/6/21 12:36
 * @Version 1.0
 */
public class M137SingleNumber2 {
    public static void main(String[] args) {
        System.out.println(new M137SingleNumber2().singleNumber(new int[]{1, 1, 1, 2}));
    }

    public int singleNumber(int[] nums) {
        int base = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                if ((num >> i & 1) == 1) {
                    sum = (sum + 1) % 3;
                }
            }
            base += sum << i;
        }
        return base;
    }
}
