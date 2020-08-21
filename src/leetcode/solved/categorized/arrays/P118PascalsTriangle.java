package leetcode.solved.categorized.arrays;

import java.util.ArrayList;
import java.util.List;

class P118PascalsTriangle {
    //MYSELF
    //Time: 10 min
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;

        res.add(new ArrayList<>());
        res.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = res.get(i - 1);
            List<Integer> newLst = new ArrayList<>();
            newLst.add(1);
            for (int j = 1; j < prev.size(); j++) {
                newLst.add(prev.get(j - 1) + prev.get(j));
            }
            newLst.add(1);
            res.add(newLst);
        }
        return res;
    }
}