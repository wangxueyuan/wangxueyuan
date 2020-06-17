package tree;

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

    public void add2(T data) {
        if (data == null) {
            return;
        }
        Comparable obj = (Comparable) data;
        TreeNode newNode = new TreeNode(obj);
        TreeNode dummy = this.root;

        if (this.root == null) {
            this.root = newNode;
            return;
        } else {
            while (dummy != null) {
                if (((Comparable) data).compareTo(dummy.data) > 0) {
                    if (dummy.right == null) {
                        dummy.right = newNode;
                        return;
                    }
                    dummy = dummy.right;
                } else {
                    if (dummy.left == null) {
                        dummy.left = newNode;
                        return;
                    }
                    dummy = dummy.left;

                }
            }
        }
        this.size++;
    }

    @Override
    boolean containsData(TreeNode treeRoot, T data) {
        if (data == null) {
            return false;
        }
        if (this.root == null) {
            return false;
        }

        while (treeRoot != null) {
            if (treeRoot.data.compareTo(data) > 0) {
                return containsData(treeRoot.left, data);
            } else if (treeRoot.data.compareTo(data) < 0) {
                return containsData(treeRoot.right, data);
            } else {
                return true;
            }
        }
        return false;
    }

    public void delete(T data) {
        TreeNode dummy = this.root;
        TreeNode dummy2 = null;
        while (dummy != null && dummy.data != data) {
            dummy2 = dummy;
            if (dummy.data.compareTo(data) < 0) {
                dummy = dummy.right;
            } else {
                dummy = dummy.left;
            }
        }
        if (dummy == null) {
            return;
        }
        if (dummy.left != null && dummy.right != null) {
            TreeNode minP = dummy.right;
            TreeNode minPP = dummy;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            dummy.data = minP.data;
            dummy=minP;
            dummy2 = minPP;
        }
        TreeNode child;
        if (dummy.left != null) {
            child = dummy.left;
        } else if (dummy.right != null) {
            child = dummy.right;
        } else {
            child = null;
        }
        if (dummy2 == null) {
            this.root = child;
        } else if (dummy2.left == dummy) {
            dummy2.left = child;
        } else {
            dummy2.right = child;
        }
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
    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return maxLeft >= maxRight ? maxLeft + 1 : maxRight + 1;
    }


    public void preOrderTreeNode2(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(String.format("preOrder->%s", root.data));
        preOrderTreeNode2(root.left);
        preOrderTreeNode2(root.right);
    }

    public void inOrderTreeNode2(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTreeNode2(root.left);
        System.out.println(String.format("inOrder->%s", root.data));
        inOrderTreeNode2(root.right);
    }

    public void postOrderTreeNode2(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTreeNode2(root.left);
        postOrderTreeNode2(root.right);
        System.out.println(String.format("postOrder->%s", root.data));
    }
}
