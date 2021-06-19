package leetcode.categorized.strings;

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


    class SecondAttempt {
        public String toGoatLatin(String S) {
            if(S == null || S.length() == 0) return "";
            String[] splits = S.split(" ");
            StringBuilder result = new StringBuilder();
            String suffix = "a";
            for(String str : splits){
                String rep = getReplacement(str);
                result.append(rep + suffix + " ");
                suffix += "a";
            }
            result.setLength(result.length() - 1);
            return result.toString();
        }

        String getReplacement(String s){
            if(isVowel(s.charAt(0))) return s + "ma";
            else return s.substring(1) + s.charAt(0) + "ma";
        }

        boolean isVowel(char ch){
            HashSet<Character> vowel = new HashSet<>();
            Collections.addAll(vowel, 'a','e','i','o','u', 'A', 'E', 'I', 'O', 'U');
            return vowel.contains(ch);
        }
    }
}