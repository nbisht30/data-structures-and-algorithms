package leetcode.categorized.recursion;

class P38CountAndSay {
    // MYSELF

    public static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        return helper(n, sb, 0, 1);
    }

    public static String helper(int n, StringBuilder str, int index, int size) {
        if (n == 1) {
            StringBuilder sb = new StringBuilder();
            for (int j = index; j < size; j++) sb.append(str.charAt(j));
            return sb.toString();
        }
        char num = str.charAt(index);
        int count = 1;
        int i = index + 1;
        int nextSize = 0;
        while (i < size) {
            if (str.charAt(i) == num) {
                count++;
            } else {
                str.append(count).append(num);
                nextSize += 2;
                count = 1;
                num = str.charAt(i);
            }
            i++;
        }
        index = size;
        str.append(count).append(num);
        nextSize += 2;
        n--;
        return helper(n, str, index, size + nextSize);
    }
}