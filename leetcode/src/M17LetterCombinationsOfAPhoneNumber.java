import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2023/1/16 18:33
 * @Version 1.0
 */
public class M17LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<Character>[] cacheArray = new List[10];
        cacheArray[2] = Arrays.asList('a', 'b', 'c');
        cacheArray[3] = Arrays.asList('d', 'e', 'f');
        cacheArray[4] = Arrays.asList('g', 'h', 'i');
        cacheArray[5] = Arrays.asList('j', 'k', 'l');
        cacheArray[6] = Arrays.asList('m', 'n', 'o');
        cacheArray[7] = Arrays.asList('p', 'q', 'r', 's');
        cacheArray[8] = Arrays.asList('t', 'u', 'v');
        cacheArray[9] = Arrays.asList('w', 'x', 'y', 'z');

        List<String> res = new ArrayList<>();
        doCombine(digits.toCharArray(), 0, res, new StringBuilder(), cacheArray);
        return res;
    }

    public void doCombine(char[] charArray, int index, List<String> res, StringBuilder sb, List<Character>[] cache) {
        if (index == charArray.length) {
            res.add(sb.toString());
            return;
        }
        char cur = charArray[index];
        List<Character> characterList = cache[cur - '0'];
        for (int i = 0; i < characterList.size(); i++) {
            sb.append(characterList.get(i));
            doCombine(charArray, index + 1, res, sb, cache);
            sb.deleteCharAt(index);
        }
    }
}
