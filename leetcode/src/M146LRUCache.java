import sun.awt.image.ImageWatched;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/24 13:07
 * @Version 1.0
 */
public class M146LRUCache {
    public static void main(String[] args) {
        LRUCache lruCache = new M146LRUCache().new LRUCache(1);
        lruCache.put(1, 0);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }

    /**
     * map记录是否存在
     * 双向链表方便插入和删除操作。
     * head和tail都使用站位节点可以减少很多null值判断，整体逻辑看起来更加清晰
     */
    class LRUCache {
        Map<Integer, LinkedNode> lruCacheMap = new ConcurrentHashMap<>();
        LinkedNode head = new LinkedNode();
        LinkedNode tail = new LinkedNode();
        int length = 0;
        int capacity = 0;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        //
        public int get(int key) {
            if (lruCacheMap.containsKey(key)) {
                LinkedNode node = lruCacheMap.get(key);
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.prev = head;
                node.next = head.next;
                head.next.prev = node;
                head.next = node;
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (lruCacheMap.containsKey(key)) {
                lruCacheMap.get(key).value = value;
                get(key);
            } else if (length < capacity) {
                LinkedNode node = new LinkedNode(key, value);
                lruCacheMap.put(key, node);
                length++;
                node.prev = head;
                node.next = head.next;
                head.next.prev = node;
                head.next = node;
            } else {
                LinkedNode prev = tail.prev;
                lruCacheMap.remove(prev.key);
                length--;
                prev.prev.next = tail;
                tail.prev = prev.prev;
                prev.prev = null;
                prev.next = null;
                put(key, value);
            }
        }

        private class LinkedNode {
            int key;
            int value;
            LinkedNode prev;
            LinkedNode next;

            LinkedNode() {
            }

            LinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
