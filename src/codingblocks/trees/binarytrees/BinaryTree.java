package codingblocks.trees.binarytrees;

import java.util.Scanner;

/**
 * @author Nikhil Bisht
 * @date 11-04-2020
 */
public class BinaryTree {
    private Node root;
    private int size; //Total number of nodes in the tree.

    BinaryTree() {
        this.size = 0;
        Scanner in = new Scanner(System.in);
        this.root = buildBinaryTree(null, in, false);
    }

    private Node buildBinaryTree(Node parent, Scanner in, boolean isLeft) {
        if (parent == null) {
            System.out.println("Enter data for root node: ");
        } else {
            if (isLeft) {
                System.out.println("Enter data for the left child of parent: " + parent.data);

            } else {
                System.out.println("Enter data for the right child of parent: " + parent.data);
            }
        }
        int data = in.nextInt();
        Node temp = new Node(data, null, null);

        System.out.println("Do you have a left child for this parent: " + data + "?");
        boolean choice = in.nextBoolean();
        if (choice) temp.left = buildBinaryTree(temp, in, true);
        System.out.println("Do you have a right child for this parent: " + data + "?");
        choice = in.nextBoolean();
        if (choice) temp.right = buildBinaryTree(temp, in, false);
        return temp;
    }

    public void display(){
        displayTree(root);
    }

    private void displayTree(Node node) {
        if(node == null){
            return;
        }
        System.out.print(node.data + " => ");
        if(node.left!=null){
            System.out.print(node.left.data+",");
        }
        if(node.right!=null){
            System.out.print(node.right.data+",");
        }
        System.out.println("END");
        displayTree(node.left);
        displayTree(node.right);
    }

    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
