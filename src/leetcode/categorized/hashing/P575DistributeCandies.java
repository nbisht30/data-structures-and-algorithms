package leetcode.categorized.hashing;

import java.util.HashSet;
import java.util.Set;

class P575DistributeCandies {
    // MYSELF
    // 2 mins
    public int distributeCandies(int[] candyType) {
        Set<Integer> types = new HashSet<>();
        for (int candy : candyType) {
            types.add(candy);
        }
        return candyType.length / 2 < types.size() ? candyType.length / 2 : types.size();
    }
}