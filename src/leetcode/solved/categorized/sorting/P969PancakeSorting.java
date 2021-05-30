package leetcode.solved.categorized.sorting;

import java.util.ArrayList;
import java.util.List;

class P969PancakeSorting {

    // NEEDED HELP
    class FirstAttempt {
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


    // MYSELF
    // DATE: 30-05-21, second attempt
    // TIME: 29 mins
    // COMMENTS: Struggled initially to understand the question, instead of returning the indexes at which reverse was taking place i.e. k,
    // returned the sorted array. But solution is more compact and optimized than last time.
    class SecondAttempt {
        public List<Integer> pancakeSort(int[] arr) {
            List<Integer> list = new ArrayList<>(arr.length);
            for (int i = arr.length - 1; i >= 0; i--) {
                int max = getMax(arr, 0, i);
                if (max == i) continue;
                reverse(arr, 0, max);
                reverse(arr, 0, i);
                list.add(max + 1);
                list.add(i + 1);
            }
            return list;
        }

        private int getMax(int[] arr, int st, int end) {
            int index = st;
            for (int i = st + 1; i <= end; i++) {
                if (arr[i] > arr[index]) index = i;
            }
            return index;
        }

        private void reverse(int[] arr, int st, int end) {
            for (int i = st, j = end; i < j; i++, j--) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
    }
}