package leetcode.solved.categorized.sorting;

import java.util.ArrayList;
import java.util.List;

class P969PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        int currSize = A.length;

        List<Integer> list = new ArrayList<>();

        boolean sorted = true;
        for (int i = A.length - 1; i > 0; i--) {
            if (A[i] < A[i - 1]) {
                sorted = false;
                break;
            }
        }
        if (sorted) return list;

        while (currSize > 1) {
            int mi = findMax(A, currSize);
            if (mi != 0) {
                flip(A, mi);
                list.add(mi + 1); // Need to add index + 1 as this is expected in problem
            }
            flip(A, currSize - 1);
            list.add(currSize); // Need to add index + 1 as this is expected in problem

            currSize--;
        }
        return list;
    }

    public void flip(int[] A, int n) {
        for (int i = 0; i < n; i++, n--) {
            int temp = A[i];
            A[i] = A[n];
            A[n] = temp;
        }
    }

    public int findMax(int[] A, int currSize) {
        int max = Integer.MIN_VALUE;
        int mi = 0;
        for (int i = 0; i < currSize; i++) {
            if (A[i] > max) {
                max = A[i];
                mi = i;
            }
        }
        return mi;
    }
}