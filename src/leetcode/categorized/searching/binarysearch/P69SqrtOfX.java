package leetcode.categorized.searching.binarysearch;

class P69SqrtOfX {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        int left = 1, right = x, mid;
        while(left <= right){
            mid = left + (right - left)/2; 
            if(mid == x / mid) return mid; // why not mid * mid ? => because in case of large integers it would overflow
            if(mid > x / mid) right = mid - 1;
            else left = mid + 1;
        }
        return right;
    }
}