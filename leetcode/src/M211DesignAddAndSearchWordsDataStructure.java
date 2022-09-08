import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/9/8 11:13
 * @Version 1.0
 */
public class M211DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("at");
        wd.addWord("and");
        wd.addWord("an");
        wd.addWord("add");
        System.out.println(wd.search("a"));
        System.out.println(wd.search(".at"));
        wd.addWord("bat");
        System.out.println(wd.search(".at"));
        System.out.println(wd.search("an."));
        System.out.println(wd.search("a.d."));
        System.out.println(wd.search("a.d"));
        System.out.println(wd.search("."));
    }

    /**
     * 一般在存在解的问题中,优先使用dfs可以有效进行剪枝
     * 在遍历解时，使用bfs可以减少重复的处理量
     */
    static class WordDictionary {

        private TrieTreeNode root;

        public WordDictionary() {
            root = new TrieTreeNode('0');
        }

        public void addWord(String word) {
            if (word == null) {
                return;
            }
            char[] chars = word.toCharArray();
            TrieTreeNode cur = root;
            for (char c : chars) {
                if (!cur.hasNext(c)) {
                    cur.setNext(c);
                }
                cur = cur.getNext(c);
            }
            cur.setNext('{');
        }

        public boolean search(String word) {
            if (word == null) {
                return false;
            }
            char[] chars = word.toCharArray();
            List<TrieTreeNode> cur = new ArrayList<>();
            cur.add(root);
            return search(chars, 0, root);
        }

        private boolean search(char[] chars, int index, TrieTreeNode node) {
            if (node == null) {
                return false;
            }
            if (index == chars.length) {
                return node.hasNext('{');
            }
            char c = chars[index];
            if (c == '.') {
                if (node.next == null) {
                    return false;
                }
                for (int i = 0; i < 26; i++) {
                    if (node.next[i] != null) {
                        if (search(chars, index + 1, node.next[i])) {
                            return true;
                        }
                    }
                }
            } else {
                return search(chars, index + 1, node.getNext(c));
            }
            return false;
        }

        private class TrieTreeNode {
            private char c;
            private TrieTreeNode[] next;

            public TrieTreeNode[] getNext() {
                return next;
            }

            public TrieTreeNode(char c) {
                this.c = c;
            }

            public boolean hasNext(char c) {
                if (next == null) {
                    return false;
                }
                return next[c - 'a'] != null;
            }

            public TrieTreeNode getNext(char c) {
                if (next == null) {
                    return null;
                }
                return next[c - 'a'];
            }

            public void setNext(char c) {
                if (next == null) {
                    next = new TrieTreeNode[27];
                }
                next[c - 'a'] = new TrieTreeNode(c);
            }
        }
    }
}
