package leetcode.solved.categorized.priorityqueue;

import java.util.*;
// @TODO: Learn how to solve this using bucket sort.
class P451SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("eeeeaaadrr"));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Character> heap =
                new PriorityQueue<>(Comparator.comparingInt(count::get).reversed());  // Comparator.comparingInt() gives a comparator
        // to compare int using the function passed and reversed() method provide the reversed order of this comparator.

        for (char ch : count.keySet()) {
            heap.add(ch);
        }

/*        //NOTE: PRINTING A QUEUE DOES NOT GIVE THE RESULTS IN THE ACTUAL ORDER BASED ON PRIORITY
        Iterator<Character> itr2 = heap.iterator();
        while (itr2.hasNext())
            System.out.println(itr2.next());*/

        StringBuilder finalSB = new StringBuilder();

        while(!heap.isEmpty()){
            char head = heap.poll();
            int charCount = count.get(head);
            for (int i = 0; i < charCount; i++) {
                finalSB.append(head);
            }
        }

        return finalSB.toString();
    }
}