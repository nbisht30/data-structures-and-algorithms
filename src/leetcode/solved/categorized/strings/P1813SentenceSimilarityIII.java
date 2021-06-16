package leetcode.solved.categorized.strings;

class P1813SentenceSimilarityIII {
    // MYSELF
    // DATE: 16-06-21, first attempt
    // TIME: 30 mins
    // CONTEST: Biweekly Contest 49 Virtual
    // @TODO: Cleanup
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        int s1last = s1.length - 1;
        int s2last = s2.length - 1;
        if (s1[0].equals(s2[0]) && s1[s1last].equals(s2[s2last])) {
            int i = 0, j = 0, k = s1last, l = s2last;
            while (i <= k && j <= l) {
                if (s1[i].equals(s2[j])) {
                    i++;
                    j++;
                } else if (s1[k].equals(s2[l])) {
                    k--;
                    l--;
                } else {
                    break;
                }
            }
            return i > k || j > l;
        } else if (s1[0].equals(s2[0])) {
            int i = 0, j = 0;
            while (i <= s1last && j <= s2last) {
                if (!s1[i].equals(s2[j])) break;
                i++;
                j++;
            }
            return i > s1last || j > s2last;
        } else if (s1[s1last].equals(s2[s2last])) {
            int i = s1last, j = s2last;
            while (i >= 0 && j >= 0) {
                if (!s1[i].equals(s2[j])) break;
                i--;
                j--;
            }
            return i < 0 || j < 0;
        } else return false;
    }
}