package leetcode.solved.categorized.priorityqueue;

public class Client {
    public static void main(String[] args) {
        P218TheSkylineProblem skylineProblem = new P218TheSkylineProblem();
        int[][] buildings = {{2, 4, 7}, {2, 4, 5}, {2, 4, 6}};
//        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println("OP: " + skylineProblem.getSkyline(buildings));
    }
}
