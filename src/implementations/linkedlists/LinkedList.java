package implementations.linkedlists;

public class LinkedList<T> {
    public int size;
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    // inserts at the beginning of the list: O(1)
    public void addFirst(T item) {
        Node node = new Node(item, this.head);
        this.head = node;
        if (this.isEmpty()) {
            this.tail = node;
        }
        this.size++;
    }

    // inserts at end: O(n)
    public void addLast(T item) {
        Node node = new Node(item, null);
        if (this.isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    public T getFirst() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }
        return this.head.data;
    }

    public T getLast() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("List is empty");
        }
        return this.tail.data;
    }

    private Node getNodeAt(int index) throws Exception {
        if (this.size == 0) throw new Exception("Linked List is empty.");

        if (index < 0 || index >= this.size) throw new Exception("Index out of bounds.");

        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public T getDataAt(int index) throws Exception {
        return getNodeAt(index).data;
    }

    public void display() {
        Node temp = this.head;
        String delimeter = "";
        StringBuilder sb = new StringBuilder();
        while (temp != null) {
            sb.append(delimeter);
            delimeter = " -> ";
            sb.append(temp.data);
            temp = temp.next;
        }
        System.out.println(sb);
    }

    public T removeFirst() throws Exception {
        T data;
        if (this.size != 0) {
            data = this.head.data;
            this.head = this.head.next;
            if (this.size == 1) this.tail = null;
            this.size--;
        } else throw new Exception("No data present in the list to remove.");
        return data;
    }

    public T removeLast() throws Exception {
        T data;
        if (this.size == 0) {
            throw new Exception("No data present in the list to remove.");
        } else if (this.size == 1) {
            data = this.head.data;
            this.head = this.tail = null;
            this.size = 0;
        } else {
            data = this.tail.data;
            Node temp = getNodeAt(this.size - 2);
            this.tail = temp;
            this.tail.next = null;
            this.size--;
        }
        return data;
    }

    public T removeAt(int index) throws Exception {
        T data;
        if (this.size == 0) {
            throw new Exception("No data present in the list to remove.");
        }

        if (index >= this.size || index < 0) {
            throw new Exception("Invalid index.");
        }

        if (index == 0) return removeFirst();
        else if (index == this.size - 1) return removeLast();
        else {
            Node temp = getNodeAt(index - 1);
            Node toAppened = temp.next.next;
            data = temp.next.data;
            temp.next = toAppened;
            this.size--;
        }
        return data;
    }

    private class Node {
        public T data;
        public Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public void displayNode() {
            System.out.println("{" + data + "}");
        }
    }
}