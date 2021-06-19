package leetcode.categorized.strings;

class P567PermutationInString {

    // INTUITION: A permutation of a string is basically just an anagram of that string. Find all anagrams of the string.
    // Same ideas as in P438.
    public boolean checkInclusion(String s1, String s2) {
        
        int cntS1[] = new int[26];
        
        for(int i = 0; i < s1.length(); i++){
            cntS1[s1.charAt(i) - 'a']++;
        }
        
        int left = 0, right = 0, toVisit = s1.length();
        
        while(right < s2.length()){
            
            if(cntS1[s2.charAt(right) - 'a'] >= 1){
                toVisit--;
            }
            
            cntS1[s2.charAt(right) - 'a']--;
            right++;
            
            if(toVisit == 0) return true;
            
            if(right - left == s1.length()){
                if(cntS1[s2.charAt(left) - 'a'] >= 0){
                    toVisit++;
                }
                cntS1[s2.charAt(left) - 'a']++;
                left++;
            }
        }
        
        return false;
    }
}