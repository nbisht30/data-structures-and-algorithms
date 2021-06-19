package leetcode.categorized.arrays;

class P88MergeSortedArray {
    // MYSELF
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m - 1; i >= 0; i--){
            nums1[i + n] = nums1[i];
        }
        int i = 0, j = n, k = 0;
        while(i < nums2.length && j < nums1.length){
            if(nums1[j] <= nums2[i]){
                nums1[k++] = nums1[j++];
            }else{
                nums1[k++] = nums2[i++];
            }
        }
        while(i < nums2.length) nums1[k++] = nums2[i++];
    }
}