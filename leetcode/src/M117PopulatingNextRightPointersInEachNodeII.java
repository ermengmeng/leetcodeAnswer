import common.Node;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/13 18:44
 * @Version 1.0
 */

public class M117PopulatingNextRightPointersInEachNodeII {
    /**
     * 由于题目中指出不是满树
     * 因此当前节点的next节点无法根据,root的next链得出(DFS过程中可能还没处理到后面的next)
     * 向前保存需要额外的空间记录每层的最后一个last
     * 因此采用BFS处理
     * @param root
     * @return
     */
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
