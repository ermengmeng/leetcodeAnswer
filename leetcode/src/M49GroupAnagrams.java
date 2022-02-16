import java.util.*;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/16 4:10 下午
 * @Version 1.0
 */
public class M49GroupAnagrams {
    public static void main(String[] args) {
       String key = new M49GroupAnagrams().computeKey("aaa");
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = computeKey(str);
            if (map.get(key) == null) {
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String computeKey(String str) {
        int[] t = new int[26];
        for (char c : str.toCharArray()) {
            t[c-'a'] += 1;
        }
        String key = "";
        for (int i = 0 ; i < 26 ; i++) {
            if (t[i] > 0) {
                key += i+"."+t[i]+",";
            }
        }
        return key;
    }
}
