package leetcode.solved.categorized.bitmanipulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Nikhil Bisht
 * @date 02-04-2020
 */
public class P136SingleNumber {
    //Find the number which occurs only once in an array with all other number appearing twice.
    public static void main(String[] args) {
        System.out.println(singleNumberMaps(new int[]{1, 2, 3, 2, 3, 4, 1}));
        System.out.println(singleNumberUsingMaths(new int[]{1, 2, 3, 2, 3, 4, 1}));
    }

    public static int singleNumberMaps(int[] nums) { //O(1) but uses space.
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : nums) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        for (int key : nums) {
            if (countMap.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }

    public static int singleNumberUsingMaths(int[] nums) {  //2∗(a+b+c)−(a+a+b+b+c)=c
        int sumAll = 0;
        int sumOfUniques = 0;
        Set<Integer> uniques = new HashSet<>();
        for (int i : nums) {
            sumAll += i;
            if (!uniques.contains(i)) {
                sumOfUniques += i;
                uniques.add(i);
            }
        }
        return 2 * sumOfUniques - sumAll;
    }

    /*
    If we take XOR of zero and some bit, it will return that bit
    a ⊕ 0 = a
    If we take XOR of two same bits, it will return 0
    a ⊕ a = 0
    a ⊕ b ⊕ a=(a ⊕ a) ⊕ b = 0 ⊕ b = b
    So we can XOR all bits together to find the unique number.
     */

    public static int singleNumberUsingBitMaths(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}

