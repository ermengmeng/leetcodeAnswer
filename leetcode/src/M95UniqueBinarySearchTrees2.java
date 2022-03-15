import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: ouyangyameng
 * @Date: 2022/3/14 1:50 下午
 * @Version 1.0
 */
public class M95UniqueBinarySearchTrees2 {

    public static void main(String[] args) {
        new M95UniqueBinarySearchTrees2().generateTrees(3);
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.addAll(generateTrees(i, Stream.iterate(1, n1 -> n1 + 1).limit(i - 1).collect(Collectors.toList()), Stream.iterate(i + 1, n1 -> n1 + 1).limit(n - i).collect(Collectors.toList())));
        }
        return res;
    }

    public List<TreeNode> generateTrees(int n, List<Integer> left, List<Integer> right) {
        List<TreeNode> list = new ArrayList<>();
        List<TreeNode> lList = new ArrayList<>();
        List<TreeNode> rList = new ArrayList<>();
        if (left.size() == 0) {
            lList.add(null);
        }
        if (right.size() == 0) {
            rList.add(null);
        }
        for (int i = 0; i < left.size(); i++) {
            List<Integer> ll = i == 0 ? new ArrayList<>() : left.subList(0, i);
            List<Integer> rl = i == left.size() - 1 ? new ArrayList<>() : left.subList(i + 1, left.size());
            lList.addAll(generateTrees(left.get(i), ll, rl));
        }
        for (int i = 0; i < right.size(); i++) {
            List<Integer> lr = i == 0 ? new ArrayList<>() : right.subList(0, i);
            List<Integer> rr = i == right.size() - 1 ? new ArrayList<>() : right.subList(i + 1, right.size());
            rList.addAll(generateTrees(right.get(i), lr, rr));
        }
        for (TreeNode l : lList) {
            for (TreeNode r : rList) {
                list.add(new TreeNode(n, l, r));
            }
        }
        return list;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
