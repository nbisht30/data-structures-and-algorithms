package leetcode.contests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Execution {
    int minDigits = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Execution execution = new Execution();
        List<Object> array = new ArrayList<>();
        array.add(5);
        array.add(2);
        List<Object> a1 = new ArrayList<>();
        a1.add(7);
        a1.add(-1);
        array.add(a1);
        array.add(3);
        a1 = new ArrayList<>();
        a1.add(6);
        List<Object> a2 = new ArrayList<>();
        a2.add(-13);
        a2.add(8);
        a1.add(a2);
        a1.add(4);
        array.add(a1);
        System.out.println(productSum(array));
    }

    public static int productSum(List<Object> array) {
        return helper(array, 1);
    }

    public static int helper(List<Object> array, int depth) {
        int productSum = 0;
        for(Object item : array) {
            if(item instanceof ArrayList) {
                productSum += helper((ArrayList<Object>)item, depth + 1) * depth;
            } else {
                productSum += (Integer) item * depth;
            }
        }
        return productSum;
    }
}