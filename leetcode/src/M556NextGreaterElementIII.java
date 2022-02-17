import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2021/4/22 1:59 下午
 * @Version 1.0
 */
public class M556NextGreaterElementIII {
    public static void main(String[] args) {
        M556NextGreaterElementIII o = new M556NextGreaterElementIII();
        System.out.println(o.nextGreaterElement(21));
    }

    public int nextGreaterElement(int n) {
        int i = 10;
        int num = n / 10;
        List<Integer> pre = new ArrayList<>();
        pre.add(n % 10);
        while (num > 0) {
            int cur = num % 10;
            i *= 10;
            num /= 10;
            int last = pre.get(pre.size() - 1);
            pre.add(cur);
            if (cur < last) {
                Collections.sort(pre);
                int k = 1;
                num *= i;
                for (int j = 0; j < pre.size(); j++) {
                    if (pre.get(j) > cur) {
                        num += pre.get(j) * i / 10;
                        pre.remove(j);
                        if (num < 0) {
                            return -1;
                        }
                        break;
                    }
                }
                for (int j = pre.size() - 1; j >= 0; j--) {
                    num += pre.get(j) * k;
                    k *= 10;
                    if (num < 0) {
                        return -1;
                    }
                }
                return num;
            }
        }
        return -1;
    }
}
