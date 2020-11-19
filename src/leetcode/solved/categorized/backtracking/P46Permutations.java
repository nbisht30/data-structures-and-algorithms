package leetcode.solved.categorized.backtracking;

import java.util.ArrayList;
import java.util.List;

class P46Permutations {
    /*
    RESOLVED:
    18-Nov-20
     */

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