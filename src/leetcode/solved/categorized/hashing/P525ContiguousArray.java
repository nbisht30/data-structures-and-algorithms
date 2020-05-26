package leetcode.solved.categorized.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nikhil Bisht
 * @date 14-04-2020
 */


/*
Problem: https://leetcode.com/problems/contiguous-array/
Video Explanation: https://www.youtube.com/watch?v=9ZyLjjk536U

Intuition:-
Lets say that input array given to us is: 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0
Looking at the array we can say the longest contiguous sub-array of equal number of 0s and 1s is starting
from index 1 and ending at last index and has five 0s and five 1s.

We maintain a variable "balance", incrementing it when we find a 1 and decrementing it when we find a 0.
We store the value of "balance" - "current Index(i)" in a map for value of balance at every index.

So we get a map like this:-
Balance(key): 1 2 .....
Index(value): 0 1 2 3 4 5 6 7 8 9 10

For the 0th index, we get balance as 1, we store it in the map as its not already present, along with the index 0;

For the 1st index, we get balance as 2, we store it in the map as its not already present, along with the index 1;

Now for the 2nd index we get the value of balance as 1, and we can see that 1 was already present in map as a key having value as 0
In other words we can say that some elements were present in the input array after the index 0 that have cancelled each other,
causing the balance going back to a value previously achieved.
In this case we store value of "currIndex[i.e i = 2] - map.get(balance) [i.e 0] => 2" in "maxL" as it is greater that its previous
value of 0. maxL maintains the length of largest sub-array of equal 0s and 1s.

Now for the 3rd index we get balance as 0, which means all elements from starting index of input array have cancelled each other
this 3rd index which is a total of 4 elements. Hence, we assign 4 to maxL as 4 was greater than its previous value of 2.

We continue with this process, key idea being that whenever we see a value of "balance" which was already preset in the map it means
that all elements after index present at map.get(balance) cancelled each other, and we can have a maxL = i - map.get(balance)
if its greater than its existing value. Also, whenever we get "balance" = 0, it means that all elements till now cancelled each other
and maxL = i + 1;
*/
public class P525ContiguousArray {

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0}));
    }

    public static int findMaxLength(int[] nums) {
        int balance = 0, maxL = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            balance += nums[i] == 1 ? 1 : -1;
            if(balance == 0){
                maxL = i + 1;
            }
            else if (map.containsKey(balance)) {
                maxL = Math.max(i - map.get(balance), maxL);
            } else {
                map.put(balance, i);
            }
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
