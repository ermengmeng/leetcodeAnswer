import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2023/1/9 19:16
 * @Version 1.0
 */
public class M260SingleNumber3 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,3,5};
        System.out.println(Arrays.toString(new M260SingleNumber3().singleNumber(nums)));
    }
    public int[] singleNumber(int[] nums) {
        int xor = Arrays.stream(nums).reduce((i1,i2) -> i1 ^ i2).getAsInt();
        int p = 0;
        int q = 0;
        for (int i : nums) {
            int mask = xor & -xor;
            if ((i & mask) == 0) {
                p^=i;
            } else {
                q^=i;
            }
        }
        return new int[]{p,q};
    }
}
