package leetcode.solved.categorized.recursion;

class P50PowOfXAsN {
    public double myPow(double x, int n) {
        if(n >= 0) return forPositive(x, n);
        else return forNegative(x, n);
    }
    
    double forPositive(double x, int n){
        if(n == 0) return 1;
        
        double subProbRes = forPositive(x, n / 2);
        if(n % 2 == 0) return subProbRes * subProbRes;
        else return x * subProbRes * subProbRes;
    }
    
    double forNegative(double x, int n){
        if(n == -1) return 1 / x;
        double subProbRes = forNegative(x, n / 2);
        
        if(n % 2 == 0) return subProbRes * subProbRes;
        else return (1/x) * subProbRes * subProbRes;
    }
}