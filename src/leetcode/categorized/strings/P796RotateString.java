package leetcode.categorized.strings;

import java.util.Arrays;

class P796RotateString {

    public boolean rotateString(String A, String B) {
        if(A.length() != B.length()) return false;
        if(A.equals(B)) return true;

        int pivot = 1;
        for(int shifts = 0; shifts < A.length(); shifts++, pivot++){
            int j = 0;
            boolean matches = true;

            for(int i = pivot; i < A.length(); i++, j++) {
                if(A.charAt(i) != B.charAt(j)) {
                    matches = false;
                    break;
                }
            }
            if(!matches) {
                continue;
            }
            for(int i = 0; i < pivot; i++, j++){
                if(A.charAt(i) != B.charAt(j)) {
                    matches = false;
                    break;
                }
            }
            if(matches) return true;
        }
        return false;
    }

}