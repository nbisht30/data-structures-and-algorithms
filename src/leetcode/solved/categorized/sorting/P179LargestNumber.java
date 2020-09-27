package leetcode.solved.categorized.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class P179LargestNumber {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{10,2}));
    }
    public static String largestNumber(int[] nums) {
        List<String> numsString = new ArrayList<String>();
        for (int i : nums)
            numsString.add(Integer.toString(i));
        Collections.sort(numsString, (a, b) -> (b + a).compareTo(a + b));
        if (numsString.get(0).equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for(String s : numsString) sb.append(s);
        return sb.toString();
    }
}

/*
[3,30,34000,5,9]

9530340003
9533400030
9533034000
*/