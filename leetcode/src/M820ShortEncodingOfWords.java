import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: ouyangyameng
 * @Date: 2022/6/21 09:43
 * @Version 1.0
 */
public class M820ShortEncodingOfWords {
    public static void main(String[] args) {
        System.out.println(new M820ShortEncodingOfWords().minimumLengthEncoding(new String[] {"time", "me", "bell"}));
    }
    public int minimumLengthEncoding(String[] words) {
        LinkedNode root = new LinkedNode();
        for (String word : words) {
            resloveLinkedNode(root, word.toCharArray());
        }
        return computeWordLength(root);
    }

    void resloveLinkedNode(LinkedNode node, char[] word) {
        for (int i = word.length - 1; i >= 0; i--) {
            if (node.linkedNodes[word[i] - 'a'] == null) {
                node.linkedNodes[word[i] - 'a'] = new LinkedNode();
                node.size++;
            }
            node = node.linkedNodes[word[i] - 'a'];
        }
    }

    int computeWordLength(LinkedNode root) {
        int deep = 1;
        int sum = 0;
        int num = 0;
        List<LinkedNode> dealList = Arrays.stream(root.linkedNodes).filter(Objects::nonNull).collect(Collectors.toList());
        while (dealList.size() > 0) {
            List<LinkedNode> next = new ArrayList<>();
            for (LinkedNode deal : dealList) {
                if (deal.size == 0) {
                    sum += deep;
                    num++;
                } else {
                    next.addAll(Arrays.stream(deal.linkedNodes).filter(Objects::nonNull).collect(Collectors.toList()));
                }
            }
            deep++;
            dealList = next;
        }
        return sum + num;
    }

    class LinkedNode {
        public int size = 0;
        public LinkedNode[] linkedNodes = new LinkedNode[26];

        public LinkedNode() {

        }
    }
}
