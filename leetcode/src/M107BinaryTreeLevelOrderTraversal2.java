import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/4/7 19:24
 * @Version 1.0
 */
public class M107BinaryTreeLevelOrderTraversal2 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> cur = new ArrayList<>();
        List<TreeNode> curNodeList = new ArrayList<>();
        curNodeList.add(root);
        cur.add(root.val);
        ans.addFirst(cur);
        while (curNodeList.size() > 0) {
            cur = new ArrayList<>();
            List<TreeNode> tmpNode = new ArrayList<>();
            for (TreeNode node : curNodeList) {
                if (node.left != null) {
                    tmpNode.add(node.left);
                    cur.add(node.left.val);
                }
                if (node.right != null) {
                    tmpNode.add(node.right);
                    cur.add(node.right.val);
                }
            }
            curNodeList = tmpNode;
            if (cur.size() > 0) {
                ans.addFirst(cur);
            }
        }
        return ans;
    }
}
