package leetcode.solved.categorized.backtracking;

import java.util.ArrayList;
import java.util.List;

class P46Permutations {
    /*
    RESOLVED:
    18-Nov-20
     */

    // EXPLANATION: https://www.youtube.com/watch?v=pxA6l1X4iPU&ab_channel=LeadCoding @ 13:00
    class ApproachFirst{
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> perms = new ArrayList<>();
            permute(nums, 0, nums.length - 1, perms);
            return perms;
        }

        public void permute(int[] nums, int st, int end, List<List<Integer>> perms) {
            if (st == end) {
                List<Integer> perm = new ArrayList<Integer>();
                for (int num : nums) { // Currently, the permutation is available in nums after the swapping of values
                    // Now just add its elements to a list for returning.
                    perm.add(num);
                }
                perms.add(perm); // Added to main return list.
                return;
            }

            // Swap element at st with every other element, fix the swapped element at st and then permute with st + 1
            // After permuting reset to the original positions before permuting(Backtracking)
            for (int i = st; i <= end; i++) {
                swap(nums, st, i);
                permute(nums, st + 1, end, perms); //Fix the element at current values of st and then increase st
                swap(nums, st, i);
            }
        }

        public void swap(int[] arr, int a, int b) {
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }
    }

    // EXPLANATION: https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
    // This is a more general approach and can be applied to other backtracking questions also.
    // Takes more time than first one.
    class ApproachSecond{
        List<List<Integer>> perms = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            helper(nums, new ArrayList<>());
            return perms;
        }

        void helper(int[] nums, List<Integer> perm) {
            if(perm.size() == nums.length) {
                perms.add(new ArrayList<>(perm));
                return;
            }

            for(int i = 0; i < nums.length; i++) {
                if(perm.contains(nums[i])) continue;
                perm.add(nums[i]);
                helper(nums, perm);
                perm.remove(perm.size() - 1);
            }
        }
    }

}