package tree;

public class TreeNode<T> {
    TreeNode left;
    TreeNode right;
    Comparable<T> data;//一定是继承Comparable的数据，代表可比较

    public TreeNode(Comparable<T> data) {
        this.data = data;
    }

    void addNode(TreeNode newNode) {
        if (this.data.compareTo((T) newNode.data) <= 0) {
            if (this.right == null) {
                this.right = newNode;
            } else {
                this.right.addNode(newNode);
            }
        } else {
            if (this.left == null) {
                this.left = newNode;
            } else {
                this.left.addNode(newNode);
            }
        }
    }

    public boolean containsTreeNode(TreeNode tNode) {
        if (this.data.equals(tNode.data)) {
            return true;
        } else if (this.data.compareTo((T) tNode.data) > 0) {
            if (this.left == null) {
                return false;
            }else {
                return this.left.containsTreeNode(this.left);
            }
        }else {
            if (this.right == null) {
                return false;
            }else{
                return this.right.containsTreeNode(this.right);
            }
        }
    }

    public void preOrderTreeNode() {
        TreeNode curNode=this;
        System.out.println(String.format("preOrder->%s", curNode.data));
        if (curNode.left != null) {
            curNode.left.preOrderTreeNode();
        }
        if (curNode.right != null) {
            curNode.right.preOrderTreeNode();
        }
    }



    public void postOrderTreeNode() {
        TreeNode curNode=this;
        if (curNode.left != null) {
            curNode.left.postOrderTreeNode();
        }
        if (curNode.right != null) {
            curNode.right.postOrderTreeNode();
        }
        System.out.println(String.format("postOrder->%s", curNode.data));
    }

    public void postOrderTreeNode2(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTreeNode2(root.left);
        postOrderTreeNode2(root.right);
        System.out.println(String.format("postOrder->%s", root.data));
    }

    public void inOrderTreeNode() {
        TreeNode curNode=this;
        if (curNode.left != null) {
            curNode.left.inOrderTreeNode();
        }
        System.out.println(String.format("inOrder->%s", curNode.data));
        if (curNode.right != null) {
            curNode.right.inOrderTreeNode();
        }
    }



    public TreeNode getRemoveNode(T data) {
        if (this.data.compareTo(data) == 0) {
            return this;
        }else {
            if (this.data.compareTo(data) < 0) {
                return this.right.getRemoveNode(data);
            }else{
                return this.left.getRemoveNode(data);
            }
        }
    }

}
