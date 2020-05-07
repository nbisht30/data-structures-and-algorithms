package leetcode.thirtydaychallengeapril;

import java.util.Arrays;

/**
 * @author Nikhil Bisht
 * @date 14-04-2020
 */
//https://leetcode.com/problems/contiguous-array/
public class Day12LastStoneWeight {

    public static void main(String[] args) {
//        System.out.println(lastStoneWeight(new int[]{12, 7, 42, 9, 8, 13, 11}));
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }

    public static int lastStoneWeightDebug(int[] stones) {
        if (stones.length == 0) return 0;
        if (stones.length == 1) return stones[0];
        if (stones.length == 2) return stones[1] > stones[0] ? stones[1] - stones[0] : stones[0] - stones[1];

        Arrays.sort(stones);
        for (int i : stones)
            System.out.print(i + " ");
        System.out.println();
        int st1, st2;
        int rem, i;
        if (stones.length == 1)
            return stones[0];
        if (stones.length == 2) return stones[1] - stones[0];
        st1 = stones[stones.length - 1];
        st2 = stones[stones.length - 2];
        for (i = stones.length - 1; i - 1 > 0; i--) {
            System.out.println("i: " + i);
            System.out.println("Old st1: " + st1 + " | Old st2: " + st2);
            if (st1 == st2) {
                System.out.println("Cancelled each other.");
                stones[i] = 0;
                stones[i - 1] = 0;
                if (i >= 3) {
                    st1 = stones[i - 2];
                    st2 = stones[i - 3];
                    i--;
                }
            } else {
                rem = st1 - st2;
                System.out.println("Rem: " + rem);
                if (rem >= stones[i - 2]) {
                    System.out.println("St1: rem :" + rem);
                    System.out.println("St2: stones[" + (i - 2) + "] :" + stones[i - 2]);
                    stones[i - 1] = st1 = rem;
                    st2 = stones[i - 2];
                } else {
                    for (int j = i - 2; j >= 0; j--) {
                        if (rem >= stones[j]) {
                            stones[j + 1] = rem;
                            System.out.println(rem + " i.e rem inserted at " + (j + 1));
                            break;
                        } else {
                            stones[j + 1] = stones[j];
                            System.out.println(stones[j] + " shifted to " + (j + 1));
                            if (j == 0) {
                                stones[j] = rem;
                                System.out.println(rem + " i.e rem inserted at " + (j));
                                break;
                            }
                        }
                    }
                    st1 = stones[i - 1];
                    st2 = stones[i - 2];
                    System.out.println("St1: stones[" + (i - 1) + "] :" + st1);
                    System.out.println("St2: stones[" + (i - 2) + "] :" + st2);
                }
            }
            for (int x : stones)
                System.out.print(x + " ");
            System.out.println();
            System.out.println();
        }
        return Math.abs(stones[1] - stones[0]);
    }

    public static int lastStoneWeight(int[] stones) {
        if (stones.length == 0) return 0;
        if (stones.length == 1) return stones[0];
        if (stones.length == 2) return stones[1] > stones[0] ? stones[1] - stones[0] : stones[0] - stones[1];

        Arrays.sort(stones);
        int st1, st2;
        int rem, i;
        if (stones.length == 1)
            return stones[0];
        if (stones.length == 2) return stones[1] - stones[0];
        st1 = stones[stones.length - 1];
        st2 = stones[stones.length - 2];
        for (i = stones.length - 1; i - 1 > 0; i--) {
            if (st1 == st2) {
                stones[i] = 0;
                stones[i - 1] = 0;
                if (i >= 3) {
                    st1 = stones[i - 2];
                    st2 = stones[i - 3];
                    i--;
                }
            } else {
                rem = st1 - st2;
                if (rem >= stones[i - 2]) {
                    stones[i - 1] = st1 = rem;
                    st2 = stones[i - 2];
                } else {
                    for (int j = i - 2; j >= 0; j--) {
                        if (rem >= stones[j]) {
                            stones[j + 1] = rem;
                            break;
                        } else {
                            stones[j + 1] = stones[j];
                            if (j == 0) {
                                stones[j] = rem;
                                break;
                            }
                        }
                    }
                    st1 = stones[i - 1];
                    st2 = stones[i - 2];
                }
            }
        }
        return Math.abs(stones[1] - stones[0]);
    }
}
