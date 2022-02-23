import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/21 7:18 下午
 * @Version 1.0
 */
public class M5LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new M5LongestPalindromicSubstring().longestPalindrome("bb"));
    }

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        if(s.length() == 1){
            return s;
        }
        int start = 0;
        int end = 0;
        for(int i = 0;i<s.length()-1;i++){
            int lenOdd = getRoundLen(s,i,i);
            int lenEven = getRoundLen(s,i,i+1);
            if(lenOdd > end-start){
                start = i-lenOdd/2;
                end = i+lenOdd/2+1;
            }
            if(lenEven > end - start){
                start = i-(lenEven/2-1);
                end = i+1+(lenEven/2-1)+1;
            }
        }

        return s.substring(start,end);
    }

    private int getRoundLen(String s, int left, int right){
        char leftC = s.charAt(left);
        char rightC = s.charAt(right);
        int len = 0;
        if(left == right && leftC == rightC){
            len = 1;
        }
        if(left+1 == right && leftC == rightC){
            len = 2;
        }
        if(left+1 == right && leftC != rightC){
            return len;
        }
        int i = 1;
        while(left-i>=0 && right+i<=s.length()-1 && s.charAt(left-i) == s.charAt(right+i)){
            i++;
        }
        return len+(i-1)*2;
    }
}
