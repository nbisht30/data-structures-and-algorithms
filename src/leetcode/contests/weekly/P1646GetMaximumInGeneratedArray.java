package leetcode.contests.weekly;

class P1646GetMaximumInGeneratedArray {
    // Time: 7:18 mins
    public int getMaximumGenerated(int n) {
        if(n == 0) return 0;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        int max = 1;

        for(int i = 1; i * 2 + 1 <= n; i++) {
            arr[2 * i] = arr[i];
            max = Math.max(arr[2 * i], max);
            arr[2 * i + 1] = arr[i] + arr[i + 1];
            max = Math.max(arr[2 * i + 1], max);
        }

        return max;
    }
}