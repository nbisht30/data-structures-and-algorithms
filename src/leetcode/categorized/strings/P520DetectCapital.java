package leetcode.categorized.strings;

class P520DetectCapital {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 1) return true;
        boolean firstCase = isUpper(word.charAt(0));
        
        if(!firstCase) {
            for(int i = 1; i < word.length(); i++){
                if(isUpper(word.charAt(i))) return false;
            }
        } else {
            boolean secondCase = isUpper(word.charAt(1));
            if(secondCase){
                for(int i = 2; i < word.length(); i++){
                   if(!isUpper(word.charAt(i))) return false;
                }
            } else {
                for(int i = 2; i < word.length(); i++){
                    if(isUpper(word.charAt(i))) return false;
                }
            }
            
        }
        
        return true;
    }
    
    private boolean isUpper(char ch){
        if(ch >= 'A' && ch <= 'Z') return true;
        return false;
    }
}