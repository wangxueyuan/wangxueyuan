package tree;

/**
 * @Author: Wang X.Y.
 * @CreateTime: 9/7/2020 15:53
 * @Version: 1.0
 **/
public class MirrorTree {
    public static void mirrorNode(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            return;
        }

        TreeNode tmp = left;
        left = right;
        right = tmp;
        while (left != null) {
            mirrorNode(left);
        }
        if (right != null) {
            mirrorNode(right);
        }
    }
}
