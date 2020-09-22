package leetcode.solved.categorized.backtracking;

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
                palindrome[start][i] = true;
                temp.add(s.substring(start, i + 1));
                findAll(s, i + 1, result, temp, palindrome);
                temp.remove(temp.size() - 1); // Backtracking!!
            }
        }
    }

    /*
    // My old backtracking impl. insteading of just using one string creating separte strings in left and right
    // was getting very time consuming, above implementation is faster.
    void findAll(String s, int start, List<List<String>> result, List<String> temp){

        if(s.length() == 0) {
            result.add(new ArrayList<>(temp));
        }

        for(int i = start; i < s.length(); i++){
            String left = s.substring(start, i + 1);
            if(isPalindrome(left)){
                temp.add(left);
                String right = s.substring(i + 1, s.length());
                findAll(right, start, result, temp);
                temp.remove(temp.size() - 1); // Backtracking!!
            }

        }
    }

    boolean isPalindrome(String s){
        for(int i = 0, j = s.length() - 1; i < j; i++, j--)
            if(s.charAt(i) != s.charAt(j)) return false;
        return true;
    }
    */

}