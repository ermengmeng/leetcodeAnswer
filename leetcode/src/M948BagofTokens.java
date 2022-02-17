import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2021/4/15 7:54 下午
 * @Version 1.0
 */
public class M948BagofTokens {
    public static void main(String[] args) {
        M948BagofTokens o = new M948BagofTokens();
        System.out.print((o.bagOfTokensScore(new int[]{100}, 50)));
    }
    public int bagOfTokensScore(int[] tokens, int P) {
        int max = 0;
        int i = 0;
        int j = tokens.length -1;
        int p = P;
        int score = 0;
        Arrays.sort(tokens);
        while (i <= j) {
            if (p >= tokens[i]) {
                score++;
                p-=tokens[i++];
                max = Math.max(max, score);
            } else {
                if (score > 0) {
                    score--;
                    p+=tokens[j--];
                } else {
                    break;
                }
            }
        }
        return max;
    }
}
