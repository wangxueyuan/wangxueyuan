package tree;

public class BTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree();
        binaryTree.add(11);
        binaryTree.add(8);
        binaryTree.add(2);
        binaryTree.add(12);
        binaryTree.add(7);
        binaryTree.add(8);
        System.out.println(binaryTree.inOrderSearch(binaryTree.root));
        System.out.println(binaryTree.maxDepth(binaryTree.root));

        binaryTree.delete(12,binaryTree.root);
        binaryTree.inOrderSearch();
    }
}
