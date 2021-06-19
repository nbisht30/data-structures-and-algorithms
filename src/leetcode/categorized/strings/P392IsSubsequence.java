package leetcode.categorized.strings;

class P392IsSubsequence {
    // MYSELF
    // DATE: 13-06-21
    // TIME: 2 mins
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        } 
        return i == s.length();
    }
    
}