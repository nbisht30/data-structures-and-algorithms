package leetcode.categorized.math.arithmetics;

import java.util.HashMap;
import java.util.Map;

class P13RomanToInteger {
    // TIME: 10 mins, second attempt
    // COMMENTS: Last time I could not solve it in over an hour, took 10 mins this time.
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int num = 0;
        num += map.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            boolean a = (s.charAt(i) == 'V' || s.charAt(i) == 'X') && s.charAt(i - 1) == 'I';
            boolean b = (s.charAt(i) == 'L' || s.charAt(i) == 'C') && s.charAt(i - 1) == 'X';
            boolean c = (s.charAt(i) == 'M' || s.charAt(i) == 'D') && s.charAt(i - 1) == 'C';
            if (a || b || c) {
                num += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
            } else
                num += map.get(s.charAt(i));
        }
        return num;
    }
}