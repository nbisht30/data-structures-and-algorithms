package implementations.tries;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Nikhil Bisht
 * @date 09-06-2020
 */
public class HuffmanEncoderDecoder {
    private HashMap<Character, String> encoder;
    private HashMap<String, Character> decoder;

    public HuffmanEncoderDecoder(String feeder) {
        HashMap<Character, Integer> freq = new HashMap<>();
        // Counting frequency
        for (int i = 0; i < feeder.length(); i++) {
            freq.put(feeder.charAt(i), freq.getOrDefault(feeder.charAt(i), 0) + 1);
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();

        // Filling the min heap
        for (Map.Entry<Character, Integer> entry : entrySet) {
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.add(node);
        }

        // Creating tree from minheap
        while (minHeap.size() > 1) {
            Node minOne = minHeap.poll();
            Node minTwo = minHeap.poll();

            Node combined = new Node(minOne, minTwo);
            minHeap.add(combined);
        }
        Node treeRoot = minHeap.poll();

        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        initEncoderDecoder(treeRoot, "");
    }

    private void initEncoderDecoder(Node node, String outputSoFar) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            this.encoder.put(node.data, outputSoFar);
            this.decoder.put(outputSoFar, node.data);
        }
        this.initEncoderDecoder(node.left, outputSoFar + "0");
        this.initEncoderDecoder(node.right, outputSoFar + "1");
    }

    public String encode(String source) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            String code = this.encoder.get(source.charAt(i));
            sb.append(code);
        }
        return sb.toString();
    }

    public String decode(String codedString) {
        StringBuilder sb = new StringBuilder();
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < codedString.length(); i++) {
            key.append(codedString.charAt(i));
            if (this.decoder.containsKey(key.toString())) {
                sb.append(this.decoder.get(key.toString()));
                key = new StringBuilder();
            }
        }
        return sb.toString();
    }

    private class Node implements Comparable<Node> {
        Character data;
        int cost;
        Node left, right;

        Node(char data, int cost) {
            this.data = data;
            this.cost = cost;
        }

        Node(Node left, Node right) {
            this.data = '\0';
            this.cost = left.cost + right.cost;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

}
