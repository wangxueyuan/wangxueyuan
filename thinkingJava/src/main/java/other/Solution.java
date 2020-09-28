package other;

import java.util.Arrays;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 8/28/2020 21:10
 * @Version: 1.0
 **/

//Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] mid) {
        if (pre.length == 0) {
            return null;
        }
        if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }

        int rootIndex = 0;
        int rootVal = pre[0];
        TreeNode root = new TreeNode(rootVal);

        for (int i = 0; i < mid.length; i++) {
            if (rootVal == mid[i]) {
                rootIndex = i;
                break;
            }
        }
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootIndex + 1), Arrays.copyOfRange(mid, 0,
                rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootIndex + 1, pre.length), Arrays.copyOfRange(mid
                , rootIndex + 1, mid.length));
        return root;
    }


    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 3, 5, 6};
        int[] mid = {4, 2, 1, 5, 3, 6};
        reConstructBinaryTree(pre, mid);
    }
}
