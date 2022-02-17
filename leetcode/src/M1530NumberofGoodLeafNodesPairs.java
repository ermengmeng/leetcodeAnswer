import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: ouyangyameng
 * @Date: 2021/5/21 1:54 下午
 * @Version 1.0
 */
public class M1530NumberofGoodLeafNodesPairs {
    public static void main(String[] args) {
        M1530NumberofGoodLeafNodesPairs o = new M1530NumberofGoodLeafNodesPairs();
    }


    Map<TreeNode, List<List<Integer>>> cacheMap = new HashMap<>();
    public int countPairs(TreeNode root, int distance) {
        computeDistance(root, distance);
        int pairSum = 0;
        for (List<List<Integer>> list : cacheMap.values()) {
            if (list.size() == 1) {
                continue;
            }
            for (int i = 0; i< list.get(0).size(); i++) {
                for (int j = 0; j < list.get(1).size(); j++) {
                    if (list.get(0).get(i) + list.get(1).get(j) <= distance) {
                        pairSum++;
                    }
                }
            }
        }
        return pairSum;
    }

    private List<Integer> computeDistance(TreeNode cur, int distance) {
        if (cur.left == null && cur.right == null) {
            return Arrays.asList(0);
        }
        List<Integer> list = new ArrayList<>();
        if (cur.left != null) {
            List<Integer> leftList = computeDistance(cur.left, distance);
            leftList = leftList.stream().map(i -> i+1).filter(d -> d < distance).collect(Collectors.toList());
            List<List<Integer>> cacheList = cacheMap.getOrDefault(cur, new ArrayList<>());
            cacheList.add(leftList);
            cacheMap.put(cur, cacheList);
            list.addAll(leftList);
        }
        if (cur.right != null) {
            List<Integer> rightList = computeDistance(cur.right, distance);
            rightList = rightList.stream().map(i -> i+1).filter(d -> d < distance).collect(Collectors.toList());
            List<List<Integer>> cacheList = cacheMap.getOrDefault(cur, new ArrayList<>());
            cacheList.add(rightList);
            cacheMap.put(cur, cacheList);
            list.addAll(rightList);
        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
