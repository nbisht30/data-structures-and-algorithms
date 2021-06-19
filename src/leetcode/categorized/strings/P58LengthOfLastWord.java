package leetcode.categorized.strings;

class P58LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int l = s.length() - 1;
        int cnt = 0;
        while(l >= 0 && s.charAt(l) == ' ') l--;  // Ignore spaces from the end
        while(l >= 0 && s.charAt(l--)!=' ') cnt++; // Count word length
        return cnt;
    }
}