package leetcode.categorized.strings;

class P459RepeatedSubstringPattern {
    // MYSELF
    // DATE : 08-May-2021
    // TIME : 5-10 mins.
    public boolean repeatedSubstringPattern(String s) {
        int N = s.length();
        for (int currLen = 1; currLen <= N / 2; currLen++) {
            if (N % currLen != 0) continue;
            String substr = s.substring(0, currLen);
            int i;
            for (i = currLen; i <= N - currLen; i += currLen) {
                String compSubStr = s.substring(i, i + currLen);
                if (!compSubStr.equals(substr)) break;
            }
            if (i == s.length()) return true;
        }
        return false;
    }

    public boolean repeatedSubstringPatternNSquareSolution(String s) {
        int N = s.length();

        for (int i = N / 2; i >= 1; i--) { // starting i from N/2 because we compare from middle, i.e if s = ababab. Then we first compare aba and bab. Since they dont compare
            // we do i-- and i becomes 2 and we compare ab with other two ab strings.
            if (N % i == 0) { // if current string of length i can be repeated some n number of times to make original string i.e. s
                String subString = s.substring(0, i); // get the current substring eg. in ababab, get ab when i = 2. substring(0, i) means get i characters from 0th index including 0.
                int numRepeats = N / i; // get the number of times substring should repeat.
                StringBuilder sb = new StringBuilder();
                // construct a new string by repeat the substring numRepeats times.
                for (int j = 0; j < numRepeats; j++) {
                    sb.append(subString);
                }
                // compare if equal and return true
                if (sb.toString().equals(s)) return true;
            }
        }

        return false;
    }

    public boolean repeatedSubstringPatternOptimizedNSquare(String s) {
        int N = s.length();
        for (int i = N / 2; i >= 1; i--) {
            if (N % i == 0) {
                int j = 0;
                /*
                Instead of getting the substring first and then creating another string by repeating the substring multiple times to then compare with original string like
                in above approach, we can just compare within the original string.
                Eg s = ababab
                Assume i = 2 in current iteration and j = 0.
                Then we execute, while (j + i < N && s.charAt(j) != s.charAt(i + j)){j++;}
                Since,
                j + i < N [0 + 2 < 6] and s.charAt(0) = s.charAt(2) i.e a = a, we continue
                j + i < N [1 + 2 < 6] and s.charAt(1) = s.charAt(3) i.e b = b, we continue
                j + i < N [2 + 2 < 6] and s.charAt(2) = s.charAt(4) i.e a = a, we continue
                j + i < N [3 + 2 < 6] and s.charAt(3) = s.charAt(5) i.e b = b, we continue
                j + i == N [4 + 2 = 6] we exit.
                 */
                while (j + i < N && s.charAt(j) != s.charAt(i + j)) {
                    j++;
                }
                if (j + i == N) return true;
            }
        }
        return false;
    }

    public boolean repeatedSubstringPatternShortCutButSlower(String s) {
        return (s + s).substring(1, 2 * s.length() - 1).contains(s);
    }
}