import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/14 2:10 下午
 * @Version 1.0
 */
public class M43MultiplyStrings {
    public static void main(String[] args) {
        M43MultiplyStrings o = new M43MultiplyStrings();
        System.out.println(o.multiply("40262", "8853"));
    }

    //"356439486"
    public String multiply(String num1, String num2) {
        List<Integer>[] multiplyTemp = new ArrayList[num2.length()];
        Map<Integer, List<Integer>> cache = new HashMap<>();
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int max = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int multiplier = num2.charAt(i) - '0';
            int site = num2.length() - 1 - i;
            if (cache.get(multiplier) == null) {
                multiplyTemp[site] = multiplySingle(num1, multiplier);
                cache.put(multiplier, multiplyTemp[site]);
            } else {
                multiplyTemp[site] = cache.get(multiplier);
            }
            max = Math.max(max, multiplyTemp[site].size() + site);
        }
        List<Integer> resList = new ArrayList<>();
        int add = 0;
        int single = 0;
        int index = 0;
        while (index < max) {
            for (int i = 0; i <= index && i < multiplyTemp.length; i++) {
                single += multiplyTemp[i].size() > (index - i) ? multiplyTemp[i].get(index - i) : 0;
            }
            index++;
            single += add;
            add = single / 10;
            single = single % 10;
            resList.add(single);
            single = 0;
        }
        if (add > 0) {
            resList.add(add);
        }
        String res = "";
        for (Integer i : resList) {
            res = i + res;
        }
        return res;
    }

    private List<Integer> multiplySingle(String num, int multiplier) {
        int add = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            int single = (c - '0') * multiplier + add;
            add = single / 10;
            single = single % 10;
            res.add(single);
        }
        if (add > 0) {
            res.add(add);
        }
        return res;
    }
}
