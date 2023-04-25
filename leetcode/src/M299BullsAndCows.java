/**
 * @Author: ouyangyameng
 * @Date: 2023/4/25 14:45
 * @Version 1.0
 */
public class M299BullsAndCows {
    public String getHint(String secret, String guess) {
        int[] a = new int[10];
        int[] b = new int[10];
        int A = 0;
        int B = 0;
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) {
                a[s]++;
            } else {
                b[s]++;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            int g = guess.charAt(i) - '0';
            if (a[g] > 0) {
                a[g]--;
                A++;
            } else if (b[g] > 0) {
                b[g]--;
                B++;
            }
        }
        return A+ "A" + B + "B";
    }
}
