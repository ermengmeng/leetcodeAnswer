import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ouyangyameng
 * @Date: 2021/4/16 6:53 下午
 * @Version 1.0
 */
public class MaximumNumberofNonOverlappingSubarraysWithSumEqualsTarget1546 {
    public static void main(String[] args) {
        MaximumNumberofNonOverlappingSubarraysWithSumEqualsTarget1546 o = new MaximumNumberofNonOverlappingSubarraysWithSumEqualsTarget1546();
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
