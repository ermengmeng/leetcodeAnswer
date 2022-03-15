/**
 * @Author: ouyangyameng
 * @Date: 2022/3/15 1:56 下午
 * @Version 1.0
 */
public class M96UniqueBinarySearchTrees {
    public static void main(String[] args) {
        System.out.println(new M96UniqueBinarySearchTrees().numTrees(1));
    }

    public int numTrees(int n) {
        int[] subTrees = new int[n];
        int res = 0;
        subTrees[0] = 1;
        for (int i = 0; i < n; i++) {
            res += computeSubTreeNum(i, subTrees) * computeSubTreeNum(n - i - 1, subTrees);
        }
        return res;
    }

    public int computeSubTreeNum(int n, int[] subTrees) {
        int sum = 0;
        if (subTrees[n] > 0) {
            return subTrees[n];
        }
        for (int i = 0; i < n; i++) {
            sum += computeSubTreeNum(i, subTrees) * computeSubTreeNum(n - i - 1, subTrees);
        }
        subTrees[n] = sum;
        return sum;
    }
}
