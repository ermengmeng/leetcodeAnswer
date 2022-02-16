/**
 * @Author: ouyangyameng
 * @Date: 2022/2/16 4:38 下午
 * @Version 1.0
 */
public class M50Powxn {
    public static void main(String[] args) {
        M50Powxn o = new M50Powxn();


        System.out.println(o.myPow(2.00000, -2147483648));
    }



    public double myPow(double x, int n) {
        double res = 1;
        boolean isPositive = true;
        long longn = n;
        if (longn < 0) {
            isPositive = false;
            longn = -longn;
        }
        long[] base = new long[33];
        double[] phase = new double[33];
        phase[0] = x;
        base[0] = 1;
        int i = 0;
        while (base[i] <= longn) {
            i++;
            base[i] = base[i - 1] * 2;
            phase[i] = phase[i - 1] * phase[i - 1];
        }
        while (i > 0) {
            i--;
            if (longn >= base[i]) {
                longn -= base[i];
                res *= phase[i];
            }
        }
        return isPositive ? res : 1 / res;
    }
}
