import common.TreeNode;

import java.util.Stack;

/**
 * @Author: ouyangyameng
 * @Date: 2022/3/22 6:42 下午
 * @Version 1.0
 */
public class M99RecoverBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        new M99RecoverBinarySearchTree().recoverTree(root);
    }

    public void recoverTree(TreeNode root) {
        doBST(root);
        if (ans[0]!= null && ans[3]!=null) {
            int t = ans[0].val;
            ans[0].val = ans[3].val;
            ans[3].val = t;
        } else {
            int t = ans[0].val;
            ans[0].val = ans[1].val;
            ans[1].val = t;
        }
    }

    TreeNode pre;
    TreeNode[] ans = new TreeNode[4];
    int index = 0;
    private void doBST(TreeNode treeNode) {
        if (treeNode == null || index == 4) {
            return;
        }
        doBST(treeNode.left);
        if (pre != null && pre.val > treeNode.val) {
            ans[index++] = pre;
            ans[index++] = treeNode;
        }
        pre = treeNode;
        doBST(treeNode.right);
    }
}
