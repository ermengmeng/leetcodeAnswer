import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/15 7:19 下午
 * @Version 1.0
 */
public class M89GrayCode {
    public static void main(String[] args) {
        M89GrayCode o = new M89GrayCode();
        System.out.println(o.grayCode(3));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        grayCode(0, n, ans, new boolean[n]);
        return ans;
    }

    public void grayCode(int k, int n, List<Integer> ans, boolean[] cur) {
        if (k == n) {
            int res = 0;
            int x = 1;
            for (int i = 0; i < cur.length; i++) {
                if (cur[i]) {
                    res += x;
                }
                x = x << 1;
            }
            ans.add(res);
            return;
        }
        grayCode(k + 1, n, ans, cur);
        cur[k] = !cur[k];
        grayCode(k + 1, n, ans, cur);
    }
}
