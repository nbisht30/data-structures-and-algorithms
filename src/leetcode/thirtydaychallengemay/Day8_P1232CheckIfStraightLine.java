package leetcode.thirtydaychallengemay;

class Day8_P1232CheckIfStraightLine {
    public static void main(String[] args) {
        System.out.println(checkStraightLine(new int[][]{
                {8, 6}, {-2, 0}, {-3, -1}, {-6, -10}, {7, -1}, {-1, -7}, {5, 1}, {-7, 8}, {7, 8}, {0, 2}
        }));
    }

    /*
    Even though this question was listed as Easy on LC but it took me a lot of time as it involved a lot of maths
    for my tiny brain.

    Intuition: Best way to understand how to solve this problem is to plot the coordinates on a graph.
    All coordinates share a common property to be present on a line.
    Example: Assume coordinates are represented by [x,y], and if [0,1] and [5,11] are first two coordinates among all
    given coordinates, then the rest of the coordinates must share a property shared by the first two cordinates, for all
    to be present on a straight line.

    That property is: For every increase in the value of x form i-th to (i+1)-th coordinate
    of the amount equal to the difference of first and second X coordinate
    the Y coordinate must change by the difference of first and second Y coordinate.
    This whole property governs if other coordinates are present on the line created by the first two coordinates.
     */
    public static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return true;

        int diffX = Math.abs(coordinates[1][0] - coordinates[0][0]);
        int diffY = Math.abs(coordinates[1][1] - coordinates[0][1]);

        for (int i = 1; i + 1 < coordinates.length; i++) {
            if(diffX == 0){
                if(coordinates[i + 1][0] != coordinates[i][0]) return false;
            }else if(diffY == 0){
                if(coordinates[i + 1][1] != coordinates[i][1]) return false;
            }else{
                double quo = Math.abs(coordinates[i + 1][0] - coordinates[i][0]) / (double) diffX;
                double quoY = Math.abs(coordinates[i + 1][1] - coordinates[i][1]) / (double) diffY;
                if (quoY != quo) return false;
            }
        }
        return true;
    }
}