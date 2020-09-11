package leetcode.solved.categorized.math.arithmetics;

class P7ReverseInteger {
    // Intuition: See leetcode solution explanation.
    public int reverse(int x) {
        int rev = 0;
        int lstDig = 0;
        while(x != 0){
            lstDig = x % 10;
            x /= 10;
            if(rev > Integer.MAX_VALUE/10 || 
               (rev == Integer.MAX_VALUE/10 && lstDig > 7))
                return 0;
            if(rev< Integer.MIN_VALUE/10 || 
               (rev == Integer.MIN_VALUE/10 && lstDig < -8)) 
                return 0;
            rev *= 10;
            rev += lstDig;
        }
        return rev;
    }
}