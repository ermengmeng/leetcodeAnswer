import common.TreeNode;

/**
 * @Author: ouyangyameng
 * @Date: 2022/9/9 17:26
 * @Version 1.0
 */
public class M230KthSmallestElementInABST {

    /**
     * 构造查询子树节点的递归函数,并在其中传参返回和第k小的数。
     * 在右子树查询是通过k-左子树数量-root(1)查询
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        int[] kth = new int[1];
        subTreeCount(root, kth, k - 1);
        return kth[0];
    }

    public int subTreeCount(TreeNode root, int[] kth, int count) {
        if (root == null) {
            return 0;
        }
        int left = subTreeCount(root.left, kth, count);
        if (left == count) {
            kth[0] = root.val;
        }
        int right = subTreeCount(root.right, kth, count - left - 1);
        return right + left + 1;
    }

    public static void main(String[] args) throws Throwable {
        while (true) {
            Thread.sleep(1000);
        }
    }
}
