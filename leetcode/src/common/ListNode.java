package common;

/**
 * @Author: ouyangyameng
 * @Date: 2022/4/25 19:02
 * @Version 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;

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
