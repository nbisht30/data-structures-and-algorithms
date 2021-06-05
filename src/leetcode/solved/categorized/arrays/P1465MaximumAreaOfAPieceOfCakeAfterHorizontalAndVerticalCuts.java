package leetcode.solved.categorized.arrays;

import java.util.Arrays;

class P1465MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
    // MYSELF
    // DATE: 04-06-2021, first attempt
    // TIME: 20 mins
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int n = horizontalCuts.length;
        int m = verticalCuts.length;
        int maxH = Math.max(horizontalCuts[0], h - horizontalCuts[n - 1]);
        int maxW = Math.max(verticalCuts[0], w - verticalCuts[m - 1]);
        
        for(int i = 1; i < n; i++) {
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for(int i = 1; i < m; i++) {
            maxW = Math.max(maxW, verticalCuts[i] - verticalCuts[i - 1]);
        }

        return (int)(((long) maxW * maxH) % 1000000007);
    } 
}