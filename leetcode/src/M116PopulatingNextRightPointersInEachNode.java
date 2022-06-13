import common.Node;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/13 14:02
 * @Version 1.0
 */
public class M116PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
