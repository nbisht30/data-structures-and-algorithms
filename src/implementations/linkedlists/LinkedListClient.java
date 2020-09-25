package implementations.linkedlists;

/**
 * @author Nikhil Bisht
 * @date 08-05-2020
 */
public class LinkedListClient {
    public static void main(String[] args) {
        LinkedList<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.addLast("Nikhil");
        stringLinkedList.addLast(" is");
        stringLinkedList.addLast(" learning");
        stringLinkedList.addLast(" data");
        stringLinkedList.addLast(" structures");
        stringLinkedList.display();

        LinkedList<Integer> integerLL = new LinkedList<>();
        integerLL.addLast(1);
        integerLL.addLast(11);
        integerLL.addLast(111);
        integerLL.addLast(1111);
        integerLL.addLast(11111);
        integerLL.addLast(111111);
        integerLL.display();
        try {
            System.out.println("First: " + integerLL.getFirst());
            System.out.println("Last: " + integerLL.getLast());
            System.out.println("Data at index 0: " + integerLL.getDataAt(0));
            int i = 1;
            while (i != 0) {
                i--;
                integerLL.removeFirst();
                System.out.println("Removed first element");
            }
            integerLL.display();
            integerLL.removeLast();
            System.out.println("Removed last element.");
            integerLL.display();
            System.out.println("Last: " + integerLL.getLast());
            System.out.println("Removing 2nd element: "+ integerLL.removeAt(1));
            integerLL.display();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
