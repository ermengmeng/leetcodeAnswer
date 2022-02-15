import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/15 5:12 下午
 * @Version 1.0
 */
public class M77Combinations {
    public static void main(String[] args) {
        M77Combinations o = new M77Combinations();
        System.out.println(o.combine(4,2));
    }

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> cur = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        combineSimple(n, 1, k);
        return ans;
    }

    public void combineSimple(int n, int index, int k) {
        if (cur.size() == k) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i <= n - (k - cur.size()) + 1; i++) {
            cur.add(i);
            combineSimple(n, i + 1, k);
            cur.removeLast();
        }
    }
}
