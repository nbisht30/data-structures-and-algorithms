package leetcode.categorized.backtracking;

import java.util.HashSet;
import java.util.Set;

class P1079LetterTilePossibilities {
    // MYSELF
    // DATE: 05-07-21
    // TIME: 34 mins
    // APPROACH: Backtracking
    // INTUITION: Find all subsets of the string, then count permutations for each subset of the string.
    int count = 0;
    Set<String> uniqueSubsets = new HashSet<>();

    public int numTilePossibilities(String tiles) {
        subsets(tiles, 0, new StringBuilder());
        return uniqueSubsets.size();
    }

    void subsets(String tiles, int i, StringBuilder sb) {
        if (i == tiles.length()) {
            String subset = sb.toString();
            if (!subset.equals("") && !uniqueSubsets.contains(subset)) {
                permutations(sb, 0);
                uniqueSubsets.add(subset);
            }
            return;
        }
        subsets(tiles, i + 1, sb);
        sb.append(tiles.charAt(i));
        subsets(tiles, i + 1, sb);
        sb.setLength(sb.length() - 1);
    }

    void permutations(StringBuilder sb, int st) {
        if (st == sb.length()) {
            uniqueSubsets.add(sb.toString());
            return;
        }

        for (int i = st; i < sb.length(); i++) {
            swap(sb, st, i);
            permutations(sb, st + 1);
            swap(sb, st, i);
        }
    }

    void swap(StringBuilder sb, int i, int j) {
        char ch = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, ch);
    }
}