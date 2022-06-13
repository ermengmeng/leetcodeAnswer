import common.Node;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/13 18:44
 * @Version 1.0
 */
public class M117PopulatingNextRightPointersInEachNodeII {
    public static void main(String[] args) {

    }
    public Node connect(Node root) {
        Node cur = root;
        Node leftest = null;
        Node leftCur = null;
        while (cur != null) {
            if (cur.left != null && cur.right != null) {
                cur.left.next = cur.right;
                if (leftCur != null) {
                    leftCur.next = cur.left;
                } else {
                    leftest = cur.left;
                }
                leftCur = cur.right;
            }
            if (cur.left != null && cur.right == null) {
                if (leftCur != null) {
                    leftCur.next = cur.left;
                } else {
                    leftest = cur.left;
                }
                leftCur = cur.left;
            }
            if (cur.left == null && cur.right != null) {
                if (leftCur != null) {
                    leftCur.next = cur.right;
                } else {
                    leftest = cur.right;
                }
                leftCur = cur.right;
            }
            cur = cur.next;
        }
        if (leftest != null) {
            connect(leftest);
        }
        return root;
    }
}
