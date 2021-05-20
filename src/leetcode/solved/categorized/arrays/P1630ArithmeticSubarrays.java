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

    // EXPLANATION: https://leetcode.com/problems/arithmetic-subarrays/discuss/1220187/EXPLAINED-or-Java-or-Without-Sorting-or-Arithmetic-Progression
    class WithoutSorting {
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            List<Boolean> res = new ArrayList<>(l.length);
            for(int i = 0; i < l.length; i++) {
                int st = l[i], end = r[i];
                res.add(checkArithmetic(nums, st, end));
            }
            return res;
        }

        private boolean checkArithmetic(int[] nums, int st, int end) {
            int min = nums[st], max = nums[st];

            // find min and max, ie. first and last terms of Arithmetic Progression
            for(int i = st; i <= end; i++) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }

            int len = end - st + 1;

            // if all elements are same
            if(min == max) return true;

            // Arithmetic Progression(AP) formula : An = Ao + (n - 1) * D => (n - 1) * D = An - Ao => D = (An - Ao) / (n - 1)
            int commonDiff = (max - min) / (len - 1);

            // if commonDiff was fractional i.e. AP was not evenly spaced
            if((max - min) % (len - 1) != 0) return false;

            boolean[] found = new boolean[len];
            for(int i = st; i <= end; i++) {
                int pos = (nums[i] - min) / commonDiff;
                boolean posFractional = (nums[i] - min) % commonDiff != 0;
                if(posFractional || found[pos]) return false;
                found[pos] = true;
            }

            return true;
        }
    }


}