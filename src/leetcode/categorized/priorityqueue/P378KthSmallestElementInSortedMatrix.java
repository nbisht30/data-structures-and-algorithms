package leetcode.categorized.priorityqueue;

import java.util.PriorityQueue;

// @TODO:Understand the Binary Search Approach
// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/394294/Using-Binary-Search-in-Java-and-analysis
class P378KthSmallestElementInSortedMatrix {
    public int usingHeaps(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                pq.add(matrix[i][j]);
            }
        }

        for (int i = 1; i < k; i++) {
            pq.remove();
        }

        return pq.remove();
    }

    public int[] divideAndMerge(int[][] matrix, int startRow, int endRow) {
        int mid = endRow / 2;
        if (startRow >= endRow) {
            return matrix[endRow];
        }
        int[] part1 = divideAndMerge(matrix, startRow, mid);
        int[] part2 = divideAndMerge(matrix, mid + 1, endRow);

        return sortedMerge(part1, part2);
    }

    private static int[] sortedMerge(int[] a, int[] b) {
        int[] arr = new int[a.length + b.length];
        int aInd = 0, bInd = 0;
        for (int arrInd = 0; arrInd < arr.length; arrInd++) {
            if (aInd < a.length && bInd < b.length) {
                if (a[aInd] <= b[bInd]) {
                    arr[arrInd] = a[aInd++];
                } else {
                    arr[arrInd] = b[bInd++];
                }
            } else if (aInd < a.length) {
                arr[arrInd] = a[aInd++];
            } else {
                arr[arrInd] = b[bInd++];
            }
        }
        return arr;
    }
}