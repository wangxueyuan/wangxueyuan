package tree;

public abstract class AbstractBinaryTree<T> {
    public int size=0;
    abstract void add(T data);

    public int size(){
        return this.size;
    }

    abstract boolean containsData(TreeNode root,T data);

    abstract int maxDepth(TreeNode root);
}
