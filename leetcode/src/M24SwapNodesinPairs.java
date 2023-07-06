import common.ListNode;

/**
 * @Author: ouyangyameng
 * @Date: 2021/7/14 4:03 下午
 * @Version 1.0
 */
public class M24SwapNodesinPairs {

    public static void main(String[] args) {
        M24SwapNodesinPairs o = new M24SwapNodesinPairs();
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
