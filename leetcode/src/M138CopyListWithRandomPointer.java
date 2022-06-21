import common.RandomNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/21 18:35
 * @Version 1.0
 */
public class M138CopyListWithRandomPointer {
    public RandomNode copyRandomList(RandomNode head) {
        if (head == null) return null;
        Map<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode cur = head;
        RandomNode root = new RandomNode(cur.val);
        RandomNode resCur = root;
        map.put(head, root);
        while(cur.next != null) {
            resCur.next = new RandomNode(cur.next.val);
            map.put(cur.next, resCur.next);
            cur = cur.next;
            resCur = resCur.next;
        }
        cur = head;
        resCur = root;
        while(cur != null) {
            if (cur.random != null) {
                resCur.random = map.get(cur.random);
            }
            cur = cur.next;
            resCur = resCur.next;
        }
        return root;
    }
}
