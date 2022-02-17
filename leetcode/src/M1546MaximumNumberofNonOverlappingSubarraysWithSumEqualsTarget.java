import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ouyangyameng
 * @Date: 2021/4/16 6:53 下午
 * @Version 1.0
 */
public class M1546MaximumNumberofNonOverlappingSubarraysWithSumEqualsTarget {
    public static void main(String[] args) {
        M1546MaximumNumberofNonOverlappingSubarraysWithSumEqualsTarget o = new M1546MaximumNumberofNonOverlappingSubarraysWithSumEqualsTarget();
        System.out.print(o.maxNonOverlapping(new int[]{-1, 3, 5, 1, 4, 2, -9}, 6));
    }

    public int maxNonOverlapping(int[] nums, int target) {
        int sum = 0;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            sum += num;
            if(set.contains(sum - target) || sum == target) {
                count++;
                set = new HashSet<>();
                sum = 0;
            } else {
                set.add(sum);
            }
        }
        return count;
    }
}
