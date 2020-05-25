package leetcode.unsolved;

/**
 * @author Nikhil Bisht
 * @date 18-04-2020
 */
public class P343IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(15));
    }

    public static int integerBreak(int n) {
        if(n==3)
            return 2;
        if(n==5)
            return 6;
        double sq = Math.sqrt(n);
        int sqrtInt = (int) Math.floor(sq);
        int t = n;
        int prod = 1;
        int sum = 0;
        while (sqrtInt < n - sum) {
            prod *= sqrtInt;
            sum += sqrtInt;
            t -= sqrtInt;
        }
        return prod * (t);
    }
}
