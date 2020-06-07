package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> extends AbstractBinaryTree<T> {
    TreeNode root;

    @Override
    public void add(T data) {
        if (data == null) {
            return;
        }
        Comparable obj = (Comparable) data;
        TreeNode newNode = new TreeNode(obj);
        if (this.root == null) {
            this.root = newNode;
        } else {
            this.root.addNode(newNode);
        }
        this.size++;
    }

    @Override
    boolean containsData(T data) {
        if (data == null) {
            return false;
        }
        if (this.root == null || this.size() == 0) {
            return false;
        }
        TreeNode tNode = new TreeNode((Comparable) data);
        return this.root.containsTreeNode(tNode);
    }

    @Override
    public void delete(T data,TreeNode root) {
        if (size() == 0 || root == null) {
            return;
        }
        if (containsData(data)) {
            this.root.removeNode(data);
        }
    }

    @Override
    void inOrderSearch() {
        if (this.root == null) {
            return;
        }
        this.root.inOrderTreeNode();
    }

    void preOrderSearch(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode curNode = root;
        System.out.println(String.format("preOrder->%s", curNode.data));
        if (curNode.left != null) {
            preOrderSearch(curNode.left);
        }
        if (curNode.right != null) {
            preOrderSearch(curNode.right);
        }
    }

    @Override
    void preOrderSearch() {
        if (this.root == null) {
            return;
        }
        this.root.preOrderTreeNode();
    }

    @Override
    void postOrderSearch() {
        if (this.root == null) {
            return;
        }
        this.root.postOrderTreeNode();
    }

    @Override
    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return maxLeft >= maxRight ? maxLeft + 1 : maxRight + 1;
    }

    List inOrderSearch(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            inOrderSearch(root.left);
        }
        list.add((Integer) root.data);
        if (root.right != null) {
            inOrderSearch(root.right);
        }
        return list;
    }
}
