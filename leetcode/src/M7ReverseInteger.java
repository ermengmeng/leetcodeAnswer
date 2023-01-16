/**
 * @Author: ouyangyameng
 * @Date: 2022/2/23 10:06 上午
 * @Version 1.0
 */
public class M7ReverseInteger {
    public static void main(String[] args) {
        System.out.println(new M7ReverseInteger().reverse(-123));
    }

    public int reverse(int x) {
        boolean isPositive = x >= 0;
        long xLong = Math.abs(x);
        String s = Long.toString(xLong);
        long res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int c = s.charAt(i) - '0';
            res = res * 10 + c;
        }
        if (!isPositive) {
            res = -res;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            res = 0;
        }
        return (int) res;
    }

    public int reverse2(int x) {
        if (x == 0)
            return 0;
        boolean b = false;
        int t = x;
        long temp = 0;
        if (x < 0) {
            b = true;
            t = -x;
        }
        while (t > 0) {
            if (t % 10 >= 0) {
                temp = temp * 10 + t % 10;
            }
            t /= 10;
        }
        return temp > Integer.MAX_VALUE ? 0 : (b ? (int) -temp : (int) (temp));
    }
}
