package leetcode.categorized.hashing;

import java.util.HashMap;
import java.util.Map;

class P1814CountNicePairsInAnArray {
    // MYSELF
    // TIME: 45 mins
    // DATE: 16-06-21
    // CONTEST: Biweekly Contest 49 Virtual
    public int countNicePairs(int[] nums) {
        int[] rev = new int[nums.length];
        Map<Integer, Integer> pairCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            rev[i] = reverse(nums[i]);
            int diff = nums[i] - rev[i];
            pairCount.put(diff, pairCount.getOrDefault(diff, 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] - rev[i];
            count += pairCount.get(key) - 1;
            count = (int) (count % (Math.pow(10, 9) + 7));
            pairCount.put(key, pairCount.get(key) - 1);

        }
        return count;
    }

    int reverse(int n) {
        int res = 0;
        while (n > 0) {
            res *= 10;
            res += n % 10;
            n = n / 10;
        }
        return res;
    }
}