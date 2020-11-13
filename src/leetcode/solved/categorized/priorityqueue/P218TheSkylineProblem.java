package leetcode.solved.categorized.priorityqueue;

import java.util.*;

class P218TheSkylineProblem {
    /*
    1. Prepare a new array of building points and sort it using a special comparator. Properties
    of the comparator are present in the code itself as comments.
    2. Iterate over the new array:-
    - When you encounter the start of a building, you push the height of that building in a priorty
      queue.
    - If the max in the priority queue(max heap) changes after pushing, it means this building has
      the greatest height than all other buildings overlapping at that start point, so add it to
      the final answer.
    - Also, when you encounter the end of building, you need to remove that building from the priorty
      queue(by removing the height of that building from pq) and while removing if the max changes,
      it means that this building's end should be a part of the final answer.
    */

    public List<List<Integer>> getSkyline(int[][] buildings) {
        BuildingPoint[] points = getSortedBuildingPointArray(buildings);
        return getSkylineUsingSortedBuildingPoints(points);
    }

    BuildingPoint[] getSortedBuildingPointArray(int[][] buildings) {
        int size = buildings.length * 2; // Each building will have two points
        BuildingPoint[] points = new BuildingPoint[size];
        int index = 0;

        for (int building[] : buildings) {
            points[index] = new BuildingPoint();
            points[index].x = building[0];
            points[index].y = building[2];
            points[index].isStart = true;

            points[index + 1] = new BuildingPoint();
            points[index + 1].x = building[1];
            points[index + 1].y = building[2];
            points[index + 1].isStart = false;

            index += 2;
        }

        Comparator<BuildingPoint> comparator = (a, b) -> {
            if (a.x != b.x) return a.x - b.x;
            else {
                // if both are start then higher height building should be picked first
                if (a.isStart && b.isStart) return b.y - a.y;
                    // if both are ends then lower height building should be picked first
                else if (!a.isStart && !b.isStart) return a.y - b.y;
                    //if one is start and other is end, then start should appear before end
                else return a.isStart ? -1 : 1;
            }
        };

        Arrays.sort(points, comparator);
        for (BuildingPoint point : points) {
            System.out.println("point = " + point);
        }
        return points;
    }

    List<List<Integer>> getSkylineUsingSortedBuildingPoints(BuildingPoint[] points) {
        int prevMaxHt = 0;
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // Max heap
        pq.offer(0);
        for (int i = 0; i < points.length; i++) {
            if (points[i].isStart) {
                pq.offer(points[i].y);
                int newMaxHt = pq.peek();
                if (newMaxHt > prevMaxHt) {
                    List<Integer> resPt = new ArrayList<>();
                    resPt.add(points[i].x);
                    resPt.add(points[i].y);
                    result.add(resPt);
                    prevMaxHt = newMaxHt;
                }
            } else {
                pq.remove(points[i].y);
                int newMaxHt = pq.peek();
                if (prevMaxHt > newMaxHt) {
                    List<Integer> resPt = new ArrayList<>();
                    resPt.add(points[i].x);
                    resPt.add(newMaxHt);
                    result.add(resPt);
                    prevMaxHt = newMaxHt;
                }
            }
        }
        return result;
    }

    class BuildingPoint {
        int x;
        int y;
        boolean isStart;

        @Override
        public String toString() {
            return "BuildingPoint{" +
                    "x=" + x +
                    ", y=" + y +
                    ", isStart=" + isStart +
                    '}';
        }
    }
}