package leetcode.categorized.greedy;

import java.util.Arrays;

class P1663SmallestStringWithAGivenNumericValue {

    public String getSmallestString(int n, int k) {

        char[] res = new char[n];
        // Generate the initial string all 'a' string.
        // This will reduce k by n i.e. 1 deceremented for each 'a'
        Arrays.fill(res, 'a');
        k -= n;

        // Then, turn rightmost 'a' into 'z' i.e. ('a' + 25), or ('a' + k) while k is positive.
        while (k > 0) {
            res[--n] = (char) ('a' + Math.min(25, k));
            k -= Math.min(25, k);
        }

        return String.valueOf(res);
    }

    // MYSELF
    // DATE: 05-06-2021, second attempt
    // TIME: 40 mins
    // COMMENT: Was unable to solve last time, had to look at the solution.
    class SecondAttempt {
        public String getSmallestString(int n, int k) {
            StringBuilder sb = new StringBuilder();
            int remaining = n;
            while(sb.length() < n) {
                if(k - 26 >= remaining) {
                    sb.append("z");
                    remaining--;
                    k-= 26;
                } else if(remaining > 0){
                    int prefixACount = remaining - 1;
                    char middleChar = (char)(k - prefixACount - 1 + 'a');
                    sb.append(middleChar);
                    while(prefixACount > 0) {
                        prefixACount--;
                        sb.append("a");
                    }
                }
            }

            return sb.reverse().toString();
        }
    }


}