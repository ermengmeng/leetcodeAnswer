import common.TreeNode;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/16 18:43
 * @Version 1.0
 */
public class M129SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int base) {
        if (root == null) {
            return base;
        }
        int newBase = base * 10 + root.val;
        if (root.left == null && root.right == null) {
            return newBase;
        }
        return (root.left == null ? 0 : sumNumbers(root.left, newBase)) + (root.right == null ? 0 : sumNumbers(root.right, newBase));
    }
}
