package leetcode.solved.categorized.hashingandstrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Nikhil Bisht
 * @date 05-04-2020
 */
//MEDIUM DIFFICULTY
//https://leetcode.com/problems/find-and-replace-pattern/
public class P890FindAndReplacePattern {
    //TTS : Had almost solved it at 22 min but few tests failed, like for the below pattern
    //new String[]{"badc", "abab", "dddd", "dede", "yyxx"}, "baba")
    //My output was badc, abab, yyxx. Then took hint and solved in around a total of 40 min.
    public static void main(String[] args) {
        System.out.println(findAndReplacePattern(new String[]{"badc", "abab", "dddd", "dede", "yyxx"}, "baba"));
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        /*
        Algorithm: Calculate unique numbers for the pattern and each word.
        Output the words for which these numbers match with the pattern's number.

        Calculating the number:-
        Each n-th (n starts from 1 so 1st, 2nd ...) digit of the number should denote the position of the
        first occurrence of the character present at the (n-1)th index of word/pattern Eg.
        if the word/pattern string is "abba" then map it with 1221 where each digit represents the (index+1) of first
        occurrence of that type of character.
         */

        int numForPat = patCharCount(pattern);
        List<String> retrnWords = new ArrayList<>(words.length);
        for (int i = 0; i < words.length; i++) {
            if (patCharCount(words[i]) == numForPat) {
                retrnWords.add(words[i]);
            }
        }
        return retrnWords;
    }

    public static int patCharCount(String pat) {
        if (pat.length() == 0) {
            return 0;
        }
        Map<Character, Integer> characterFirstIndex = new HashMap<>();
        char[] chars = pat.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!characterFirstIndex.containsKey(chars[i])) {
                characterFirstIndex.put(chars[i], i + 1); //put the index of first occurrence of the character
            }
        }
        int number = 1;
        for (int i = 1; i < chars.length; i++) {
            number = number * 10 + characterFirstIndex.get(chars[i]);
        }
        return number;
    }
}
