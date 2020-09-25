package implementations.heaps;

/**
 * @author Nikhil Bisht
 * @date 30-07-2020
 */
public class Main {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.add(10);
        heap.display();
        heap.add(20);
        heap.display();
        heap.add(30);
        heap.display();
        heap.add(40);
        heap.display();
        heap.add(5);
        heap.display();
        heap.add(3);
        heap.display();
//        heap.add(1);
//        heap.display();
        System.out.println(heap.delete() + " deleted!");
        heap.display();
        System.out.println(heap.delete() + " deleted!");
        heap.display();
        System.out.println(heap.delete() + " deleted!");
        heap.display();
        System.out.println(heap.delete() + " deleted!");
        heap.display();
    }
}
