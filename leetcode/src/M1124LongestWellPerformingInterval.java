import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2021/4/14 1:44 下午
 * @Version 1.0
 */
//TODO 优化
public class M1124LongestWellPerformingInterval {
    public int longestWPI(int[] hours) {
        int max = 0;
        for (int i = 0 ; i < hours.length; i++) {
            int cur = 0;
            int curMax = 0;
            for (int j = i; j < hours.length; j++) {
                if(hours[j] > 8) {
                    cur++;
                } else {
                    cur--;
                }
                if (cur > 0) {
                    curMax = j - i + 1;
                }
            }
            max = Math.max(curMax,max);
        }
        return max;
    }
}
