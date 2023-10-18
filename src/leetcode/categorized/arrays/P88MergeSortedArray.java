package leetcode.categorized.arrays;

class P88MergeSortedArray {
    // MYSELF
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Move elements from the last of nums1[m] to the last of nums1[m + n]
        // To make space for at the front of nums1 for final sorted elements.
        for (int index = m - 1; index >= 0; index--) {
            nums1[index + n] = nums1[index];
        }

        int index1 = n, index2 = 0, finalIndex = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] <= nums2[index2]) {
                nums1[finalIndex++] = nums1[index1++];
            } else {
                nums1[finalIndex++] = nums2[index2++];
            }
        }

        // Explanation of below line: In the case of some nums1 elements remaining to be checked by above sorting
        // algorithm, this would be when m > n i.e. nums1 has more elements(except placeholder elemtents at the end)
        // than nums2, we would not need to check and sort those nums1 elements, as they would already
        // be present at the end of nums1 and already sorted.
        // So only when n > m, i.e. when nums2 has more elements than nums1,
        // we would need to iterate through remaining nums2 elements and put them in nums1.
        while (index2 < nums2.length) nums1[finalIndex++] = nums2[index2++];
    }
}