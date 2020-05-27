package leetcode.solved.categorized.fastslowpointer.floydcycledetection;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/find-the-duplicate-number/
class P287FindTheDuplicateNumber {

    /*
    This is a simple solution for this problems using sets but this takes a lot of extra space.
     */
    public int findDuplicate(int[] nums) {
        Set<Integer> dups = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (dups.contains(nums[i])) return nums[i];
            else dups.add(nums[i]);
        }
        return -1;
    }

    /*
    TODO: The O(1) space solution for this problems is using cycle detection
    Code this.
    https://leetcode.com/problems/find-the-duplicate-number/solution/ : Check approach 3

    https://www.youtube.com/watch?v=iKjftj3p8ME

    https://keithschwarz.com/interesting/code/?dir=find-duplicate


    First part of this problem is proving that one duplicate element must exist:-
    Given, arrays nums has n + 1 integers and each integer is between 1 and n(inclusive)

    This is a straightforward application of the Pegionhole principle(See Pegionhole Principle here:
    https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-042j-mathematics-for-computer-science-spring-2015/counting/tp10-1/the-pigeonhole-principle/)
    which basically is a counting principle that says that if there are more Pegions than pegionholes then you must have at least
    2 Pegions in the same hole.



     */


    /*
    Using Negation:
    This approach utilizes the fact that array has size as n + 1 so indices range from 0 to n and value of each number
    can be between 1 to n.

    The best video explanation: https://www.youtube.com/watch?v=s_nYIsbPqqQ

    The problems with this approach: Someone might say that you are changing the array contents.(But we can also take absolute
    for each value in an extra pass)
     */
    public int findDuplicateInOrderNWithoutExtraSpace(int[] nums) {
        /*
        Intuition:
        nums contains n + 1 elements so nums.length = n + 1
        so basically the indices range from 0 to n

        also each element is between 1 and n(both inclusive) so whatever elements
        we have in the array, we'll also have indices corresponding to them.
        */
        for (int i = 0; i < nums.length; i++) {

            // we get the absolute value present in current i and use it as
            // index later on
            int index = Math.abs(nums[i]);

            // we check if nums[index] is already negated, if yes then we must have
            // negated it and now since we've found it again we'll return it
            // as it would be duplicate.
            if (nums[index] < 0) {
                return index;
            } else {
                nums[index] = - nums[index];
            }

        }
        return -1;
    }
}