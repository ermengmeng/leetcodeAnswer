import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: ouyangyameng
 * @Date: 2023/1/13 10:08
 * @Version 1.0
 */
public class M15ThreeSum {
    public static void main(String[] args) {
        System.out.println(new M15ThreeSum().threeSum(new int[]{0,0,0}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer, List<Integer>> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!cache.containsKey(nums[i])) {
                cache.put(nums[i], new ArrayList<>());
            }
            cache.get(nums[i]).add(i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (i >= 1 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                if (hasResult(cache, nums, i, j)) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[j]);
                    item.add((-(nums[i] + nums[j])));
                    res.add(item);
                }
            }
        }
        return res;
    }

    private boolean hasResult(Map<Integer, List<Integer>> cache, int[] nums, int n1, int n2) {
        int num3 = -(nums[n1] + nums[n2]);
        if (num3 < nums[n1] || num3 < nums[n2]) {
            return false;
        }
        if (cache.get(num3) == null) {
            return false;
        }
        return cache.get(num3).stream().anyMatch(n -> !n.equals(n1) && !n.equals(n2));
    }
}
