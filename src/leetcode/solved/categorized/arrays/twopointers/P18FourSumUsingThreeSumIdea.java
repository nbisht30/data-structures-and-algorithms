package leetcode.solved.categorized.arrays.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Nikhil Bisht
 * @date 05-04-2020
 */
public class P18FourSumUsingThreeSumIdea {

    /*
    This is my latest attempt on 4Sum problem.
    This is just an extension of the 3Sum problem and uses two pointers approach.

    This problem can also be solved using maps. That solution is present in:-
    package leetcode.solved.categorized.hashing;
     */
    public List<List<Integer>> fourSumLatest(int[] nums, int target) {
        if (nums.length < 4) return new ArrayList<>();
        Arrays.sort(nums);
        int N = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < N - 3; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                for (int j = i + 1; j < N - 2; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int k = j + 1, l = N - 1;
                        while (k < l) {
                            int sum = nums[i] + nums[j] + nums[k] + nums[l];
                            if (sum == target) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                                while (k < l && nums[k] == nums[k + 1]) k++;
                                while (k < l && nums[l] == nums[l - 1]) l--;
                                k++;
                                l--;
                            } else if (sum > target) l--;
                            else k++;
                        }
                    }
                }
            }
        }
        return result;
    }
}
