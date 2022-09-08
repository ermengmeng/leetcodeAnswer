import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/9/8 17:31
 * @Version 1.0
 */
public class M216CombinationSum3 {
    public static void main(String[] args) {
        System.out.println(new M216CombinationSum3().combinationSum3(3, 45));
    }

    /**
     * 简单回溯
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        compute(res, new LinkedList<>(), 0, 1, 0, k, n);
        return res;
    }

    private void compute(List<List<Integer>> res, LinkedList<Integer> cur, int index, int range, int sum, int k, int n) {
        if (sum >= n) {
            return;
        }
        if (index == k - 1) {
            if (n - sum <= 9 && n - sum >= range) {
                cur.add(n - sum);
                res.add(new ArrayList<>(cur));
                cur.removeLast();
            }
            return;
        }
        for (int i = range; i <= 9 - k + index + 1; i++) {
            cur.add(i);
            compute(res, cur, index + 1, i + 1, sum + i, k, n);
            cur.removeLast();
        }
    }
}
