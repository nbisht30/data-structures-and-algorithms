package leetcode.categorized.graphs.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class P127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        int length = 1;

        Map<String, Boolean> visited = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++)
            visited.put(wordList.get(i), false);

        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.removeFirst();
                if (endWord.equals(currWord)) return length;
                wordMatch(queue, currWord, visited);
            }
            length++;
        }
        return 0;
    }

    void wordMatch(LinkedList<String> queue, String word, Map<String, Boolean> visited) {
        char[] charWord = word.toCharArray();

        for (int i = 0; i < charWord.length; i++) {
            for (int j = 0; j < 26; j++) {
                char ch = (char) ('a' + j);
                char temp = charWord[i];
                charWord[i] = ch;
                String strWord = String.valueOf(charWord);
                if (visited.containsKey(strWord) && !visited.get(strWord)) {
                    queue.add(strWord);
                    visited.put(strWord, true);
                }
                charWord[i] = temp;
            }
        }
    }
}