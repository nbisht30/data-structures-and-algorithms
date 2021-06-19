package leetcode.categorized.sorting;

import java.util.ArrayList;
import java.util.List;

class P315CountOfSmallerNumbersAfterSelf {

    // EXPLANATION: https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/445769/merge-sort-CLEAR-simple-EXPLANATION-with-EXAMPLES-O(n-lg-n)
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums.length == 0) return result;

        int[] resArr = new int[nums.length];
        Element[] numsWithIndex = new Element[nums.length];
        for (int i = 0; i < nums.length; i++)
            numsWithIndex[i] = new Element(i, nums[i]);

        mergeSortAndCount(numsWithIndex, 0, nums.length - 1, resArr);
        for (int i : resArr) result.add(i);
        return result;
    }

    static Element[] mergeSortAndCount(Element[] numsWithIndex, int start, int end, int[] resArr) {
        if (start >= end) return new Element[]{numsWithIndex[start]};

        int mid = start + (end - start) / 2;

        Element[] leftHalf = mergeSortAndCount(numsWithIndex, start, mid, resArr);
        Element[] rightHalf = mergeSortAndCount(numsWithIndex, mid + 1, end, resArr);

        Element[] merged = mergeAndCount(leftHalf, rightHalf, resArr);
        return merged;
    }

    static Element[] mergeAndCount(Element[] leftHalf, Element[] rightHalf, int[] resArr) {
        Element[] merged = new Element[leftHalf.length + rightHalf.length];
        int indMerged = 0, indLeft = 0, indRight = 0;
        int numsInRightLessThanLeft = 0;

        while (indLeft < leftHalf.length && indRight < rightHalf.length) {
            if (rightHalf[indRight].value < leftHalf[indLeft].value) {
                numsInRightLessThanLeft++;
                merged[indMerged++] = rightHalf[indRight++];
            } else {
                int origInd = leftHalf[indLeft].originalIndex;
                // increment the existing value
                resArr[origInd] += numsInRightLessThanLeft;
                merged[indMerged++] = leftHalf[indLeft++];
            }
        }

        while (indLeft < leftHalf.length) {
            int origInd = leftHalf[indLeft].originalIndex;
            // increment the existing value
            resArr[origInd] += numsInRightLessThanLeft;
            merged[indMerged++] = leftHalf[indLeft++];
        }

        while (indRight < rightHalf.length) {
            merged[indMerged++] = rightHalf[indRight++];
        }
        return merged;
    }

    static class Element {
        int originalIndex;
        int value;

        public Element(int oIdx, int v) {
            originalIndex = oIdx;
            value = v;
        }
    }
}