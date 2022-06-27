import common.ListNode;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/27 13:10
 * @Version 1.0
 */
public class M148SortList {
    public static void main(String[] args) {
        int[] array = {4,2,1,3};
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i : array) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode list = new M148SortList().sortList(head.next);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

    /**
     * 归并排序
     * 不同于数组排序，链表排序由于无法随机访问，因此采用分治的思路进行归并排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        if(head == null || head.next == null)
            return head;
        while(quick.next != null && quick.next.next != null){
            quick = quick.next.next;
            slow = slow.next;
        }
        quick = slow;
        slow = slow.next;
        quick.next = null;
        quick = sortList(head);
        slow = sortList(slow);
        return mergeTwoLists(quick,slow);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode site = root;
        while(l1 != null && l2 != null){
            if(l1.val<l2.val){
                site.next = l1;
                l1 = l1.next;
            } else {
                site.next = l2;
                l2 = l2.next;
            }
            site = site.next;
        }
        if(l1 != null){
            site.next = l1;
        }
        if(l2 != null){
            site.next = l2;
        }
        return root.next;
    }
}
