package leetcode.categorized.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class P179LargestNumber {
    public static String largestNumber(int[] nums) {
        List<String> numsString = new ArrayList<>();
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
