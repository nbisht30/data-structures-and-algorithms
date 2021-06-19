package leetcode.categorized.graphs.dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class P841KeysAndRooms {
    // MYSELF
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int numRooms = rooms.size();
        Stack<Integer> stack = new Stack<>();
        boolean[] seen = new boolean[numRooms];
        stack.push(0);
        seen[0] = true;

        while (!stack.isEmpty()) {

            int currKey = stack.pop();
            List<Integer> roomKeys = rooms.get(currKey);
            for (int roomKey : roomKeys) {
                if (!seen[roomKey]) {
                    seen[roomKey] = true;
                    stack.push(roomKey);
                }
            }

        }

        for (boolean status : seen) if (!status) return false;
        return true;
    }


    // MYSELF
    // DATE: 05-06-21, second attempt
    // TIME: 10:50 mins
    // APPROACH: Queue.
    public boolean canVisitAllRoomsSecondAttempt(List<List<Integer>> rooms) {

        boolean[] vis = new boolean[rooms.size()];
        vis[0] = true;

        LinkedList<List<Integer>> queue = new LinkedList<>();
        queue.add(rooms.get(0));

        while (!queue.isEmpty()) {
            List<Integer> room = queue.removeFirst();
            for (int r : room) {
                if (vis[r]) continue;
                vis[r] = true;
                queue.add(rooms.get(r));
            }
        }

        for (boolean status : vis) if (!status) return false;
        return true;
    }


}

