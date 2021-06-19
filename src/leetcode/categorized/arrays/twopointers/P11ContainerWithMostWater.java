package leetcode.categorized.arrays.twopointers;

class P11ContainerWithMostWater {
    // MYSELF in under 3-4 mins.
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        
        int i = 0, j = height.length - 1;
        
        while( i < j){
            int currArea;
            if(height[i] < height[j]){
                currArea = height[i] * (j - i);
                i++;
            }else{
                currArea = height[j] * (j - i);
                j--;
            }
            if(currArea > max) max = currArea;
        }
        
        return max;
    }
}