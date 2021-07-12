/**
 * @Author: ouyangyameng
 * @Date: 2021/7/12 6:52 下午
 * @Version 1.0
 */
public class RemoveNthNodeFromEndofList19 {
    public static void main(String[] args) {
        RemoveNthNodeFromEndofList19 o = new RemoveNthNodeFromEndofList19();
    }

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tail = head;
        while (n-- > 0) {
            tail = tail.next;
        }
        if (tail == null) {
            return head.next;
        }
        ListNode tmp = head;
        while (tail != null && tail.next != null) {
            tail = tail.next;
            tmp = tmp.next;
        }
        if (tmp.next != null) {
            tmp.next = tmp.next.next;
        }
        return head;
    }
}
