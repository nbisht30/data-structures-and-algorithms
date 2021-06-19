package leetcode.categorized.arrays;

import java.util.ArrayList;
import java.util.List;

class P448FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int ind = Math.abs(nums[i]);
            nums[ind - 1] = -Math.abs(nums[ind - 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) list.add(i + 1);
        }
        return list;
    }
}