package codingblocks.trees.bst;

/**
 * @author Nikhil Bisht
 * @date 03-05-2020
 */
public class Main {
    public static void main(String[] args) {
//        BST binarySearchTree = new BST(new int[]{40, 40, 50});
        BST binarySearchTree = new BST(new int[]{10, 20, 30, 40, 50, 60, 70});
        binarySearchTree.displayBST();
        binarySearchTree.findItem(70);
        binarySearchTree.maxInBst();
        binarySearchTree.add(80);
        binarySearchTree.add(5);
        binarySearchTree.add(55);
        binarySearchTree.displayBST();
    }

}
