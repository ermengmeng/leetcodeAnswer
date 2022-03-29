import common.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: ouyangyameng
 * @Date: 2022/3/28 6:20 下午
 * @Version 1.0
 */
public class M105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        System.out.println(new M105ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(new int[]{1,2,3}, new int[]{3,2,1}));
    }

    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
    }
}
