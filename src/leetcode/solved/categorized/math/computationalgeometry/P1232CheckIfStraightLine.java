package leetcode.solved.categorized.math.computationalgeometry;

class P1232CheckIfStraightLine {
    public static void main(String[] args) {
        System.out.println(checkStraightLine(new int[][]{
                {8, 6}, {-2, 0}, {-3, -1}, {-6, -10}, {7, -1}, {-1, -7}, {5, 1}, {-7, 8}, {7, 8}, {0, 2}
        }));
    }

    // NEEDED HELP, previously submitted solution did not work.
    public static boolean checkStraightLine(int[][] coordinates) {
        // https://leetcode.com/problems/check-if-it-is-a-straight-line/discuss/408984/JavaPython-3-check-slopes-short-code-w-explanation-and-analysis.
        int x0 = coordinates[0][0], x1 = coordinates[1][0],
                y0 = coordinates[0][1], y1 = coordinates[1][1];
        int dx = x1 - x0, dy = y1 - y0;
        for (int c[] : coordinates) {
            int x = c[0], y = c[1];
            if (dx * (y - y1) != dy * (x - x1)) return false;
        }
        return true;
    }
}