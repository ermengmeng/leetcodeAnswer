import common.ListNode;
import common.Node;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/21 18:52
 * @Version 1.0
 */
public class M142LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        int len = computeCycleLength(head);
        if (len == 0) return null;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0 ; i < len; i++) {
            fast = fast.next;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public int computeCycleLength(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode t = fast;
                int len = 0;
                do{
                    t = t.next;
                    len++;
                } while (t != fast);
                return len;
            }
        }
        return 0;
    }
}
