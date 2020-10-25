package leetcode.solved.categorized.greedy;

class P134GasStation {
    // MYSELF
    // FASTER THAN 100%
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] - cost[i] >= 0) {
                int index = startFromCurrIndex(gas, cost, i);
                if (i == index) return i;
                else if (index < i) return -1;
                else i = index;
            }
        }
        return -1;
    }

    int startFromCurrIndex(int[] gas, int[] cost, int index) {
        int gasLeft = 0;
        for (int i = 0; i < gas.length; i++) {
            int currIndex = (i + index) % gas.length;
            int currCost = cost[currIndex];
            gasLeft += gas[currIndex] - currCost;
            if (gasLeft < 0 && cost[currIndex] > 0) return currIndex;
        }
        return index;
    }
}