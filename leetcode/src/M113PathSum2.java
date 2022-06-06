import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ouyangyameng
 * @Date: 2022/4/26 9:55 上午
 * @Version 1.0
 */
public class M113PathSum2 {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return ans;
        }
        LinkedList<Integer> cur = new LinkedList<>();
        cur.add(root.val);
        pathSum(root, targetSum,root.val, cur);
        return ans;
    }

    public void pathSum(TreeNode root, int targetSum, int curSum, LinkedList<Integer> cur) {
        if (root.right == null && root.left == null && targetSum == curSum) {
            ans.add(new ArrayList<>(cur));
        }
        if (root.left != null) {
            cur.add(root.left.val);
            pathSum(root.left, targetSum, curSum + root.left.val, cur);
            cur.removeLast();
        }
        if (root.right != null) {
            cur.add(root.right.val);
            pathSum(root.right, targetSum, curSum + root.right.val, cur);
            cur.removeLast();
        }
    }
}
