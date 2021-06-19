package leetcode.categorized.strings;

class P409LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)]++;
        }

        int len = 0;

        for(int i = 0; i < 128; i++){
            len += (count[i] / 2) * 2;
            if(len % 2 == 0 && count[i] % 2 == 1){
                len++;
            }
        }

        return len;
    }
}