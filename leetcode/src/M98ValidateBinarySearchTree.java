import common.TreeNode;

import java.util.Stack;

/**
 * @Author: ouyangyameng
 * @Date: 2022/3/17 6:11 下午
 * @Version 1.0
 */

public class M98ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2147483648);
        //root.left = new TreeNode(4);
        root.right = new TreeNode(2147483647);
        //root.right.left = new TreeNode(3);
        //root.right.right = new TreeNode(7);
        System.out.println(new M98ValidateBinarySearchTree().isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidNodeLeft(root.left, root.val, Long.MIN_VALUE) && isValidNodeRight(root.right, Long.MAX_VALUE, root.val);
    }

    private boolean isValidNodeLeft(TreeNode node, long max, long min) {
        if (node == null) {
            return true;
        }
        if (node.val >= max || node.val <= min) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        return isValidNodeLeft(node.left, Math.min(max, node.val), min) && isValidNodeRight(node.right, max, Math.max(min, node.val));
    }

    private boolean isValidNodeRight(TreeNode node, long max, long min) {
        if (node == null) {
            return true;
        }
        if (node.val >= max || node.val <= min) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        return isValidNodeLeft(node.left, Math.min(max, node.val), min) && isValidNodeRight(node.right, max, Math.max(min, node.val));
    }
}
