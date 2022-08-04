import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ouyangyameng
 * @Date: 2022/8/4 09:55
 * @Version 1.0
 */
public class M208ImplementTrie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("jam");
        trie.insert("can");
        System.out.println(trie.startsWith("jan"));
    }

    /**
     * 简单的前缀树，使用bitmap+set分别实现查询和前缀查询的功能
     */
    static class Trie {
        Node root;
        Set<String> wordSet;

        public Trie() {
            wordSet = new HashSet<>();
            root = new Node();
        }

        public void insert(String word) {
            if (!wordSet.contains(word)) {
                wordSet.add(word);
                addTree(root, word, 0);
            }
        }

        private void addTree(Node node, String word, int index) {
            if (index >= word.length()) {
                return;
            }
            int cur = word.charAt(index) - 'a';
            node.bitmap |= (1 << cur);
            if (node.next[cur] == null) {
                node.next[cur] = new Node();
            }
            addTree(node.next[cur], word, index + 1);
        }

        public boolean search(String word) {
            return wordSet.contains(word);
        }

        public boolean startsWith(String prefix) {
            return searchWithTree(root, prefix, 0);
        }

        private boolean searchWithTree(Node node, String word, int index) {
            if (index >= word.length()) {
                return true;
            }
            int cur = word.charAt(index) - 'a';
            if (node == null || (node.bitmap & (1 << cur)) == 0) {
                return false;
            }
            return searchWithTree(node.next[cur], word, index + 1);
        }

        class Node {
            int bitmap;
            Node[] next;

            public Node() {
                next = new Node[26];
            }
        }
    }
}
