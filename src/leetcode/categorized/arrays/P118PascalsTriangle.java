package leetcode.categorized.arrays;

import java.util.ArrayList;
import java.util.List;

class P118PascalsTriangle {
    // MYSELF
    // TIME: 10 min
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        int size = 1;
        for(int i = 0 ; i < numRows; i++){
            List<Integer> list = new ArrayList<>(size);
            for(int j = 0; j < size; j++){
                if(j == 0 || j == size - 1) list.add(1);
                else list.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
            }

            res.add(list);
            size++;
        }

        return res;
    }
}