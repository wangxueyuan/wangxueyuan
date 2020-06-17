package tree;

public class BTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree();
        binaryTree.add2(33);
        binaryTree.add2(16);
        binaryTree.add2(13);
        binaryTree.add2(15);
        binaryTree.add2(18);
        binaryTree.add2(17);
        binaryTree.add2(25);
        binaryTree.add2(19);
        binaryTree.add2(27);
        System.out.println(binaryTree.maxDepth(binaryTree.root));
        binaryTree.inOrderTreeNode2(binaryTree.root);
        System.out.println(binaryTree.containsData(binaryTree.root,2));
        binaryTree.delete(18);
        binaryTree.inOrderTreeNode2(binaryTree.root);
    }
}
