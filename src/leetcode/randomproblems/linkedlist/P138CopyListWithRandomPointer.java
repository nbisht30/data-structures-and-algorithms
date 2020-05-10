package leetcode.randomproblems.linkedlist;

// LC: https://leetcode.com/problems/copy-list-with-random-pointer/

import java.util.HashMap;

class P138CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Integer> mainListRefIndexMap = new HashMap<>();
        HashMap<Integer, Node> copyListIndexRefMap = new HashMap<>();
        HashMap<Integer, Node> mainListIndexRandomMap = new HashMap<>();

        Node copyHead = new Node(0);
        Node copyTail = copyHead;

        int ind = 1;
        while (head != null) {
            mainListIndexRandomMap.put(ind, head.random);// keeping address of random for each index
            mainListRefIndexMap.put(head, ind); //keeping index of each node
            Node temp = new Node(head.val);
            copyListIndexRefMap.put(ind, temp);//keeping address of each index of new copied list
            copyTail.next = temp;
            copyTail = copyTail.next;
            head = head.next;
            ind++;
        }

        copyHead = copyHead.next;

        Node itr = copyHead;

        ind = 1;
        while (itr != null) {
            Node randNodeAddrMain = mainListIndexRandomMap.get(ind);
            if (randNodeAddrMain == null) itr.random = null;
            else {
                int indexInMainList = mainListRefIndexMap.get(randNodeAddrMain);
                itr.random = copyListIndexRefMap.get(indexInMainList);
            }
            itr = itr.next;
            ind++;
        }

        return copyHead;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}