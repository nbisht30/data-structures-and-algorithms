package leetcode.thirtydaychallengemay;
// https://leetcode.com/problems/remove-k-digits/
class Day13_P402RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(removeKdigits(
                "112",
                1
        ));
    }

    // This was very hard for me, need to practice.
    public static String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";

        if (k == 0) return num;

        StringBuilder retNum = new StringBuilder();

        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && retNum.length() - 1 >= 0 && num.charAt(i) < retNum.charAt(retNum.length() - 1)) {
                retNum.setLength(retNum.length() - 1);
                k--;
            }
            if (!(num.charAt(i) == '0' && retNum.length() == 0))
                retNum.append(num.charAt(i));
        }

        // for last element of num because missed by first loop
        while (k > 0 && retNum.length() > 0) {
            retNum.setLength(retNum.length() - 1);
            k--;
        }
        if (retNum.length() == 0) return "0";
        return retNum.toString();
    }
}