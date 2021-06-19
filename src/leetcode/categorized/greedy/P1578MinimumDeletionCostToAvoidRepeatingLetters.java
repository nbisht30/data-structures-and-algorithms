package leetcode.categorized.greedy;

class P1578MinimumDeletionCostToAvoidRepeatingLetters {
    public int minCost(String s, int[] cost) {

        int last = 0, tCost = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(last)) {
                if (cost[i] > cost[last]) {
                    tCost += cost[last];
                    last = i;
                } else {
                    tCost += cost[i];
                }
            } else {
                last = i;
            }
        }

        return tCost;
    }
}