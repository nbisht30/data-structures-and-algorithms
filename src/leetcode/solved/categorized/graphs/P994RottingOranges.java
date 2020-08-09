package leetcode.solved.categorized.graphs;

import java.util.LinkedList;

class P994RottingOranges {

    class Point{
        int i;
        int j;

        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        LinkedList<Point> rotten = new LinkedList<>();
        int fresh = 0, absent = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2) rotten.add(new Point(i,j));
                else if(grid[i][j] == 1) fresh++;
                else absent++;
            }
        }

        int countMin = 0;
        int counterCycle = 0;
        int sizeForCycle = rotten.size();
        while(rotten.size() > 0 && fresh > 0){
            Point temp = rotten.removeFirst();
            counterCycle++;
            fresh -= makeAdjacentRotten(temp, rotten, grid);
            if(fresh == 0 || counterCycle == sizeForCycle){
                countMin++;
                counterCycle = 0;
                sizeForCycle = rotten.size();
            }
        }

        return fresh > 0 ? -1 : countMin;

    }

    private int makeAdjacentRotten(Point point, LinkedList<Point> rotten, int[][] grid){
        int x = point.i;
        int y = point.j;
        int rotted = 0;
        if(x >= 0 && x < grid.length && y >= 0 && y < grid[x].length){  //Safety Check: If x and y lie within the matrix
            if(x + 1 < grid.length && grid[x + 1][y] == 1){
                grid[x + 1][y] = 2;
                rotten.add(new Point(x + 1, y));
                rotted++;
            }

            if(x - 1 >= 0 && grid[x - 1][y] == 1){
                grid[x - 1][y] = 2;
                rotten.add(new Point(x - 1, y));
                rotted++;
            }

            if(y + 1 < grid[x].length && grid[x][y + 1] == 1){
                grid[x][y + 1] = 2;
                rotten.add(new Point(x, y + 1));
                rotted++;
            }

            if(y - 1 >= 0 && grid[x][y - 1] == 1){
                rotten.add(new Point(x, y - 1));
                grid[x][y - 1] = 2;
                rotted++;
            }
        }

        return rotted;
    }
}