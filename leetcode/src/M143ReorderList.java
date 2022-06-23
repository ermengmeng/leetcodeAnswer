import common.ListNode;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/22 10:17
 * @Version 1.0
 */
public class M143ReorderList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        new M143ReorderList().reorderList(head);
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    /**
     * 1.找到中点
     * 2.翻转后半部分
     * 3.前后拉链
     * 主要考察针对链表的这些基础操作
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode right = reverse(mid);
        ListNode left = head;
        while (left != null && right != null) {
            ListNode t = left.next;
            left.next = right;
            right = right.next;
            left.next.next = t;
            left = t;
        }
        mid.next = null;
    }

    public ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = prev;
            prev = cur;
            cur = t;
        }
        return prev;
    }
}
