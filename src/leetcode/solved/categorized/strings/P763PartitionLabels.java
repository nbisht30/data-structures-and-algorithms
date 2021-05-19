package leetcode.solved.categorized.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P763PartitionLabels {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    public static List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

    // MYSELF
    // DATE: 19-05-2021, second attempt
    // TIME: 17 mins
    // COMMENT: Figured out the approach myself, this is best approach for this problem and is much more optimized
    // than my approach last time https://leetcode.com/submissions/detail/409729744/

    public List<Integer> partitionLabelsSecondAttempt(String s) {

        // find the last occurrence of each character
        int[] last = new int[26];
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            last[index] = i;
        }

        // for each character keep a min first and max last and continue till the
        // next characters lie between these minFirst and maxLast
        // if current character's index is after the current maxLast(i > maxLast) then put the length
        // in result list and update minFirst and maxLast.
        List<Integer> res = new ArrayList<>();
        int minFirst = 0, maxLast = 0;
        for(int i = 0; i < s.length(); i++) {
            int ind = s.charAt(i) - 'a';
            if(i > maxLast) {
                int len = maxLast - minFirst + 1;
                res.add(len);
                minFirst = i;
                maxLast = last[ind];
            }
            else {
                minFirst = Math.min(minFirst, i);
                maxLast = Math.max(maxLast, last[ind]);
            }
        }
        res.add(maxLast - minFirst + 1);
        return res;
    }
}