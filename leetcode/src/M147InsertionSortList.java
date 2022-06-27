import common.ListNode;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/27 13:02
 * @Version 1.0
 */
public class M147InsertionSortList {
    /**
     * 简单插排
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode cur = head;
        ListNode res = new ListNode();
        while (cur != null) {
            ListNode n = cur.next;
            insertList(res, cur);
            cur = n;
        }
        return res.next;
    }

    private void insertList(ListNode res, ListNode cur) {
        ListNode t = res;
        while (t.next != null && t.next.val < cur.val) {
            t = t.next;
        }
        ListNode next = t.next;
        t.next = cur;
        cur.next = next;
    }
}
