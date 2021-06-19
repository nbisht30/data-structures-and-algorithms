package leetcode.categorized.arrays;

class P42TrappingRainWater {
    //

    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int maxFromSt[] = new int[height.length];
        int maxFromEnd[] = new int[height.length];
        int rw = 0;
        maxFromSt[0] = height[0];
        maxFromEnd[height.length - 1] = height[height.length - 1];
        for(int i = 1, j = height.length -  2; i < height.length; i++, j--){
            maxFromSt[i] = Math.max(maxFromSt[i - 1], height[i]);
            maxFromEnd[j] = Math.max(maxFromEnd[j + 1], height[j]);
        }
        
        for(int i = 0; i < height.length; i++){
            rw += Math.min(maxFromSt[i], maxFromEnd[i]) - height[i];
        }
            
        return rw;
    }

    // @TODO : Revisit
    public int trapOptimizedSpace(int[] height) {
        if(height.length == 0) return 0;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int rw = 0, left = 0, right = height.length -  1;
        while(left < right){
            if(height[left] < height[right]){ // if we have smaller element at left.
                if(height[left] > leftMax) leftMax = height[left]; // If a new max from left is
                    //found just store it in leftMax
                else rw += leftMax - height[left];
                left++;
            }else{ // height[right] <= height[left]
                if(height[right] > rightMax) rightMax = height[right];// If a new max from left is
                    //found just store it in leftMax
                else rw += rightMax - height[right];
                right--;
            }
        }
        return rw;
    }
}