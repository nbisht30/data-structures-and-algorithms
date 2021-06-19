package leetcode.categorized.greedy;

class P1899MergeTripletsToFormTargetTriplet {
    // MYSELF
    // TIME: 50 mins
    // DATE: 13-06-2021
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        for(int i = 0; i <= 2; i++) {
            boolean notFound = true;
            for(int j = 0; j < triplets.length; j++) {
                if(triplets[j][i] == target[i]) {
                    if(i == 0 && target[1] >= triplets[j][1] && target[2] >= triplets[j][2]) notFound = false; 
                    if(i == 1 && target[0] >= triplets[j][0] && target[2] >= triplets[j][2]) notFound = false; 
                    if(i == 2 && target[0] >= triplets[j][0] && target[1] >= triplets[j][1]) notFound = false; 
                }  
                if(!notFound) break;
            }
            if(notFound) return false;
        }
        return true;
    }
    
}