package leetcode.solved.categorized.dp;

class P96UniqueBinarySearchTrees {
    // NEEDED HELP
    // EXPLANATION : https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1; // number of ways to make a tree with 0 nodes

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] = G[i] + G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}


