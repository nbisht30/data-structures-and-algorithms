package codingblocks.trees.generictrees;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nikhil Bisht
 * @date 05-03-2020
 */
public class GenericTree {
    private Node root;
    private int size;

    GenericTree() {
        Scanner s = new Scanner(System.in);
        this.root = takeInput(s, null, 0);
    }

    //to take input of the generic tree
    private Node takeInput(Scanner s, Node parent, int ithChild) {
        if (parent == null) {
            System.out.println("Enter the data for root: ");
        } else {
            System.out.println("Enter data for " + ithChild + "th child of parent: " + parent.data);
        }
        int nodeData = s.nextInt();
        Node node = new Node(nodeData);

        System.out.println("Enter the number of children for " + node.data);
        int children = s.nextInt();

        for (int i = 0; i < children; i++) {
            Node child = takeInput(s, node, i);
            node.children.add(child);
        }
        return node;
    }

    public void displayTree() {
        Node node = root;
        displayTreeChildren(node);
    }

    private void displayTreeChildren(Node node) {
        if (node.children == null) {
            return;
        } else {
            System.out.print(node.data + " =>");
            node.children.forEach(child -> {
                System.out.print(child.data + ",");
            });
            System.out.println("END");

            node.children.forEach(child -> {
                displayTreeChildren(child);
            });
        }
    }

    private class Node {
        int data;
        ArrayList<Node> children;

        Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }
}


// Input: 60 3 41 2 17 0 16 0 15 1 21 0 24 2 33 0 84 0