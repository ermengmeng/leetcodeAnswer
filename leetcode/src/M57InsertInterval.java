import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/17 1:42 下午
 * @Version 1.0
 */
public class M57InsertInterval {
    public static void main(String[] args) {
        M57InsertInterval o = new M57InsertInterval();
        int[][] res = o.insert(new int[][]{new int[]{1,5}}, new int[]{2,3});
        Arrays.stream(res).forEach(array -> System.out.println(Arrays.toString(array)));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = 0;
        while (start < intervals.length && intervals[start][0] < newInterval[0]) {
            start++;
        }
        int end = start;
        while (end < intervals.length && newInterval[1] >= intervals[end][0]) {
            newInterval[1] = Math.max(newInterval[1], intervals[end][1]);
            end++;
        }
        if (start > 0 && intervals[start - 1][1] >= newInterval[0]) {
            newInterval[0] = intervals[start - 1][0];
            newInterval[1] = Math.max(newInterval[1], intervals[start - 1][1]);
            start--;
        }
        int[][] ans = new int[start + intervals.length - end + 1][2];
        for (int i = 0; i < start; i++) {
            ans[i] = intervals[i];
        }
        ans[start] = newInterval;
        for (int i = 0; i < intervals.length - end; i++) {
            ans[start + 1 + i] = intervals[end + i];
        }
        return ans;
    }
}
