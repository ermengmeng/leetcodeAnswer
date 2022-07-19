import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/7/19 09:52
 * @Version 1.0
 */
public class M204CountPrimes {
    public static void main(String[] args) {
        System.out.println(new M204CountPrimes().countPrimes(10));
    }

    /**
     * 通过构造boolean数组从小到大将非素数排除。
     * 其中用到 i*i作为判断。
     * 因为如果i*i > 0。那么有关于i的合数判断,化解在更小的素数乘积里。
     * eg.i=11,n=111；
     * 那么小于11*11的判断
     * 合并在2*11,3*11,2*22……只有平方数<n的整数需要进行判断。
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i] == false) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
