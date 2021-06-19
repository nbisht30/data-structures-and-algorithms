package leetcode.categorized.dp;

class P274HIndex {
    public int hIndex(int[] citations) {
        int maxCitation = 0;
        
        for(int i : citations){
            if(i > maxCitation) maxCitation = i;
        }
        
        int[] dpArray = new int [maxCitation + 1];
        
        for(int i : citations){
            dpArray[i]++;
        }
        
        for(int i = maxCitation; i > 0; i--){
            dpArray[i - 1] += dpArray[i];
        }
        
        int maxHIndex = 0;
        
        for(int i = maxCitation; i >= 0; i--){
            if(dpArray[i] >= i){
                maxHIndex = i;
                break;
            }
        }
        return maxHIndex;
    }
}