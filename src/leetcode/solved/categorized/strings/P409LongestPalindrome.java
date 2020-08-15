package leetcode.solved.categorized.strings;

class P409LongestPalindrome {
    public int longestPalindrome(String s) {
        /*
        d - 2,  a - 1, c - 4, b - 1
        even - > on two opposite ends of the string.    
        */
        
        int[] count = new int [128];
        
        char[] str = s.toCharArray();
        
        for(char ch : str) count[ch]++;
        
        int maxLen = 0;
        boolean oddFound = false;
        for(int i : count){
            if(i != 0){
                if(i % 2 == 0) maxLen += i;
                else{
                    oddFound = true;
                    maxLen += (i - 1);
                }
            }
        }
        maxLen +=  oddFound ? 1 : 0;
        
        return maxLen;
    }
}