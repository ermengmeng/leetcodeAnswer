package common;

import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/4/25 19:02
 * @Version 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(List<Integer> list) {
        this.val = list.get(0);
        ListNode t = this;
        for (int i = 1; i < list.size(); i++) {
            t.next = new ListNode(list.get(i));
            t = t.next;
        }
    }

    public String listAll() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur.next != null) {
            sb.append(cur.val + "->");
            cur = cur.next;
        }
        sb.append(cur.val);
        return sb.toString();
    }
}
