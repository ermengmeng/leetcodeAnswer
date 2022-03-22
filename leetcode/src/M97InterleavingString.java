/**
 * @Author: ouyangyameng
 * @Date: 2022/3/15 6:28 下午
 * @Version 1.0
 */
public class M97InterleavingString {
    public static void main(String[] args) {
        System.out.println(new M97InterleavingString().isInterleave("abababababababababababababababababababababababababababababababababababababababababababababababababbb",
                "babababababababababababababababababababababababababababababababababababababababababababababababaaaba",
                "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababbb"));
    }

    char[] c1;
    char[] c2;
    char[] c3;

    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        c1 = s1.toCharArray();
        c2 = s2.toCharArray();
        c3 = s3.toCharArray();
        return checkInter(0, 0, dp);
    }

    public boolean checkInter(int i1, int i2, Boolean[][] dp) {
        boolean res = i1 == c1.length && i2 == c2.length;
        if (dp[i1][i2] != null) {
            return dp[i1][i2];
        }
        if (i1 < c1.length && c1[i1] == c3[i1 + i2]) {
            if (checkInter(i1 + 1, i2, dp)) {
                dp[i1][i2] = true;
                return true;
            }
        }
        if (i2 < c2.length && c2[i2] == c3[i1 + i2]) {
            if (checkInter(i1, i2 + 1, dp)) {
                dp[i1][i2] = true;
                return true;
            }
        }
        dp[i1][i2] = res;
        return res;
    }
}
