package leetcode.randomproblems.arrays;
//https://leetcode.com/problems/find-lucky-integer-in-an-array/
class P1394LuckyInteger {
    public int findLucky(int[] arr) {
               
        int[] s = new int[501];
        int res = -1;
        
        for(int a: arr){
            s[a]++;
        }
        
        for(int i =1;i<=500;i++){
            if(s[i]==i){
                res = i;
            }
        }
        
        return res;
    }
}