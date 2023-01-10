import java.util.*;

/**
 * @Author: ouyangyameng
 * @Date: 2023/1/9 14:36
 * @Version 1.0
 */
public class M241DifferentWaysToAddParentheses {

    public static void main(String[] args) {
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new LinkedList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-' ||
                    input.charAt(i) == '*' ||
                    input.charAt(i) == '+') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                for (Integer p1 : part1Ret) {
                    for (Integer p2 : part2Ret) {
                        int c = operator(p1, p2, input.charAt(i));
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        return ret;
    }

    private Integer operator(Integer i0, Integer i1, Character op) {
        switch (op) {
            case '+':
                return i0 + i1;
            case '-':
                return i0 - i1;
            case '*':
                return i0 * i1;
        }
        return 0;
    }
}
