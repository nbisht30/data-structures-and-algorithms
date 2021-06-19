package leetcode.categorized.slidingwindow;

class P1566DetectPatternOfLengthMRepeatedKOrMoreTimes {

    // MYSELF
    // TIME: 44 mins
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

    // MYSELF
    // TIME: Did take similar time but approach is cleaner.
    public boolean containsPatternSecondAttempt(int[] arr, int m, int k) {

        for(int begin = 0; begin + 2 * m <= arr.length; begin++) {
            int end = begin + m - 1;
            int count = 1; // pattern is already present once
            for (int i = end + 1, offset = 0; i < arr.length; i++) {
                if(arr[begin + offset] != arr[i]) break;
                offset++;
                if(offset == m) {
                    count++;
                    offset = 0;
                }
            }
            if(count >= k) return true;
        }
        return false;
    }
}