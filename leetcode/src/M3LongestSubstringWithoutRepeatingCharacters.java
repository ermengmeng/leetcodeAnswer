/**
 * @Author: ouyangyameng
 * @Date: 2022/2/20 12:32 下午
 * @Version 1.0
 */
public class M3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new M3LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int[] temp = new int[256];
        int j = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            temp[c]++;
            if (temp[c] > 1) {
                max = Math.max(max, i - j);
                while (temp[c] > 1) {
                    temp[s.charAt(j++)]--;
                }
            }
        }
        max = Math.max(max, s.length() - j);
        return max;
    }
}
