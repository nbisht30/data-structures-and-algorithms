package leetcode.categorized.arrays;

class P31NextPermutation {

    // NEEDED HELP
    // DATE: 06-07-21
    // ALGORITHM:-
    /*
    Narayana Pandita Algorithm:-
        Find the largest index k such that nums[k] < nums[k + 1]. If no such index exists, just reverse nums and done.
        Find the largest index l > k such that nums[k] < nums[l].
        Swap nums[k] and nums[l].
        Reverse the sub-array nums[k + 1 to end].

    Example:-
    2,3,6,5,4,1

    Solution:
    Step1, from right to left, find the first number which not in ascending order. In this case it is 3.
    Step2, Now we can have two situations:
    1. We cannot find such a number, all the numbers increasing in a ascending order from right side.
    This means this permutation is the last permutation, we need to rotate back to the first permutation.
    So we reverse the whole array, for example, 6,5,4,3,2,1 we turn it to 1,2,3,4,5,6.

    2. We can find the number, then we again iterate from right to left to find the first number which is larger than 3, in this case it is 4.
    Then we swap 3 and 4, the list turn to 2,4,6,5,3,1.
    Last, we reverse numbers on the right of 4, we finally get 2,4,1,3,5,6.
    */
    public void nextPermutation(int[] nums) {
        int n = nums.length, k = n - 2;
        while(k >= 0) {
            if(nums[k] < nums[k + 1]) break;
            k--;
        }
        
        if(k < 0) {
            reverse(nums, 0, n - 1);
            return;
        }
        
        for(int l = n - 1; l > k; l--) {
            if(nums[k] < nums[l]) {
                swap(nums, k, l); 
                reverse(nums, k + 1, n - 1);
                return;
            }
        }
        
    }
    
    void reverse(int[] nums, int st, int end) {
        for(int i = st, j = end; i < j; i++, j--) {
            swap(nums, i, j); 
        }
    }
    
    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

