package leetcode.thirtydaychallengemay;

import java.util.ArrayList;
import java.util.List;

class Day22_P986IntervalListIntersections {
    public static void main(String[] args) {
        intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
    }

    // My implementation
    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        int st = 0, end = 0;
        int[][] finArr = new int[A.length + B.length][];
        int i = 0, j = 0;
        int finInd = 0;
        while (i < A.length && j < B.length) {
            int[] a = A[i];
            int[] b = B[j];

            if (a[1] < b[0]) {
                i++;
            } else if (b[1] < a[0]) {
                j++;
            } else {

                if (a[0] >= b[0]) {
                    st = a[0];
                } else {
                    st = b[0];
                }

                if (a[1] <= b[1]) {
                    end = a[1];
                    b[0] = a[1] + 1;
                    i++;
                } else {
                    end = b[1];
                    a[0] = b[1] + 1;
                    j++;
                }
                finArr[finInd++] = new int[]{st, end};
            }
        }

        int[][] retArr = new int[finInd][];
        for (int k = 0; k < finInd; k++) {
            retArr[k] = finArr[k];
        }
/*
        for (int k = 0; k < finInd; k++) {
            System.out.println(retArr[k][0] + " , " + retArr[k][1]);
        }
*/
        return retArr;
    }

    // A shorter version that is inherently doing the same thing.
    public int[][] intervalIntersectionBetter(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection

            // get the max of first element of A and B and then for second element of A and B
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi) // if there is an intersection
                ans.add(new int[]{lo, hi});

            // Remove the interval with the smallest endpoint
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}