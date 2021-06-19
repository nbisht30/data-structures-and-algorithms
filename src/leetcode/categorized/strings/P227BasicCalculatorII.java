package leetcode.categorized.strings;

import java.util.*;

class P227BasicCalculatorII {

    class MySolution{
        public int calculate(String s) {
            s = s.replaceAll("\\s", "");
            if (s.length() == 1) return Integer.parseInt(s);
            List<String> compressedExp = getCompressedExpression(s);

            List<String> expAfterDivAndMul = new ArrayList<>();
            for (int i = 0; i < compressedExp.size(); i++) { // look for * or / at i-th pos
                if (compressedExp.get(i).equals("*") || compressedExp.get(i).equals("/")) {
                    int operand1 = Integer.parseInt(expAfterDivAndMul.get(expAfterDivAndMul.size() - 1));
                    int operand2 = Integer.parseInt(compressedExp.get(i + 1));
                    int result = compressedExp.get(i).equals("*") ? operand1 * operand2 : operand1 / operand2;
                    expAfterDivAndMul.set(expAfterDivAndMul.size() - 1, result + "");
                    i++;
                } else {
                    expAfterDivAndMul.add(compressedExp.get(i));
                }
            }

            int finalRes = 0;
            for (int i = 0; i < expAfterDivAndMul.size(); i++) { // look for * or / at i-th pos
                if (expAfterDivAndMul.get(i).equals("+") || expAfterDivAndMul.get(i).equals("-")) {
                    int operand2 = Integer.parseInt(expAfterDivAndMul.get(i + 1));
                    finalRes = expAfterDivAndMul.get(i).equals("-") ? finalRes - operand2 : finalRes + operand2;
                    i++;
                } else {
                    finalRes += Integer.parseInt(expAfterDivAndMul.get(i));
                }
            }
            return finalRes;
        }

        private List<String> getCompressedExpression(String s) {
            int i = 0;
            Set<Character> charSet = new HashSet();
            List<String> res = new ArrayList<>();
            Collections.addAll(charSet, '+', '-', '*', '/');
            int num = 0;
            while (i < s.length()) {
                if (charSet.contains(s.charAt(i))) {
                    res.add(String.valueOf(num));
                    res.add(String.valueOf(s.charAt(i)));
                    num = 0;
                } else {
                    num *= 10;
                    num += Integer.parseInt(String.valueOf(s.charAt(i)));
                }
                i++;
            }
            res.add(String.valueOf(num));
            return res;
        }
    }

    class FasterStackBasedImplementstion {
        // https://www.youtube.com/watch?v=wirVxwyhsLU&ab_channel=CodingInterviewPreparation
        public int calculate(String s) {

            char lastOpr = '+';
            Stack<Integer> nums = new Stack<>();
            Set<Character> oprs = new HashSet<>();
            Collections.addAll(oprs, '+', '-', '/', '*');
            int currNum = 0;

            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if(Character.isDigit(ch)){
                    currNum = currNum * 10 + ch - '0';
                }
                if(oprs.contains(ch) || i == s.length() - 1){
                    if(lastOpr == '+') nums.push(currNum);
                    else if(lastOpr == '-') nums.push(-currNum);
                    else if(lastOpr == '*') nums.push(nums.pop() * currNum);
                    else if(lastOpr == '/') nums.push(nums.pop() / currNum);
                    currNum = 0;
                    lastOpr = ch;
                }
            }

            int result = 0;
            while(!nums.isEmpty()){
                result += nums.pop();
            }

            return result;
        }
    }

    class FastestSolutionWithoutStack {
        // Understood from leetcode solution section
        public int calculate(String s) {

            char lastOpr = '+';
            int currNum = 0, lastNum = 0, result = 0;

            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if(Character.isDigit(ch)){
                    currNum = currNum * 10 + ch - '0';
                }
                if(!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1){
                    if(lastOpr == '+' || lastOpr == '-') {
                        result += lastNum;
                        lastNum = lastOpr == '+' ? currNum : -currNum;
                    }
                    else if(lastOpr == '*') lastNum = lastNum * currNum;
                    else if(lastOpr == '/') lastNum = lastNum / currNum;
                    currNum = 0;
                    lastOpr = ch;
                }
            }
            result += lastNum;
            return result;
        }
    }
}
