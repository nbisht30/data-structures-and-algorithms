package leetcode.categorized.strings;

public class P1347MinimumStepsToMakeTwoStringsAnagram {
    public int minSteps(String s, String t) {
        int count[] = new int[26];
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        for (int i = 0; i < T.length; i++) {
            count[T[i] - 97]++;
        }
        int nC = T.length;
        for (int i = 0; i < S.length; i++) {
            if (count[S[i] - 97] >= 1) {
                count[S[i] - 97]--;
                nC--;
            }
        }
        return nC;
    }

    // MYSELF
    // DATE : 22-May-21, second attempt
    // TIME: 14 min
    public int minStepsSecondAttempt(String s, String t) {

        int[] cnt = new int[127];
        for (char ch : s.toCharArray()) cnt[ch]++;

        int sum = 0;
        for (char ch : t.toCharArray()) {
            if (cnt[ch] <= 0) sum++;
            cnt[ch]--;
        }
        return sum;
    }
}
