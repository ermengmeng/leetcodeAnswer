/**
 * @Author: ouyangyameng
 * @Date: 2023/4/25 16:35
 * @Version 1.0
 */
public class M306AdditiveNumber {
    public static void main(String[] args) {
        System.out.println(new M306AdditiveNumber().isAdditiveNumber("1023"));
    }
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= num.length() / 2; i++) {
            if (isAdditiveNumber(num, num.substring(num.length() - i), num.length() - i)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAdditiveNumber(String num, String sum, int len) {
        if (sum.charAt(0) == '0' && !"0".equals(sum)) {
            return false;
        }
        int s = Integer.valueOf(sum);
        for (int l = sum.length(); l > 0; l--) {
            String n = num.substring(len - l, len);
            if (n.charAt(0) == '0' && !"0".equals(n)) {
                continue;
            }
            int i = Integer.valueOf(n);
            if (i <= s) {
                int a = s - i;
                int start = len - l - String.valueOf(a).length();
                if (start >= 0 && num.substring(start, len - l).equals(String.valueOf(a))) {
                    if (start == 0) {
                        return true;
                    }
                    if (isAdditiveNumber(num, n, len - l)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
