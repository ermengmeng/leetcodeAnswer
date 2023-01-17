import common.ListNode;

import java.util.Arrays;

/**
 * @Author: ouyangyameng
 * @Date: 2023/1/17 09:59
 * @Version 1.0
 */
public class H25ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(Arrays.asList(1,2,3,4,5));
        System.out.println(new H25ReverseNodesInKGroup().reverseKGroup(head, 2).listAll());
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) {
            return head;
        }
        ListNode t = new ListNode();
        t.next = head;
        ListNode cur = t;
        while (cur != null) {
            ListNode res = doReverse (cur, k);
            if (res == cur) {
                break;
            } else {
                cur = res;
            }
        }
        return t.next;
    }

    private ListNode doReverse(ListNode pre, int k) {
        ListNode tail = pre;
        int i = k;
        while (i>=0) {
            if (tail != null) {
                tail = tail.next;
                i--;
            } else {
                break;
            }
        }
        if (i >= 0) {
            return pre;
        }
        ListNode cur = pre.next;
        ListNode head = cur;
        ListNode next = cur.next;
        while (k-->1) {
            ListNode n = next.next;
            head = next;
            next.next = cur;
            cur = next;
            next = n;

        }
        pre.next.next = tail;
        ListNode res = pre.next;
        pre.next = head;
        return res;
    }
}
