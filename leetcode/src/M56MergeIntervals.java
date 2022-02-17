import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/17 1:24 下午
 * @Version 1.0
 */
public class M56MergeIntervals {
    public static void main(String[] args) {
        M56MergeIntervals o = new M56MergeIntervals();
        int[][] res = o.merge(new int[][]{new int[]{1,3},new int[]{2,6},new int[]{8,10},new int[]{15,18}});
        Arrays.stream(res).forEach(array -> System.out.println(Arrays.toString(array)));
        System.out.println();
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a-> a[0]));
        int[][] ans = new int[intervals.length][2];
        int[] cur = Arrays.copyOf(intervals[0],2);
        int n = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= cur[1]) {
                cur[1] = Math.max(cur[1],intervals[i][1]);
            } else {
                ans[n++] = cur;
                cur = Arrays.copyOf(intervals[i],2);
            }
        }
        ans[n++] = cur;
        return Arrays.copyOf(ans,n);
    }
}
