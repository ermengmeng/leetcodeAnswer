import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/2/17 5:07 下午
 * @Version 1.0
 */
public class M61RotateList {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        ListNode node = new M61RotateList().rotateRight(one, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode tail = head;
        int num = 1;
        while (tail.next != null) {
            num++;
            tail = tail.next;
        }
        k = k % num;
        if (k == 0) {
            return head;
        }
        ListNode mid = head;

        for (int i = 1; i < num - k; i++) {
            mid = mid.next;
        }
        ListNode res = mid.next;
        tail.next = head;
        mid.next = null;
        return res;
    }

    public static class ListNode {
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
