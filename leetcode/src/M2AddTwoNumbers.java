import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/20 12:14 下午
 * @Version 1.0
 */
public class M2AddTwoNumbers {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode ans = new ListNode(0);
        ListNode index = ans;
        while (l1 != null || l2 != null || add > 0) {
            int cur = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val)
                    + add;
            ListNode t = new ListNode(cur % 10);
            add = cur / 10;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
            index.next = t;
            index = t;
        }
        return ans.next;
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
