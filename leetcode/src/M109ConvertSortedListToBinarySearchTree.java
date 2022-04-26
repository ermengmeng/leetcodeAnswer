import common.ListNode;
import common.TreeNode;

/**
 * @Author: ouyangyameng
 * @Date: 2022/4/26 9:22 上午
 * @Version 1.0
 */
public class M109ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        int[] array = new int[]{-10,-3,0,5,9};
        ListNode head = null;
        for (int i = array.length-1 ; i>=0;i--) {
            head = new ListNode(array[i],head);
        }
        M109ConvertSortedListToBinarySearchTree o = new M109ConvertSortedListToBinarySearchTree();
        o.sortedListToBST(head);
    }
    public TreeNode sortedListToBST(ListNode head) {
        return convertTree(head, null);
    }

    private TreeNode convertTree(ListNode head, ListNode tail) {
        ListNode mid = findMid(head, tail);
        if (mid == null) {
            return null;
        }
        TreeNode root = new TreeNode(mid.val);
        root.left = convertTree(head, mid);
        root.right = convertTree(mid.next, tail);
        return root;
    }

    private ListNode findMid(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode a = head, b = head;
        while (b != tail && b.next != tail) {
            a = a.next;
            b = b.next.next;
        }
        return a;
    }
}
