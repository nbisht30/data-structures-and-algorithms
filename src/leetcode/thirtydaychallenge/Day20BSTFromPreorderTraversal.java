package leetcode.thirtydaychallenge;

/**
 * @author Nikhil Bisht
 * @date 07-05-2020
 */
public class Day20BSTFromPreorderTraversal {
    // Construct BST from preorder traversal
    public Node bstFromPreorder(int[] preorder) {
        return helper(preorder, new int[]{0}, Integer.MAX_VALUE);
    }


    /*
    Intuition:-

    https://www.youtube.com/watch?v=RyAGEb4VWo0

    Eg. if the preorder is [8, 5, 1, 7, 10, 12] then 8 is surely the root element.

    Now you need to put everything to the left of 8 till you encounter an element that is greater than 8 i.e 10.
    And after that everything is to be put to the right of 8.

    So, root.left = i+1th element if it is lower than roots value
    and root.right = i+1th element if it is higher than the roots value and less than the max limit.

    Same process repeats for all the subtrees under root.

    Note: Using array, i[] to store the index because I need a reference variable here. So that we
    get the value in every recursive call.


     */
    private Node helper(int[] preorder, int i[], int limit) {
        if (i[0] == preorder.length || preorder[i[0]] > limit) return null;
        int rootval = preorder[i[0]];

        Node root = new Node();
        root.data = rootval;

        i[0]++;

        root.left = helper(preorder, i, rootval);
        root.right = helper(preorder, i, limit);
        return root;
    }

    public class Node {
        int data;
        Node left;
        Node right;
    }
}
