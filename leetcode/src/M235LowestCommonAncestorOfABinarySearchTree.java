import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/9/26 15:08
 * @Version 1.0
 */
public class M235LowestCommonAncestorOfABinarySearchTree {


    /**
     * 如果存在比当前root节点更小的公共祖先，则两个节点p，q必须在root的同侧,即必须同时比root小或比root大。
     * 否则,p，q会在root两边，他们的最小公共祖先为root。
     * 依此进行递归,得到最小公共祖先的返回。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor3(root.left, p, q);
        else if (root.val < p.val && root.val < q.val) return lowestCommonAncestor3(root.right, p, q);
        return root;
    }

    /**
     * 直接查出两条链进行对比
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> plist = new ArrayList<>();
        findNodePath(root, p, plist);
        List<TreeNode> qlist = new ArrayList<>();
        findNodePath(root, q, qlist);
        int i = 0;
        TreeNode res = null;
        while (i < plist.size() && i < qlist.size()) {
            if (plist.get(i) == qlist.get(i)) {
                res = plist.get(i);
                i++;
            } else {
                break;
            }
        }
        return res;
    }

    public void findNodePath(TreeNode root, TreeNode node, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        if (root == node) {
            return;
        }
        if (root.val < node.val) {
            findNodePath(root.right, node, list);
        }
        if (root.val > node.val) {
            findNodePath(root.left, node, list);
        }
        return;
    }


    /**
     * 先查找出p的path，并从后向前依此判断是否是q的祖先。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> plist = new ArrayList<>();
        findNodePath(root, p, plist);
        TreeNode res = null;
        for (int i = plist.size() - 1; i >= 0; i--) {
            if (isAncestor2(plist.get(i), q)) {
                res = plist.get(i);
                break;
            }
        }
        return res;
    }

    public boolean isAncestor2(TreeNode root, TreeNode q) {
        if (root == null) {
            return false;
        }
        if (root == q) {
            return true;
        }
        if (root.val < q.val) {
            return isAncestor2(root.right, q);
        } else {
            return isAncestor2(root.left, q);
        }
    }

}
