package leetcode.solved.categorized.searching.binarysearch;

class P4MedianOfTwoSortedArrays {
    // O(M+N) using the merge function of merge sort
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] r = merge(nums1, nums2);
        if (r.length % 2 == 0) {
            int index2 = r.length / 2;
            int index1 = index2 - 1;
            return (double) (r[index1] + r[index2]) / 2;
        } else {
            return r[r.length / 2];
        }
    }

    int[] merge(int[] a, int[] b) {
        int[] r = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) r[k++] = a[i++];
            else r[k++] = b[j++];
        }
        while (i < a.length) r[k++] = a[i++];
        while (j < b.length) r[k++] = b[j++];
        return r;
    }

    // O(Log(min(m, n)) approach
    /*
    lets say,
    num1 -> x1, x2, x3, x4, x5, x6
    num2 -> y1, y2, y3, y4, y5, y6, y7, y8
    Now, if we can partition both the arrays into two equal halves
    (where one half includes elements of both arrays and not just a single array)
    such that both halves have equal number of elements and every element in left
    half is less than or equal to every element in right half,
    then maybe the elements at such partitions can help us get close to finding the solution.

    Eg. lets divide num1 after x2 and num2 after y5,
    then first half has a total of eight elements and right half also has 8 elements.
    Lets assume that we divided the arrays such that
    every element in left half i.e. [x1 x2 y1 y2 y3 y4 y5] is <=
    every element in the right half i.e. [x3 x4 x5 x6 y6 y7 y8].
    For this to happen, the element just before the dividing point at num1 i.e. x2
    should be <= the element just after the dividing point at num2 i.e. y6
    So, x2 <= y6
    And, the element just before the dividing point at num2 i.e. y5
    should be <= the element just after the dividing point at num1 i.e x3
    So, y5 <= x3


     */
    // https://www.youtube.com/watch?v=LPFhl65R7ww&ab_channel=TusharRoy-CodingMadeSimple
}