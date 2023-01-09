import common.ListNode;

/**
 * @Author: ouyangyameng
 * @Date: 2023/1/6 13:25
 * @Version 1.0
 */
public class M237DeleteNodeInALinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        deleteNode(head.next);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static void deleteNode(ListNode node) {
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}
