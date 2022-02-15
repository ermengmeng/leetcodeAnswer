import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/15 5:44 下午
 * @Version 1.0
 */
public class M78Subsets {
    public static void main(String[] args) {
        M78Subsets o = new M78Subsets();
        System.out.println(o.subsets(new int[] {1,2,3}));
    }

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> cur = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        subsets(nums, 0);
        return ans;
    }

    public void subsets(int[] nums, int index) {
        ans.add(new ArrayList<>(cur));
        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            subsets(nums, i+1);
            cur.removeLast();
        }
    }
}
