import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/14 5:10 下午
 * @Version 1.0
 */
public class M46Permutations {
    public static void main(String[] args) {
        M46Permutations o = new M46Permutations();
        System.out.println(o.permuteStay(new int[]{2, 2, 1, 1}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return permuteSimple(list);
    }

    private List<List<Integer>> permuteSimple(List<Integer> numList) {
        List<List<Integer>> res = new ArrayList<>();
        if (numList.size() == 1) {
            res.add(numList);
            return res;
        }
        for (int i = 0; i < numList.size(); i++) {
            List<Integer> tmp = new ArrayList<>(numList);
            tmp.remove(i);
            List<List<Integer>> resList = permuteSimple(tmp);
            for (List<Integer> item : resList) {
                item.add(numList.get(i));
                res.add(item);
            }
        }
        return res;
    }

    public List<List<Integer>> permuteStay(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permuteSimple(ans, nums, 0);
        return ans;
    }

    private void permuteSimple(List<List<Integer>> ans, int[] nums, int start) {
        if (start == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            ans.add(list);
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i != start && nums[i] == nums[start]) {
                    continue;
                }
                swap(nums, start, i);
                permuteSimple(ans, nums, start + 1);
                swap(nums, start, i);
            }
        }

    }

    private void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
}
