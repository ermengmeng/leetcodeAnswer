import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/7/15 17:53
 * @Version 1.0
 */
public class M199BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<TreeNode> cur = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        cur.add(root);
        while (cur.size() > 0) {
            list.add(cur.get(0).val);
            for (TreeNode node : cur) {
                if (node.right != null) {
                    next.add(node.right);
                }
                if (node.left != null) {
                    next.add(node.left);
                }
            }
            cur = next;
            next = new ArrayList<>();
        }
        return list;
    }
}
