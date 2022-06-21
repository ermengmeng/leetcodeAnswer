/**
 * @Author: ouyangyameng
 * @Date: 2022/6/21 12:36
 * @Version 1.0
 */
public class M137SingleNumber2 {
    public static void main(String[] args) {
        System.out.println(new M137SingleNumber2().singleNumber(new int[]{1,1,1,2}));
    }

    public int singleNumber(int[] nums) {
        int[] bitNum = new int[32];
        int[] pow = new int[32];
        int base = 1;
        for (int i = 0; i < 32; i++) {
            pow[i] = base;
            base = base << 1;
        }
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & pow[i]) != 0) {
                    bitNum[i] = (bitNum[i] + 1) % 3;
                }
            }
        }
        base = 0;
        for (int i = 31; i >= 0 ; i--) {
            base = base << 1;
            base = (base | bitNum[i]);
        }
        return base;
    }
}
