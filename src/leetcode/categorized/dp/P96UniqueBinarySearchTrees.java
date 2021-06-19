package leetcode.categorized.dp;

class P96UniqueBinarySearchTrees {
    // NEEDED HELP
    // EXPLANATION : https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
    public int numTrees(int n) {
        int[] numberOfWays = new int[n + 1];
        // number of ways to make a tree with 0 nodes
        numberOfWays[0] = 1;

        for(int i = 1; i <= n; i++) {
            int waysForINodes = 0;
            for(int j = 1; j <= i; j++) {
                waysForINodes += numberOfWays[j - 1] * numberOfWays[i - j];
            }
            numberOfWays[i] = waysForINodes;
        }
        return numberOfWays[n];
    }
}


