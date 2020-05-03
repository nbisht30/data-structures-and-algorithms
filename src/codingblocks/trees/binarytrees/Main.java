package codingblocks.trees.binarytrees;

/**
 * @author Nikhil Bisht
 * @date 29-03-2020
 */
public class Main {
    public static void main(String[] args) {
        BinaryTree btree = new BinaryTree();
        System.out.println("Display:-");
        btree.display();
        System.out.println("Height:-");
        System.out.println(btree.heightOfTree());
        System.out.println("Pre order:-");
        btree.preOrderTraversal();
        System.out.println("Inorder:-");
        btree.inorderTraversal();
        System.out.println("Post order:-");
        btree.postOrderTraversal();
        System.out.println("Level order:-");
        btree.levelOrderTraversal();
    }
}
/*
Input:-
Enter data for root node:
50
true
25
true
38
false
false
true
48
true
18
false
false
false
true
45
true
85
false
false
true
60
false
false
 */