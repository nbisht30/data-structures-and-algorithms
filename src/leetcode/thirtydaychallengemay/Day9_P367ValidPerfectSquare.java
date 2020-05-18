package leetcode.thirtydaychallengemay;

class Day9_P367ValidPerfectSquare {
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
    
     public boolean isPerfectSquareBinarySearch(long num) {
        if(num < 1) return false;
        if(num == 1) return true;
        
        long lo = 1, hi = num;
         
        long mid = (lo + hi)/2;
         
        while(lo <= hi){
            if(mid * mid == num) return true;
            else if( mid * mid < num ) {
                //search right
                lo = mid + 1;
            }else {
                hi = mid - 1;
                //search left
            }
             mid = (lo + hi)/2;
        }
        return false;
    }
}