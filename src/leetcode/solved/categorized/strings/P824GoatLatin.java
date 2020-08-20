package leetcode.solved.categorized.strings;

import java.util.Collections;
import java.util.HashSet;

class P824GoatLatin {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");

        HashSet<Character> vowel = new HashSet<>();
        Collections.addAll(vowel, 'a', 'e', 'i', 'o', 'u','A','E','I','O','U');

        StringBuilder sb = new StringBuilder();
        StringBuilder aStr = new StringBuilder();
        StringBuilder res = new StringBuilder();
        aStr.append('a');
        for (String s : words) {
            sb = new StringBuilder();
            if (vowel.contains(s.charAt(0))) {
                sb.append(s).append("ma").append(aStr);
            } else {
                sb.append(s.substring(1)).append(s.charAt(0)).append("ma").append(aStr);
            }
            res.append(sb).append(" ");
            aStr.append("a");
        }
        if(res.length() > 0) res.setLength(res.length() - 1);
        return res.toString();
    }
}