package leetcode.solved.categorized.strings.stringbinarysearch;

class P1898MaximumNumberOfRemovableCharacters {

    // EXP: https://leetcode.com/problems/maximum-number-of-removable-characters/discuss/1268477/JAVA-Binary-Search-with-Detailed-Explanation!
    // NEEDED HELP
    public int maximumRemovals(String s, String p, int[] removable) {
        char[] str = s.toCharArray();
        // binary search through removable
        int lo = 0, hi = removable.length, mid = 0;
        while(lo <= hi) {
            mid = lo + (hi - lo) / 2;
            
            // put some other character for ignoring when checking for subsequence
            for(int i = 0; i < mid; i++) {
                str[removable[i]] = '/'; 
            }
            
            if(isSubseq(p, str)) { // check if it is still a subsequence if we ignore first mid + 1 characters
                lo = mid + 1;
            } else {
                // restore characters
                for(int i = 0; i < mid; i++) {
                    str[removable[i]] = s.charAt(removable[i]); 
                }
                hi = mid - 1;
            }
        }
        return hi;
    }
    
    // checks if p is a subsequence of s
    boolean isSubseq(String p, char[] str) {
        int i = 0, j = 0;
        // checking subsequence logic
        while(i < p.length() && j < str.length) {
            if(str[j] =='/') { // ignore removed character
                j++;
            } else {
                if(p.charAt(i) == str[j]) {
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
        }
        return i == p.length(); // if entire p could be traversed => p was a subsequence of s.
    }

}