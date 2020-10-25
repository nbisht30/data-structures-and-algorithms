package leetcode.solved.categorized.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class P1630ArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            List<Integer> list = getListFromRange(nums, l[i], r[i]);
            res.add(checkArithmetic(list));
        }
        return res;
    }

    List<Integer> getListFromRange(int[] nums, int st, int end) {
        List<Integer> list = new ArrayList<>();
        for (int i = st; i <= end; i++) list.add(nums[i]);
        return list;
    }

    boolean checkArithmetic(List<Integer> list) {
        if (list.size() == 1 || list.size() == 2) return true;
        Collections.sort(list);
        int diff = list.get(1) - list.get(0);
        for (int i = 2; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) != diff) return false;
        }
        return true;
    }
}