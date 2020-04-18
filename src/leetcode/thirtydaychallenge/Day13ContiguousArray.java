package leetcode.thirtydaychallenge;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nikhil Bisht
 * @date 14-04-2020
 */
//https://leetcode.com/problems/contiguous-array/
public class Day13ContiguousArray {

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0}));
    }

    public static int findMaxLength(int[] nums) {
        int balance = 0, maxL = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            balance += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(balance)) {
                maxL = Math.max(i - map.get(balance), maxL);
            } else {
                map.put(balance, i);
            }
            System.out.println(maxL);
        }
        return maxL;
    }


    /*
    ml = 8
    bal = 1
    1 1 0 0 1 1 0 1 0 1 0
    init 0 -1
    ind visited - 0 1 2 3 4 5 6 7 8 9 10
    1 0
    2 1

    */
}
