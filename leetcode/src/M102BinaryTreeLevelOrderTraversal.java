import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/3/23 6:29 下午
 * @Version 1.0
 */
public class M102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> cur = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        cur.add(root);
        while (cur.size() > 0) {
            List<Integer> levelAns = new ArrayList<>();
            for (TreeNode node : cur) {
                levelAns.add(node.val);
                    if (node.left != null) {
                        next.add(node.left);
                    }
                    if (node.right != null) {
                        next.add(node.right);
                    }
            }
            ans.add(levelAns);
            cur = next;
            next = new ArrayList<>();
        }
        return ans;
    }
}
