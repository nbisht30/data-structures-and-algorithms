package leetcode.solved.categorized.graphs.dfs;

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
}

