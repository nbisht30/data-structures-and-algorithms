package implementations.heaps.genericheap;

/**
 * @author Nikhil Bisht
 * @date 09-08-2020
 */
public class GenericClient {
    public static void main(String[] args) {
        GenericHeap<String> reverseLexiHeap = new GenericHeap<>();

        reverseLexiHeap.add("Nikhil");
        reverseLexiHeap.add("Titiksha");
        reverseLexiHeap.add("Ashish");
        reverseLexiHeap.add("Kartik");


        while (reverseLexiHeap.size() != 0) {
            System.out.println(reverseLexiHeap.delete());
        }
    }
}
