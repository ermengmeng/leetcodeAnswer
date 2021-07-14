/**
 * @Author: ouyangyameng
 * @Date: 2021/7/14 4:03 下午
 * @Version 1.0
 */
public class SwapNodesinPairs24 {

    public static void main(String[] args) {
        SwapNodesinPairs24 o = new SwapNodesinPairs24();
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode tmpHead = new ListNode(101, head);
        ListNode cur = tmpHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode second = cur.next;
            ListNode first = cur.next.next;
            cur.next = first;
            second.next = first.next;
            first.next = second;
            cur = second;
        }
        return tmpHead.next;
    }
}
