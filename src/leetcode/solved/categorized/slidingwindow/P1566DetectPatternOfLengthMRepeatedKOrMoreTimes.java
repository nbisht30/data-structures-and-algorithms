package leetcode.solved.categorized.slidingwindow;

class P1566DetectPatternOfLengthMRepeatedKOrMoreTimes {

    // MYSELF
    // TIME 44 mins
    public boolean containsPattern(int[] arr, int m, int k) {
        int s = 0, e = m - 1;
        int cnt = 0;
        int maxCnt = Integer.MIN_VALUE;
        while (e < arr.length) {
            int ns = e + 1;
            int ne = ns + m - 1;
            if (ne < arr.length) {
                int i = s, j = ns;
                boolean match = true;
                while (i <= e) {
                    if (arr[i] != arr[j]) {
                        match = false;
                        break;
                    }
                    i++;
                    j++;
                }
                if (match) {
                    cnt++;
                    s = ns;
                    e = ne;
                } else {
                    s++;
                    e++;
                    if (cnt > maxCnt) maxCnt = cnt;
                    cnt = 0;
                }
            } else {
                break;
            }
            if (cnt > maxCnt) maxCnt = cnt;
        }

        if (maxCnt + 1 >= k) return true;

        return false;
    }
}