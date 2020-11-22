package leetcode.solved.categorized.strings;

class P1446ConsecutiveCharacters {
    public int maxPower(String s) {
        if (s.length() == 1) return 1;
        int max = 0, curr = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) curr++;
            else {
                max = Math.max(curr, max);
                curr = 1;
            }
        }

        return Math.max(curr, max);
    }
}