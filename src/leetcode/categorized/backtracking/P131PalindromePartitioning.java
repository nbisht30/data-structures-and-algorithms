package leetcode.categorized.backtracking;

import java.util.ArrayList;
import java.util.List;

class P131PalindromePartitioning {
    /*
    Plain backtracking solution!
    Problem: Performs one extra iteration to determine if a given substring is a palindrome or not.
    Here, we are repeatedly iterating over the same substring multiple times and the result is always the same.
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        findAll(s, 0, result, new ArrayList<>());
        return result;
    }

    void findAll(String s, int start, List<List<String>> result, List<String> temp) {

        if (start >= s.length()) {
            result.add(new ArrayList<>(temp));
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i + 1));
                findAll(s, i + 1, result, temp);
                temp.remove(temp.size() - 1); // Backtracking!!
            }
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j)) return false;
        return true;
    }


    public List<List<String>> partitionDP(String s) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        findAllDP(s, 0, result, new ArrayList<>(), palindrome);
        return result;
    }

    void findAllDP(String s, int start, List<List<String>> result, List<String> temp, boolean[][] palindrome) {

        if (start >= s.length()) {
            result.add(new ArrayList<>(temp));
        }

        for (int i = start; i < s.length(); i++) {
            if (s.charAt(start) == s.charAt(i) && (i - start <= 2 || palindrome[start + 1][i - 1])) {
                /*
                i - start <= 2 ->>>> As we know of strings of length 1, 2 and 3 would be palindrome if first and last characters are same, so we're marking palindrome[start][i] = true
                if first and last character is same. And also it helps to avoid checking the other condition i.e. palindrome[start + 1][i - 1]

                Dry run:-
                When start is 0 then i would go from 0 to s.length() - 1 and (i - start <= 2) would always be true and we would mark the [0,0], [1,1], [2,2]... i.e
                all diagonal elements as true.
                When start becomes 1 then i would go from 1 to s.length() - 1 and (i - start <= 2) would be true when i is 1, 2, 3 but false when i is 4.
                When start becomes 2 then i would go from 2 to s.length() - 1 and (i - start <= 2) would be true when i is 2, 3, 4 but false when i is 5.
                When start becomes 3 then i would go from 3 to s.length() - 1 and (i - start <= 2) would be true when i is 3, 4, 5 but false when i is 6(if length of string allows i going to 6)
                 */
                palindrome[start][i] = true;
                temp.add(s.substring(start, i + 1));
                findAllDP(s, i + 1, result, temp, palindrome);
                temp.remove(temp.size() - 1); // Backtracking!!
            }
        }
    }
}