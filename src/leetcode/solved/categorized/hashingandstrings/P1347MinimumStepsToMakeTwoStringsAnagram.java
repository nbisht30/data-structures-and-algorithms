package leetcode.solved.categorized.hashingandstrings;

/**
 * @author Nikhil Bisht
 * @date 04-04-2020
 */
/*
https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
*/
public class P1347MinimumStepsToMakeTwoStringsAnagram {
    public int minSteps(String s, String t) {
        int count[] = new int[26];
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        for(int i = 0; i < T.length; i++){
            count[T[i] - 97] ++;
        }
        int nC = T.length;
        for(int i = 0; i < S.length; i++){
            if(count[S[i] - 97] >= 1){
                count[S[i] - 97]--;
                nC--;
            }
        }
        return nC;
    }
}
