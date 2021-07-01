package leetcode.categorized.backtracking;

import java.util.ArrayList;
import java.util.List;

class P77Combinations {
    // MYSELF
    // TIME: 5 mins
    // DATE: 01-Jul-21
    // INTUITION: For every value of n you have two choices, either to include n in our combination or not no include it.
    class FirstSolution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            combinations(n, k, new ArrayList<>());
            return res;
        }

        void combinations(int n, int k, List<Integer> comb) {
            if (k == 0) {
                res.add(new ArrayList<>(comb));
                return;
            } else if (n == 0) return;

            comb.add(n);
            combinations(n - 1, k - 1, comb);
            comb.remove(comb.size() - 1);

            combinations(n - 1, k, comb);
        }
    }


    // MYSELF
    // TIME: 5 mins
    // DATE: 01-Jul-21
    // INTUITION: You include n in your combination then check for its combinations with all other numbers
    class SecondSolution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            combinations(n, k, new ArrayList<>());
            return res;
        }

        void combinations(int n, int k, List<Integer> comb) {
            if (k == 0) {
                res.add(new ArrayList<>(comb));
                return;
            }

            for (int i = n; i >= 1; i--) {
                comb.add(i);
                combinations(i - 1, k - 1, comb);
                comb.remove(comb.size() - 1);
            }
        }
    }

    // MYSELF
    // TIME: 5 mins
    // DATE: 01-Jul-21
    // COMMENTS: This is the most optimized solution, i - k >= 0 is a major optimization here.
    // Basically if at current value of i you dont have the remaining k numbers after i then there is no point in exploring this combination further.
    class ThirdSolution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            combinations(n, k, new ArrayList<>());
            return res;
        }

        void combinations(int n, int k, List<Integer> comb) {
            if (k == 0) {
                res.add(new ArrayList<>(comb));
                return;
            }

            for (int i = n; i - k >= 0; i--) {
                comb.add(i);
                combinations(i - 1, k - 1, comb);
                comb.remove(comb.size() - 1);
            }
        }
    }
}