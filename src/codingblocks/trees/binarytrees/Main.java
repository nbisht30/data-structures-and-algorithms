package codingblocks.trees.binarytrees;

/**
 * @author Nikhil Bisht
 * @date 29-03-2020
 */
public class Main {
    public static void main(String[] args) {
/*        BinaryTree btree = new BinaryTree();
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
        btree.levelOrderTraversal();*/


/*        BinaryTree diaTree = new BinaryTree();
        System.out.println(diaTree.getDiameter());*/

        BinaryTree cousins = new BinaryTree();
        System.out.println(cousins.isCousins(4,5));


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

/*
For cousins in a tree:-

1
true
2
false
true
4
false
false
true
3
false
true
5
false
false
 */

/*
For diameter of a tree: https://drive.google.com/open?id=1HhgOf-eApP4XvMYTOD-sXfr8a_NFtPHK (image of the tree)

Enter data for root node:
1
Do you have a left child for this parent: 1?
true
Enter data for the left child of parent: 1
2
Do you have a left child for this parent: 2?
true
Enter data for the left child of parent: 2
4
Do you have a left child for this parent: 4?
true
Enter data for the left child of parent: 4
12
Do you have a left child for this parent: 12?
true
Enter data for the left child of parent: 12
13
Do you have a left child for this parent: 13?
true
Enter data for the left child of parent: 13
14
Do you have a left child for this parent: 14?
true
Enter data for the left child of parent: 14
19
Do you have a left child for this parent: 19?
false
Do you have a right child for this parent: 19?
false
Do you have a right child for this parent: 14?
false
Do you have a right child for this parent: 13?
false
Do you have a right child for this parent: 12?
false
Do you have a right child for this parent: 4?
false
Do you have a right child for this parent: 2?
true
Enter data for the right child of parent: 2
5
Do you have a left child for this parent: 5?
true
Enter data for the left child of parent: 5
6
Do you have a left child for this parent: 6?
true
Enter data for the left child of parent: 6
8
Do you have a left child for this parent: 8?
true
Enter data for the left child of parent: 8
10
Do you have a left child for this parent: 10?
false
Do you have a right child for this parent: 10?
false
Do you have a right child for this parent: 8?
true
Enter data for the right child of parent: 8
11
Do you have a left child for this parent: 11?
false
Do you have a right child for this parent: 11?
false
Do you have a right child for this parent: 6?
true
Enter data for the right child of parent: 6
9
Do you have a left child for this parent: 9?
true
Enter data for the left child of parent: 9
15
Do you have a left child for this parent: 15?
true
Enter data for the left child of parent: 15
18
Do you have a left child for this parent: 18?
false
Do you have a right child for this parent: 18?
false
Do you have a right child for this parent: 15?
false
Do you have a right child for this parent: 9?
true
Enter data for the right child of parent: 9
16
Do you have a left child for this parent: 16?
false
Do you have a right child for this parent: 16?
false
Do you have a right child for this parent: 5?
true
Enter data for the right child of parent: 5
7
Do you have a left child for this parent: 7?
false
Do you have a right child for this parent: 7?
false
Do you have a right child for this parent: 1?
true
Enter data for the right child of parent: 1
3
Do you have a left child for this parent: 3?
false
Do you have a right child for this parent: 3?
true
Enter data for the right child of parent: 3
17
Do you have a left child for this parent: 17?
false
Do you have a right child for this parent: 17?
false
 */