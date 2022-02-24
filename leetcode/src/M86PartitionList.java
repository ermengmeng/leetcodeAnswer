/**
 * @Author: ouyangyameng
 * @Date: 2022/2/24 1:45 下午
 * @Version 1.0
 */
public class M86PartitionList {
    public static void main(String[] args) {

    }

    public ListNode partition(ListNode head, int x) {
        ListNode h = new ListNode();
        ListNode hc = h;
        ListNode b = new ListNode();
        ListNode bc = b;
        while (head != null) {
            if (head.val < x) {
                hc.next = head;
                hc = head;
            } else {
                bc.next = head;
                bc = head;
            }
            head = head.next;
        }
        hc.next = b.next;
        bc.next = null;
        return h.next;
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

}
