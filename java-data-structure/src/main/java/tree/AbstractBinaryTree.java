package tree;

public abstract class AbstractBinaryTree<T> {
    public int size=0;
    abstract void add(T data);

    public int size(){
        return this.size;
    }

    abstract boolean containsData(T data);

    abstract void delete(T data,TreeNode root);

    abstract void inOrderSearch();

    abstract void preOrderSearch();

    abstract void postOrderSearch();

    abstract int maxDepth(TreeNode root);
}
