import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/20 10:08
 * @Version 1.0
 */
public class M131PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(new M131PalindromePartitioning().partition("efe"));
    }

    public List<List<String>> partition(String s) {
        char[] charArray = s.toCharArray();
        List<String>[] palindromeStartArray = new List[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            palindromeStartArray[i] = new ArrayList<>();
            palindromeStartArray[i].add(new String(Arrays.copyOfRange(charArray, i, i + 1)));
            int j = 1;
            while (i - j >= 0 && i + j < charArray.length && charArray[i - j] == charArray[i + j]) {
                palindromeStartArray[i - j].add(new String(Arrays.copyOfRange(charArray, i - j, i + j + 1)));
                j++;
            }
            if (i + 1 < charArray.length && charArray[i] == charArray[i + 1]) {
                palindromeStartArray[i].add(new String(Arrays.copyOfRange(charArray, i, i + 2)));
                j = 1;
                while (i - j >= 0 && i + (j + 1) < charArray.length && charArray[i - j] == charArray[i + (j + 1)]) {
                    palindromeStartArray[i - j].add(new String(Arrays.copyOfRange(charArray, i - j, i + (j + 2))));
                    j++;
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        partition(palindromeStartArray, 0, 0, s.length(), new LinkedList<>(), res);
        return res;
    }

    void partition(List<String>[] palindromeStartArray, int index, int length, int total, LinkedList<String> cur, List<List<String>> res) {
        if (length == total) {
            res.add(new ArrayList<>(cur));
            return;
        }
        List<String> partitionStart = palindromeStartArray[index];
        for (int i = 0; i < partitionStart.size(); i++) {
            String curPartition = partitionStart.get(i);
            cur.add(curPartition);
            partition(palindromeStartArray, index + curPartition.length(), length + curPartition.length(), total, cur, res);
            cur.removeLast();
        }
    }
}
