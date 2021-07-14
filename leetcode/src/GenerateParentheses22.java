import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2021/7/12 7:09 下午
 * @Version 1.0
 */
public class GenerateParentheses22 {
    public static void main(String[] args) {
        GenerateParentheses22 o = new GenerateParentheses22();
        System.out.println(o.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate("", n, 0, 0, res);
        return res;
    }

    private void generate(String cur, int n, int has, int left, List<String> res) {
        if (cur.length() == n * 2) {
            res.add(cur);
        } else {
            if (has < n) {
                generate(cur + "(", n, has + 1, left + 1, res);
            }
            if (left > 0) {
                generate(cur + ")", n, has, left - 1, res);
            }
        }
    }
}

