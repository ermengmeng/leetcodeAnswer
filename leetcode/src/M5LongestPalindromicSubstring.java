/**
 * @Author: ouyangyameng
 * @Date: 2022/2/21 7:18 下午
 * @Version 1.0
 */
public class M5LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new M5LongestPalindromicSubstring().longestPalindrome("aaaa"));
    }

    public String longestPalindrome(String s) {
        int indexLeft = 0;
        int indexRight = 0;
        int maxLength = 0;
        if (s == null || s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length()-1; i++) {
            int length1 = doPalindrome(s.toCharArray(), i,i);
            int length2 = doPalindrome(s.toCharArray(), i,i+1);
            if (length1 * 2 + 1 > maxLength) {
                maxLength = length1 * 2 + 1 ;
                indexLeft = i - length1;
                indexRight = i + 1 + length1;
                System.out.print("1" + indexLeft + " " + indexRight + " " + i + " "+ length1);
            }
            if (length2 * 2 > maxLength) {
                maxLength = length2 * 2;
                indexLeft = i - (length2 -1);
                indexRight = i+1 + (length2);
                System.out.print("2" + indexLeft + " " + indexRight + " " + i);
            }
        }
        return s.substring(indexLeft, indexRight);
    }

    private int doPalindrome(char[] array, int l, int r) {
        int res = 0;
        if (l+1==r && array[l] != array[r]) {
            return 0;
        }
        while (l - res - 1 >= 0 && r + res + 1 < array.length && array[l-res -1] == array[r+res + 1]) {
            res++;
        }
        if (l+1==r) {
            res++;
        }
        return res;
    }
}
