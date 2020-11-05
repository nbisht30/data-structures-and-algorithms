package leetcode.solved.categorized.math.arithmetics;

import java.util.HashMap;

class P166FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();
        sb.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        /*
        ^ is bitwise XOR operator.
        If num is positive and den is also positive we get true XOR true which is false, so we dont append "-".
        Similarly if num is negative and den is also negative we get false XOR false, which is again false, so we dont append "-".
        But if just one of nums or den is negative we'll XOR two different boolean values which always returns true, so we append "-"
        */

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        long quo = num / den;
        sb.append(quo);
        long rem = num % den;
        if (rem == 0) return sb.toString();
        else sb.append(".");

        HashMap<Long, Integer> remainderPosMap = new HashMap<>();
        num = rem;

        while (rem != 0) {
            if (remainderPosMap.containsKey(rem)) {
                int len = remainderPosMap.get(rem);
                sb.insert(len, "(");
                sb.append(")");
                break;
            }
            remainderPosMap.put(rem, sb.length());
            num *= 10;
            quo = num / den;
            sb.append(quo);
            rem = num % den;
            num = rem;
        }
        return sb.toString();
    }
}