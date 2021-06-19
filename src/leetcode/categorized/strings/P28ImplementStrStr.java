package leetcode.categorized.strings;

class P28ImplementStrStr {

    public int strStrMySolution(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        if(needle.length() == 0) return 0;
        
        for(int i = 0; i < haystack.length(); i++){
            // no enough places for needle after i
            if (i + needle.length() > haystack.length()) break;

            if(haystack.charAt(i) == needle.charAt(0)){
                int iNeedle = 1;
                while((i + iNeedle < haystack.length()) && iNeedle < needle.length()
                     && haystack.charAt(i + iNeedle) == needle.charAt(iNeedle))
                    iNeedle++;
                if(iNeedle == needle.length()) return i;
            }
        }
        return -1;
    }
}