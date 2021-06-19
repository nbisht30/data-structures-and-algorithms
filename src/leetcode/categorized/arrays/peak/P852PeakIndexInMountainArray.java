package leetcode.categorized.arrays.peak;

class P852PeakIndexInMountainArray {
    // MYSELF
    // TIME: 5 min

    public int peakIndexInMountainArray(int[] A) {
        int peak = Integer.MIN_VALUE;
        int ind = 0;
        for (int i = 0; i < A.length; i++) {
            if (peak < A[i]) {
                ind = i;
                peak = A[i];
            }
        }

        return ind;
    }

    // O(N LogN)
    public int peakIndexInMountainArrayBinarySearch(int[] arr) {

        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid == 0 || mid == arr.length - 1) return mid;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) return mid;
            else if (arr[mid] < arr[mid + 1]) lo = mid + 1;
            else hi = mid;
        }

        return -1;
    }
}