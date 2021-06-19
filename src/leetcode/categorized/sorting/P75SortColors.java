package leetcode.categorized.sorting;

class P75SortColors {
    // MYSELF
    // @TODO: Quick Sort Implementation and Two Pointer Implementation.
    public void sortColors(int[] nums) {
        for (int i = 0, k = 0, j = nums.length - 1; i < nums.length; ) {
            if (nums[i] == 2) {
                if (i < j) {
                    if (nums[j] != 2) {
                        nums[i] = nums[j];
                        nums[j] = 2;
                    }
                    j--;
                } else {
                    i++;
                }
            }
            if (i < nums.length && nums[i] == 0) {
                if (i > k) {
                    if (nums[k] != 0) {
                        nums[i] = nums[k];
                        nums[k] = 0;
                    }
                    k++;
                } else {
                    i++;
                }
            }
            if (i < nums.length && nums[i] == 1) i++;
            if (i > j) {
                break;
            }
        }
    }
}