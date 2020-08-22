package leetcode.contests.weekly;

import java.util.HashMap;
import java.util.Map;

class P1553MinimumNumberOfDaysToEatNOranges {
    
    Map<Integer, Integer> dp = new HashMap<>();
    
    public int minDays(int n) {
        if (n <= 1)
            return n;
        if (!dp.containsKey(n))
            dp.put(n, 1 + Math.min(n % 2 + minDays(n / 2), n % 3 + minDays(n / 3)));
        return dp.get(n);
    }
    
    /*
    Intuition:-
  
    1. n%2 or n%3 is how much distance away n is from being divisible by 2 or 3.
    0 or 1 in case of divisibility by 2 and 0, 1 and 2 in case of divisibility by 3.
    This would be otherwise done by subtracting 1(step 1 in question) - doing it like this is the best way to minimize the steps.
    
    2. 1 is added because of operations(2nd or 3rd as specified in question) done to decrease n -> n/2 or n -> n/3
    We add 1 because it takes one day to eat n/2 or 2n/3 apples. 
    When we call that min we have already performed either operation 2 or 3 which leaves us with n - n/2 = n/2 or n - 2n/3 = n/3 apples
    
    Why is the second option n / 3 and not 2 * n / 3?
    Because if n is divisible by 3 you eat 2n/3 oranges which means you are left with n/3 oranges.
    
    Note: Cannot use array like we normally do in DP as size can be at max 2 * 10^9 which would cause Memory Limit Exceeded as in Java you cannot
    locally declare that much memory.
    
    Note: Normal DP where you built all possible values doent work. As input size is large (2 * 10^9) and at O(N) that would take a lot of time.
    
    More: https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/discuss/794088/PythonGolang-Intuitive-solution-with-Proof
    */
}