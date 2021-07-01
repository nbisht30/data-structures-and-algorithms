package leetcode.contests;

import java.util.HashSet;
import java.util.Set;

class Execution {
    int minDigits = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Execution execution = new Execution();
        execution.minSum(new int[] {9, 6, 4, 1}, 11, 0, 0, new HashSet<>());
        System.out.println(execution.minDigits);
    }

    void minSum(int[] arr, int target, int currSum, int currDigits, Set<Integer> checked) {

        if (currSum == target) {
            minDigits = Math.min(minDigits, currDigits);
            return;
        } else if (currSum > target) return;


        for (int i = 0; i < arr.length; i++) {
            if (checked.contains(arr[i])) continue;
            currSum += arr[i];
            checked.add(arr[i]);
            minSum(arr, target, currSum, currDigits + 1, checked);
            checked.remove(arr[i]);
            currSum -= arr[i];
        }

    }

}