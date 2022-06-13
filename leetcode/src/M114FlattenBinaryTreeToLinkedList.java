import common.ListNode;
import common.TreeNode;

import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/13 09:59
 * @Version 1.0
 */
public class M114FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        subFlatten(root, root);
    }

    public TreeNode subFlatten(TreeNode root, TreeNode head) {
        TreeNode tail = head;
        TreeNode left = root.left;
        TreeNode right = root.right;
        tail.left = null;
        if (left != null) {
            tail.right = new TreeNode(left.val);
            tail = subFlatten(left, tail.right);
        }
        if (right != null) {
            tail.right = new TreeNode(right.val);
            tail = subFlatten(right, tail.right);
        }
        return tail;
    }
}
