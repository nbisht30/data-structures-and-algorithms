package leetcode.categorized.searching.binarysearch;
// https://leetcode.com/problems/valid-perfect-square/
class P367ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        return isPerfectSquareBinarySearch(num);
    }

     public boolean isPerfectSquareTrivial(int num) { //TLE
        if(num == 1) return true;
        for(int i = 2;i * i<= num; i++){
            // if(i * i == num) return true;
            if ((num % i == 0) && (num / i == i)) {
                return true;
            }
        }
        return false;
    }

    // MYSELF
    // TIME: 20 Mins
    // DATE: 09-May-2021
    // COMMENTS: Was still getting TLE for max int input, because mid * mid was creating overflow
    // in (mid * mid == num) condition and was evaluating to true so had to look for an alternative
    // it can be written as mid == num / mid, but you also need to check that its fully divisible, so
    // num % mid == 0 is also added.
    public boolean isPerfectSquareBinarySearch(int num) {
         int lo = 1, hi = num, mid;
         while(lo <= hi){
             mid = lo + (hi - lo) / 2;
             if(mid == num / mid && num % mid == 0) return true;
             else if(mid < num / mid) lo = mid + 1;
             else hi = mid - 1;
         }
         return false;
    }
}