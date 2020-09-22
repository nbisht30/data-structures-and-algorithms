package leetcode.solved.categorized.backtracking;

import java.util.ArrayList;
import java.util.List;

class P131PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        findAll(s, result, new ArrayList<>());
        return result;
    }

    /*
    Plain backtracking solution!
     */
    void findAll(String s, List<List<String>> result, List<String> temp) {

        if (s.length() == 0) {
            result.add(new ArrayList<>(temp));
        }

        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i + 1);
            if (isPalindrome(left)) {
                temp.add(left);
                String right = s.substring(i + 1, s.length());
                findAll(right, result, temp);
                temp.remove(temp.size() - 1); // Backtracking!!
            }

        }
    }

    boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j)) return false;
        return true;
    }
}