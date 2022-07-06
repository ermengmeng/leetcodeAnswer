import common.TreeNode;

import java.util.Stack;

/**
 * @Author: ouyangyameng
 * @Date: 2022/7/6 13:55
 * @Version 1.0
 */
public class M173BinarySearchTreeIterator {
    class BSTIterator {

        private Stack<TreeNode> stack = new Stack<>();

        private TreeNode root;

        private TreeNode next;

        public BSTIterator(TreeNode root) {
            this.root = root;
            if (root != null) {
                next = findLeftest(root);
            }
        }

        public int next() {
            int res = next.val;
            if (next.right != null) {
                next = findLeftest(next.right);
            } else {
                if (!stack.isEmpty()) {
                    next = stack.pop();
                } else {
                    next = null;
                }
            }
            return res;
        }

        public boolean hasNext() {
            return next != null;
        }

        private TreeNode findLeftest(TreeNode root) {
            TreeNode l = root;
            while (l.left != null) {
                stack.push(l);
                l = l.left;
            }
            return l;
        }
    }
}
