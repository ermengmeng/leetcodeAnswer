/**
 * @Author: ouyangyameng
 * @Date: 2022/3/11 6:53 下午
 * @Version 1.0
 */
public class M92ReverseLinkedList2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode c = head;
        for (int i = 2; i <=5; i++) {
            ListNode t = new ListNode(i);
            c.next = t;
            c = t;
        }
        System.out.println(new M92ReverseLinkedList2().reverseBetween(head, 2,4));
    }

    /**
     * 翻转链表2,先找到翻转的点,然后转换为整链表翻转。
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode h = new ListNode();
        h.next = head;
        ListNode pre = h;
        ListNode l = head;
        ListNode r = head;
        ListNode next = head.next;
        for (int i = 1; i < right; i++) {
            if (i < left) {
                pre = pre.next;
                l = l.next;
            }
            r = r.next;
            next = next.next;
        }
        pre.next = null;
        r.next = null;
        reverseBetween(l);
        pre.next = r;
        l.next = next;
        return h.next;
    }


    public ListNode reverseBetween(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        return pre;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
