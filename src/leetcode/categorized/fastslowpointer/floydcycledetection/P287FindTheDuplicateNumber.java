package leetcode.categorized.fastslowpointer.floydcycledetection;

import java.util.HashSet;
import java.util.Set;

class P287FindTheDuplicateNumber {

    //1. Using Sets:
    public int findDuplicate(int[] nums) {
        Set<Integer> dups = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (dups.contains(nums[i])) return nums[i];
            else dups.add(nums[i]);
        }
        return -1;
    }

    //2. Using Floyds cycle detection(tortoise and hare):
    /*
    EXPLANATION:
    https://leetcode.com/problems/find-the-duplicate-number/solution/ : Check approach 3
    https://keithschwarz.com/interesting/code/?dir=find-duplicate
    https://www.youtube.com/watch?v=iKjftj3p8ME

    First part of this problem is proving that one duplicate element must exist:-
    Given, arrays nums has n + 1 integers and each integer is between 1 and n(inclusive)

    This is a straightforward application of the Pegionhole principle(See Pegionhole Principle here:
    https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-042j-mathematics-for-computer-science-spring-2015/counting/tp10-1/the-pigeonhole-principle/)
    which basically is a counting principle that says that if there are more Pegions than pegionholes then you must have at least
    2 Pegions in the same hole.

    So here you can say you have n + 1 Pegionholes/Elements but the actual number of different Pegions/Numbers
    can only be n (i.e from 1 to n), so there has to be an extra 1 Pegion/Number.
     */


    /*
    APPROACH: Using Negation:
    This approach utilizes the fact that array has size as n + 1 so indices range from 0 to n and value of each number
    can be between 1 to n.

    The best video explanation: https://www.youtube.com/watch?v=s_nYIsbPqqQ

    The problem with this approach: Someone might say that you are changing the array contents.(But we can also take absolute
    for each value in an extra pass)
    */
    public int findDuplicateInOrderNWithoutExtraSpace(int[] nums) {
        /*
        INTUITION:
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
            // negated it earlier and found it again which means that it would be the duplicate we intended to find.
            if (nums[index] < 0) {
                return index;
            } else {
                nums[index] = -nums[index];
            }

        }
        return -1;
    }
}