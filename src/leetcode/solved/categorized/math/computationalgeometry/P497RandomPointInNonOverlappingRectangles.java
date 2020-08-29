package leetcode.solved.categorized.math.computationalgeometry;

import java.util.Random;

class P497RandomPointInNonOverlappingRectangles {
    // NEEDED HELP
    // Intuition: https://www.youtube.com/watch?v=S9u_tMjD9oE

    Random rd = new Random(); //For random number generation
    
    int totalPoints = 0; // Need to calculate total number of points in all rectangles
    int totalPointsArr[]; // Keep storing latest values of total in this array after each iteration.
    // This is done for uniform selection of points in the pick()
    // This is the main constraint in the question: "uniformily picks an integer point"
    int rects[][];
    
    public P497RandomPointInNonOverlappingRectangles(int[][] rects) {
        this.rects = rects;
        totalPointsArr = new int[rects.length];
        int i = 0;
        for(int[] rect : rects){
            totalPoints += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1); // Formula gives the total number of points in one rectangle
            // The one is added because for eg. if x1 = 2 and x2 = 3 then x2 - x1 = 1, so width is 1 but an edge of length one covers two points, so we need to add 1
            totalPointsArr[i++] = totalPoints;
        }
    }
    
    public int[] pick() {
        // Get random point's index/location from 0 to totalPoints - 1;
        int randPtInd = rd.nextInt(totalPoints) + 1;

        // Binary Search in the totalPointsArr for the rectangle in which this randPtInd lies
        int lo = 0, hi = rects.length -1;
        while(lo < hi){
            int mid = lo + (hi - lo)/ 2;
            if(randPtInd > totalPointsArr[mid]) // Point lies on the right side of array
                lo = mid + 1;
            else
                hi = mid;
        } // When lo >= hi and loop terminates, lo corresponds to the rectangle in rects that has the random point.
        
        // Get a random point for rectangle at index lo
        int[] randRect = rects[lo];
        int randX = rd.nextInt(randRect[2] - randRect[0] + 1) + randRect[0];
        int randY = rd.nextInt(randRect[3] - randRect[1] + 1) + randRect[1];
        
        int[] rndPt = new int[2];
        rndPt[0] = randX;
        rndPt[1] = randY;
        
        return rndPt;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */