import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2021/4/21 4:04 下午
 * @Version 1.0
 */
public class M842SplitArrayintoFibonacciSequence {
    public static void main(String[] args) {
        M842SplitArrayintoFibonacciSequence o = new M842SplitArrayintoFibonacciSequence();
        System.out.println(o.splitIntoFibonacci("123456579"));
    }

    public List<Integer> splitIntoFibonacci(String S) {
        int[] dp = new int[S.length()];
        for (int i = 1; i < S.length() && i < 10; i++) {
            for (int j = 1; i + j < S.length() && j < 10; j++) {
                String curString = S.substring(0, i);
                if (curString.startsWith("0") && !"0".equals(curString)) {
                    continue;
                }
                long cur = Long.valueOf(curString);
                if (cur > Integer.MAX_VALUE) {
                    continue;
                }
                dp[0] = (int)cur;

                curString = S.substring(i, i + j);
                if (curString.startsWith("0") && !"0".equals(curString)) {
                    continue;
                }
                cur = Long.valueOf(curString);
                if (cur > Integer.MAX_VALUE) {
                    continue;
                }
                dp[1] = (int)cur;

                List<Integer> list = dp(S, i + j, dp, 2);
                if (list.size() > 0) {
                    return list;
                }
            }

        }
        return new ArrayList<>();
    }

    private List<Integer> dp(String s, int start, int[] dp, int index) {
        List<Integer> list = new ArrayList<>();
        if (start >= s.length()) {
            for (int i = 0; i < index; i++) {
                list.add(dp[i]);
            }
            return list;
        }
        int except = dp[index - 1] + dp[index - 2];
        String sum = String.valueOf(except);
        if (s.substring(start).startsWith(sum)) {
            dp[index] = except;
            list = dp(s, start + sum.length(), dp, index + 1);
            if (list.size() > 0) {
                return list;
            }
        }
        return new ArrayList<>();
    }
}
