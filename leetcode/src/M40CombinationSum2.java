import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/11 3:55 下午
 * @Version 1.0
 */
public class M40CombinationSum2 {
    public static void main(String[] args) {
        M40CombinationSum2 o = new M40CombinationSum2();
        System.out.println(o.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        compute(candidates, target, new LinkedList<>(), ans, 0);
        return ans;
    }

    private void compute(int[] candidates, int target, LinkedList<Integer> cur, List<List<Integer>> ans, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            cur.add(candidates[i]);
            compute(candidates, target - candidates[i], cur, ans, i + 1);
            cur.removeLast();
        }
    }
}
