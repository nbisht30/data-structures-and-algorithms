package leetcode.solved.categorized.priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

class P215KthLargestElementInArray {

    /*
    1. Sorting : O(nlogn) solution.
    2. Priority Queue : O(nlogn) solution + another pass to get the k-th largest
    3. Randomized Quick Select : O(n)
    */

    public int findKthLargest(int[] nums, int k) {
        return usingArraySort(nums, k);
        //         return quickSelect(nums, k - 1);
    }

    public int usingArraySort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k - 1];
    }

    public int usingHeaps(int[] nums, int k) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> b - a);
        for (int i : nums) {
            pQ.add(i);
        }

        for (int i = 1; i <= k; i++) {
            pQ.remove();
        }

        return pQ.remove();
    }

    // Using quick select algorithm
    int quickSelect(int nums[], int index) {
        // Randomization - > Brings the worst case time complexity
        // of quick select down to O(n)
        shuffle(nums);

        int hi = nums.length - 1, lo = 0;
        while (lo < hi) {
            int partIndex = partition(nums, lo, hi);
            if (index == partIndex) break;
            else if (index > partIndex) lo = partIndex + 1;
            else hi = partIndex - 1;
        }
        return nums[index];
    }


    /*
    Partition(this is the reverse of the traditional partiton algorithm)
    Usually we bring the smaller elements first, this one brings the larger elements
    than the pivot on the left, and greater elements on the right.
    */
    int partition(int[] nums, int lo, int hi) {
        int pivot = nums[hi]; // last element becomes pivot
        int swapInd = lo;
        for (int i = lo; i < hi; i++) {
            if (nums[i] >= pivot) {
                swap(nums, swapInd, i);
                swapInd++;
            }
        }
        swap(nums, swapInd, hi);
        return swapInd; // return the index of where pivot went.
    }

    void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    private void shuffle(int a[]) {
        Random random = new Random();
        for (int ind = 1; ind < a.length; ind++) {
            int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }
}