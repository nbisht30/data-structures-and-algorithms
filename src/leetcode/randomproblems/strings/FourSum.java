package leetcode.randomproblems.strings;

import java.util.*;

/**
 * @author Nikhil Bisht
 * @date 05-04-2020
 */
public class FourSum {
    public static void main(String[] args) {
        fourSum(new int[]{0, 0, 0, 0}, 0);
    }

    public static List<List<Integer>> fourSumDebugMode(int[] nums, int target) {
        List<List<Integer>> finalList = new ArrayList<>();
        Map<Integer, List<Set<Integer>>> twoSumAndIndexPairs = new HashMap<>();
        Set<String> alreadyStoredQuads = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = nums[i] + nums[j];
                System.out.println("Num[" + i + "] : " + nums[i]);
                System.out.println("Num[" + j + "] : " + nums[j]);
                Set<Integer> tempSet = new HashSet<>();
                tempSet.add(i);
                tempSet.add(j);
                if (twoSumAndIndexPairs.containsKey(key)) {
                    System.out.println("An already contained KEY found : " + key);
                    twoSumAndIndexPairs.get(key).add(tempSet);
                } else {
                    List<Set<Integer>> tempList = new ArrayList<>();
                    tempList.add(tempSet);
                    twoSumAndIndexPairs.put(key, tempList);
                }
                int anotherKey = target - key;
                if (twoSumAndIndexPairs.containsKey(anotherKey)) {
                    System.out.println("ANOTHER KEY for reaching target is also found: " + anotherKey);
                    List<Set<Integer>> itrSetList = twoSumAndIndexPairs.get(anotherKey);
                    for (Set<Integer> indexSet : itrSetList) {
                        if (Collections.disjoint(tempSet, indexSet)) {
                            List<Integer> quadruplet = new ArrayList<>();
                            tempSet.forEach(item -> quadruplet.add(nums[item]));
                            indexSet.forEach(item -> quadruplet.add(nums[item]));
                            String qHash = getHash(quadruplet);
                            if (alreadyStoredQuads.contains(qHash)) {
                                System.out.println("Already contained in quads");
                                continue;
                            }
                            alreadyStoredQuads.add(qHash);
                            finalList.add(quadruplet);
                            System.out.println("Quadruplet stored for final result : " + quadruplet);
                        } else {
                            System.out.println("Sets didnt match.");
                        }
                    }
                }
                System.out.println("Stored: " + nums[i] + " and " + nums[j] + " against sum: " + key);
                System.out.println();
            }
        }
        System.out.println();
        twoSumAndIndexPairs.forEach((a, b) -> System.out.println(a + " : " + b));
        System.out.println();
        finalList.forEach(System.out::println);
        return finalList;
    }

    private static String getHash(List<Integer> quadruplet) {
        Collections.sort(quadruplet);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < quadruplet.size(); i++) {
            builder.append(quadruplet.get(i));
        }
        return builder.toString();
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> finalList = new ArrayList<>();
        Map<Integer, List<List<Integer>>> twoSumAndIndexPairs = new HashMap<>();
        Set<String> alreadyStoredQuads = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = nums[i] + nums[j];
                List<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(j);
                if (twoSumAndIndexPairs.containsKey(key)) {
                    twoSumAndIndexPairs.get(key).add(pair);
                } else {
                    List<List<Integer>> tempList = new ArrayList<>();
                    tempList.add(pair);
                    twoSumAndIndexPairs.put(key, tempList);
                }
                int anotherKey = target - key;
                if (twoSumAndIndexPairs.containsKey(anotherKey)) {
                    List<List<Integer>> itrList = twoSumAndIndexPairs.get(anotherKey);
                    for (List<Integer> pairList : itrList) {
                        if (Collections.disjoint(pair, pairList)) {
                            List<Integer> quadruplet = new ArrayList<>();
                            pair.forEach(item -> quadruplet.add(nums[item]));
                            pairList.forEach(item -> quadruplet.add(nums[item]));
                            String qHash = getHash(quadruplet);
                            if (alreadyStoredQuads.contains(qHash)) {
                                continue;
                            }
                            alreadyStoredQuads.add(qHash);
                            finalList.add(quadruplet);
                        }
                    }
                }
            }
        }
        return finalList;
    }

}
