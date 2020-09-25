package leetcode.solved.categorized.strings;

class P459RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        boolean res = true;
        
        for(int i = 0; (2 * (i + 1)) <= s.length(); i++){
            res = true;
            for(int j = i + 1; j < s.length(); ){
                int k = 0, l = j;
                while(l < s.length() && k <= i){
                    if(s.charAt(k) != s.charAt(l)) {
                        res = false;
                        break;
                    }
                    l++;
                    k++;
                }
                if(!res) break;
                if(j + (i + 1) > s.length()) return false;
                j+= (i + 1);
            }
            if(res) return true;
        }
        return false;
    }
}