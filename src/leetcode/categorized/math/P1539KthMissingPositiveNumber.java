package leetcode.categorized.math;

class P1539KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int missingCount = arr[0] - 1; //  Find if missing numbers exist before the first element. Eg. if first element is 3 then 3 - 1 = 2 i.e. 2 elements are missing.
        if (missingCount >= k) return k;
        for (int i = 1; i < arr.length; i++) {
            // How many numbers are missing between current and prev element
            int diff = arr[i] - arr[i - 1] - 1;
            if (missingCount + diff >= k) { // If old missingCount + new diff is greater than k
                return arr[i - 1] + k - missingCount;
            }
            missingCount += diff;
        }
        return arr[arr.length - 1] + k - missingCount;
    }

    // DATE: 03-03-2021
    // TIME: 5 mins
    public int findKthPositiveResolving(int[] arr, int k) {

        if(arr[0] - 1 >= k) return k;
        k -= arr[0] - 1;

        for(int i = 0 ; i < arr.length - 1; i++){
            if(arr[i] + k < arr[i + 1]) return arr[i] + k;
            k -=  arr[i + 1] - (arr[i] + 1);
        }
        return arr[arr.length - 1] + k;
    }
}