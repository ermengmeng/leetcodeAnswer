import common.Node;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/13 14:02
 * @Version 1.0
 */


public class M116PopulatingNextRightPointersInEachNode {
    /**
     * 因为是满树 所以使用root节点及root.next节点就可以处理完当前节点和下一个节点的链接。
     * 因此左右树递归DFS处理所有子树即可
     */
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
