import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/3/23 6:41 下午
 * @Version 1.0
 */
public class M103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<TreeNode> cur = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        cur.add(root);
        int level = 0;
        while (cur.size() > 0) {
            List<Integer> levelAns = new ArrayList<>();
            for (int i = cur.size() - 1; i >= 0; i--) {
                TreeNode node = cur.get(i);
                levelAns.add(node.val);
                if (level % 2 == 0) {
                    if (node.left != null) {
                        next.add(node.left);
                    }
                    if (node.right != null) {
                        next.add(node.right);
                    }
                } else {
                    if (node.right != null) {
                        next.add(node.right);
                    }
                    if (node.left != null) {
                        next.add(node.left);
                    }
                }
            }
            ans.add(levelAns);
            cur = next;
            next = new ArrayList<>();
            level++;
        }
        return ans;
    }
}
