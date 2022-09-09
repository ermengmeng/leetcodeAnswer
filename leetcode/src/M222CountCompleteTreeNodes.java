import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/9/9 10:45
 * @Version 1.0
 */
public class M222CountCompleteTreeNodes {
    //直接层次遍历，简单好用。
    //使用每层满元素数作为退出条件。
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> levelList = new ArrayList<>();
        levelList.add(root);
        int count = 1;
        int completeSize = 2;
        levelList = computeLevel(levelList);
        while (levelList.size() == completeSize) {
            count += completeSize;
            completeSize = completeSize << 1;
            levelList = computeLevel(levelList);
        }
        count += levelList.size();
        return count;
    }

    private List<TreeNode> computeLevel(List<TreeNode> list) {
        List<TreeNode> res = new ArrayList<>();
        for (TreeNode node : list) {
            if (node.right != null) {
                res.add(node.right);
            }
            if (node.left != null) {
                res.add(node.left);
            }
        }
        return res;
    }


    //计算最右深度得到满层深度
    //自右向左深度遍历,统计学上的复杂度会低一些。
    //满二叉树时为o(n)。
    //空最右元素时最优为o(log(n))
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int completeLevel = computeLevel(root);
        int count = 1 << completeLevel - 1;
        int[] empty = new int[]{0};
        computeEmptyCount(root, 1, completeLevel + 1, empty);
        count += (1 << completeLevel) - empty[0];
        return count;
    }

    private int computeLevel(TreeNode root) {
        int i = 1;
        while (root.right != null) {
            i++;
            root = root.right;
        }
        return i;
    }

    private boolean computeEmptyCount(TreeNode cur, int curLevel, int level, int[] empty) {
        if (curLevel == level && cur == null) {
            empty[0] = empty[0] + 1;
            return false;
        }
        if (curLevel == level && cur != null) {
            return true;
        }
        if (computeEmptyCount(cur.right, curLevel + 1, level, empty)) {
            return true;
        }
        if (computeEmptyCount(cur.left, curLevel + 1, level, empty)) {
            return true;
        }
        return false;
    }
}
