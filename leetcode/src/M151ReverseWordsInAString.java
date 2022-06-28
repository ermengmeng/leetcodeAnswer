import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/27 18:42
 * @Version 1.0
 */
public class M151ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(new M151ReverseWordsInAString().reverseWords("     the    sky is blue    "));
    }

    /**
     * 通过整体翻转再翻转词汇完成翻转词汇顺序的目的。
     * 需要小心处理空格，并缩进数组。
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        reverse(array, 0, array.length - 1);
        int i = 0;
        int cur = 0;
        while (i < array.length) {
            if (array[i] == ' ') {
                while (i < array.length && array[i] == ' ') {
                    i++;
                }
                array[cur] = ' ';
                cur++;
            } else {
                int start = i;
                while (i < array.length && array[i] != ' ') {
                    i++;
                }
                reverseWord(array, cur, start, i - 1);
                cur += (i - start);
            }
        }
        String str =  new String(Arrays.copyOfRange(array, 0, cur));
        return str.trim();
    }

    private void reverseWord(char[] array, int site, int start, int end) {
        int s = start;
        int e = end;
        while (end > start) {
            char t = array[start];
            array[start] = array[end];
            array[end] = t;
            end--;
            start++;
        }
        if (s > site) {
            while (s <= e) {
                array[site] = array[s];
                s++;
                site++;
            }
        }
    }

    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            char t = array[start];
            array[start] = array[end];
            array[end] = t;
            start++;
            end--;
        }
    }
}
