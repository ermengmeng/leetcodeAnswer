import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/14 09:57
 * @Version 1.0
 */
public class M120Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new M120Triangle().minimumTotal(triangle));
    }

    /**
     * 简单DP,由上至下 逐层计算到每个节点的最小sum和
     * 每个节点的最小sum, S(i,j) = Math.min(S(i-1,j-1), S(i-1,j)) + V(i,j)
     * 最终遍历叶子节点取出最小值
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        List<Integer> root = triangle.get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> cur = triangle.get(i);
            cur.set(0, cur.get(0) + root.get(0));
            for (int j = 1; j < root.size(); j++) {
                cur.set(j, Math.min(root.get(j - 1), root.get(j)) + cur.get(j));
            }
            cur.set(cur.size() - 1, root.get(root.size() - 1) + cur.get(cur.size() - 1));
            root = cur;
        }
        int min = root.stream().min(Integer::compareTo).get();
        return min;
    }
}
