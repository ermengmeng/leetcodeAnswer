import java.util.*;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/15 13:34
 * @Version 1.0
 */
public class M128LongestConsecutiveSequence {
    /**
     * 计算最长的连续数字
     * 由于连续数字隐含了可以获得的pre和next
     * 所以可以判断出连续的头或尾
     * 再单调找寻即可
     * 由于不是头或者尾的数字都略过了。
     * 因此整体还是o(n)的复杂度
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        for (int i : nums) {
            set.add(i);
        }
        for (Integer i : set) {
            if (set.contains(i - 1)) {
                continue;
            }
            int cur = i;
            int curlong = 0;
            while (set.contains(cur)) {
                curlong++;
                cur++;
            }
            longest = Math.max(longest, curlong);
        }
        return longest;
    }
}
