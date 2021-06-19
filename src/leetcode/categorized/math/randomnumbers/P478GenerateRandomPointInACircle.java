package leetcode.categorized.math.randomnumbers;

import java.util.Random;

class P478GenerateRandomPointInACircle {
    // EXPLANATION : https://www.youtube.com/watch?v=0AC-TjfomZw&ab_channel=CodingDecoded
    double radius, x_center, y_center;
    Random rand;

    public P478GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        this.rand = new Random();
    }

    public double[] randPoint() {

        double xRand = getRandomPoint(x_center, radius);
        double yRand = getRandomPoint(y_center, radius);

        while (liesOutsideCircle(xRand, yRand)) {
            xRand = getRandomPoint(x_center, radius);
            yRand = getRandomPoint(y_center, radius);
        }
        return new double[]{xRand, yRand};
    }

    private boolean liesOutsideCircle(double x, double y) {
        return (x - x_center) * (x - x_center) + (y - y_center) * (y - y_center) > (radius * radius);
    }

    // Returns random point between (point - dist) to (point + dist)
    private double getRandomPoint(double point, double dist) {
        double rand0To2xDist = rand.nextDouble() * (2 * dist); // nextDouble() gives you floating number from 0 to 1.0
        return point - dist + rand0To2xDist;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */