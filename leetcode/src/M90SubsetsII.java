import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/28 9:53 上午
 * @Version 1.0
 */
public class M90SubsetsII {
    public static void main(String[] args) {
        System.out.println(new M90SubsetsII().subsetsWithDup(new int[]{1,1,2,2}));
    }

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> cur = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] isVisited = new boolean[nums.length];
        subsetsWithDup(nums, 0, isVisited);
        return ans;
    }

    /**
     * 重复的解来自于相同的前缀在单独选完前一个 又单独选后一个
     * eg。如果nums = [1,1,2,2,2,3,4,5]
     * 在[1,1]解时,会陆续经历[1,1,2][1,1,2,2][1,1,2,2,2]的递归
     * 所以有1个2，2个2，3个2的遍历均由递归层完成
     * 在递归返回[1,1]解时,index+1跳过第一个2,则选择第2和第3个2的解集均为之前出现过的解。则直接剪枝、
     * M47全排列的去重剪枝也是同理
     * @param nums
     * @param index
     * @param isVisited
     */
    public void subsetsWithDup(int[] nums, int index, boolean[] isVisited) {
        ans.add(new ArrayList<>(cur));
        for (int i = index; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !isVisited[i - 1]) {
                continue;
            }
            cur.add(nums[i]);
            isVisited[i] = true;
            subsetsWithDup(nums, i + 1, isVisited);
            cur.removeLast();
            isVisited[i] = false;
        }
    }
}
