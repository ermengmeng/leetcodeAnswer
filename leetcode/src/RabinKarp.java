import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/9/27 17:08
 * @Version 1.0
 */
public class RabinKarp {
    public static void main(String[] args) {
        System.out.println(new RabinKarp().rabinKarp("aaaaa", "aa"));
        long i = 1;
        long j = 1;
        while (j > 0) {
            System.out.println(i + " " + j);
            i++;
            j*=26;
        }
    }

    public List<Integer> rabinKarp(String src, String sub) {
        List<Integer> res = new ArrayList<>();
        if (sub.length() > src.length()) {
            return res;
        }
        if (sub.length() == src.length() && sub.equals(src)) {
            res.add(0);
            return res;
        }
        int mask = computeMask(sub);
        int subHash = computeHash(sub);
        int srcHash = computeHash(src.substring(0, sub.length()));
        if (subHash == srcHash) {
            res.add(0);
        }
        for (int i = sub.length(); i < src.length(); i++) {
            srcHash = robinHash(srcHash, src.charAt(i), mask);
            if (srcHash == subHash) {
                res.add(i - sub.length() + 1);
            }
        }
        return res;
    }

    private int computeMask(String str) {
        int mask = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            mask *= 26;
        }
        return mask;
    }

    private int computeHash(String str) {
        int hash = 0;
        int mask = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            hash += (c - 'a') * mask;
            mask *= 26;
        }
        return hash;
    }

    private int robinHash(int srcHash, char c, int mask) {
        return (srcHash % mask) * 26 + (c - 'a');
    }
}
