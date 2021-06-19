package leetcode.categorized.hashing;

/**
 * @author Nikhil Bisht
 * @date 07-04-2020
 */

public class P1426CountingElements {
    //TIME: 2 mins
    public int countElements(int[] arr) {

        int count[] = new int[10001];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int output = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count[arr[i] + 1] >= 1) {
                output++;
            }
        }
        return output;
    }
}
