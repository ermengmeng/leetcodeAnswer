import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/9/26 16:35
 * @Version 1.0
 */
public class M236LowestCommonAncestorOfABinaryTree {


    /**
     * p,q一定在最小公共祖先的左右两侧,如在同侧,则一定存在更小的公共祖先。
     * 因此在左右分别寻找p或者q。如果左右都返回了找到p或者q则,此时的root为最小公共祖先。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) return root;
        if (root.left == null && root.right == null) return null;
        TreeNode left = null, right = null;
        if (root.left != null) left = lowestCommonAncestor2(root.left, p, q);
        if (root.right != null) right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null) return root;
        return (left == null) ? right : left;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] res = new TreeNode[1];
        getSubNode(root, p, q, res);
        return res[0];
    }

    private List<TreeNode> getSubNode(TreeNode root, TreeNode p, TreeNode q, TreeNode[] res) {
        List<TreeNode> nodeList = new ArrayList<>();
        if (root == null) {
            return nodeList;
        }
        if (root == p || root == q) {
            nodeList.add(root);
        }
        List<TreeNode> left = getSubNode(root.left, p, q, res);
        nodeList.addAll(left);
        if (nodeList.size() < 2) {
            List<TreeNode> right = getSubNode(root.right, p, q, res);
            nodeList.addAll(right);
        }
        if (nodeList.size() == 2 && res[0] == null) {
            res[0] = root;
        }
        return nodeList;
    }
}
