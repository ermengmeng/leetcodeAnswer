import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/15 4:00 下午
 * @Version 1.0
 */
public class M47Permutation2 {
    public static void main(String[] args) {
        M47Permutation2 o = new M47Permutation2();
        System.out.println(o.permuteUnique(new int[]{1,1,2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        Arrays.sort(nums);
        permute(nums, ans, new ArrayList<>(),0, isVisited);
        return ans;
    }

    public void permute(int[] nums, List<List<Integer>> ans, List<Integer> cur, int index, boolean[] isVisited) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && !isVisited[i-1] && nums[i] == nums[i-1]) {
                continue;
            }
            if (!isVisited[i]) {
                cur.add(nums[i]);
                isVisited[i] = true;
                permute(nums, ans, cur, index + 1, isVisited);
                cur.remove(cur.size()-1);
                isVisited[i] = false;
            }
        }
    }
}
