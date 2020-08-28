package leetcode.solved.categorized.math;

class P780ReachingPoints {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        return helper(sx, sy, tx, ty);
    }
    
    public boolean helper(int x, int y, int tx, int ty){
        // https://leetcode.com/problems/reaching-points/discuss/816596/explaination-for-math-dummies-like-me
        /*
        Intuition:-
        Keep subtracting the smaller of (tx, ty) from the larger of (tx, ty) and stop if
        tx becomes less than sx or ty becomes less than sy.
        
        But before performing subtraction, check if it is a case of one target coordinate
        (either of X or Y, not talking about both coordinates i.e the entire point) 
        becoming same as corresponding source coordinate, because if that target coordinate
        becomes same as its corresponding source cordinate, only the other coordinate needs
        to change afterwards. For eg. if at any iteration you have your tx and ty as
        tx = 9 and ty = 3 and your starting coordinates were x = 6 and y = 3, then only
        tx or simply X coordinate needs to change as Y coordinate has become fixed/same ie 3 
        Here, tx can be written as tx = x + n * y (i.e. 6 + 1 * 3) => tx - x = n * y
        => taking mod by y or ty(both same) => (tx - y) % y = (n * y) % y
        => (tx - y) % y == 0 as (n * y) % y  would be 0. So with just one condition i.e
        (tx - y) % y == 0 we can check if tx would reduce down to x or not. Same case with 
        your X coordinate getting same and Y still needs to be changed.
        
        Now, the solution with subtraction is good, but for very large input coordinates
        (upto 10^9) this is going to give TLE. So, we need to optimize our subtraction part.
        How? Instead of doing tx = tx - ty OR ty = ty - tx we can do tx = tx % ty OR 
        ty = ty % tx. Using % does the same thing but reduces multiple operations to a 
        single one. Eg. if ty = 100 and tx = 9 then you'd have ty = ty - tx execute 11 times
        to reach ty = 1 and tx = 9 (ty goes 91, 82, 73, 64, 55, 46, 37, 28, 19, 10, 1) 
        by doing 100 % 9 we're getting to ty = 1 in just one operation.
        
        */
        while(tx >= x && ty >= y){
            if(tx > ty) {
                if(y == ty) return (tx - x) % ty == 0;
                tx %= ty;
            }
            else {
                if(x == tx) return (ty - y) % tx == 0;
                ty %= tx;
            }
        }
        return false;
    }
}