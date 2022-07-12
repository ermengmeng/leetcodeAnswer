import java.util.*;

/**
 * @Author: ouyangyameng
 * @Date: 2022/7/11 09:52
 * @Version 1.0
 */
public class M187RepeatedDNASequences {
    public static void main(String[] args) {
        System.out.println(new M187RepeatedDNASequences().findRepeatedDnaSequences("AAAAAAAAAAA"));
        System.out.println(new M187RepeatedDNASequences().findRepeatedDnaSequences2("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    /**
     * 循环滚动sb,并记录所有的子序列。
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences2(String s) {
        Set<String> res = new HashSet<>();
        if(s.length() < 11)
            return new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Set<String> mp = new HashSet<>();

        for(int i = 0; i < 10; i++){
            sb.append(s.charAt(i));
        }
        mp.add(sb.toString());
        for(int i = 10; i < s.length(); i++){
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            String temp = sb.toString();
            if(mp.contains(temp)){
                res.add(temp);
            }else{
                mp.add(temp);
            }
        }
        return new ArrayList<>(res);
    }


    /**
     * 构造路径搜索树
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        char[] array = s.toCharArray();
        LinkedTree[] curNode = new LinkedTree[1];
        Set<String> res = new HashSet<>();
        LinkedTree root = new LinkedTree("", ' ');
        for (int i = 0; i <= array.length - 10; i++) {
            curNode[0] = root;
            for (int j = 0; j < 10; j++) {
                String r = gen(array, i, j, curNode);
                if (r != null) {
                    res.add(r);
                }
            }
        }
        return new ArrayList<>(res);
    }

    private String gen(char[] array, int index, int site, LinkedTree[] treeArray) {
        char cur = array[index + site];
        LinkedTree tree = treeArray[0];
        boolean res = tree.addNext(cur);
        if (site == 9) {
            return res ? tree.str + cur : null;
        } else {
            treeArray[0] = tree.getNext(cur);
        }
        return null;
    }

    class LinkedTree {
        String str;
        char c;
        LinkedTree[] nextNode = new LinkedTree[4];

        public LinkedTree(String str, char c) {
            this.str = str;
            this.c = c;
        }

        public LinkedTree getNext(char c) {
            switch (c) {
                case 'A':
                    return nextNode[0];
                case 'C':
                    return nextNode[1];
                case 'G':
                    return nextNode[2];
                case 'T':
                    return nextNode[3];
            }
            return null;
        }

        public boolean addNext(char c) {
            boolean res = false;
            switch (c) {
                case 'A':
                    res = dealAdd(0, c);
                    break;
                case 'C':
                    res = dealAdd(1, c);
                    break;
                case 'G':
                    res = dealAdd(2, c);
                    break;
                case 'T':
                    res = dealAdd(3, c);
                    break;
            }
            return res;
        }

        private boolean dealAdd(int site, char c) {
            if (nextNode[site] == null) {
                nextNode[site] = new LinkedTree(str + c, c);
                return false;
            } else {
                return true;
            }
        }
    }
}
