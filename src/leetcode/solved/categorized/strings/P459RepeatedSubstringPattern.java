package leetcode.solved.categorized.strings;

class P459RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        boolean res = true;
        
        for(int i = 0; (2 * (i + 1)) <= s.length(); i++){
            res = true;
            for(int j = i + 1; j < s.length(); ){
                int k = 0, l = j;
                while(l < s.length() && k <= i){
                    if(s.charAt(k) != s.charAt(l)) {
                        res = false;
                        break;
                    }
                    l++;
                    k++;
                }
                if(!res) break;
                if(j + (i + 1) > s.length()) return false;
                j+= (i + 1);
            }
            if(res) return true;
        }
        return false;
    }

        public boolean repeatedSubstringPatternNSquareSolution(String s) {
            int N = s.length();

            for(int i = N / 2; i >= 1; i--){ // starting i from N/2 because we compare from middle, i.e if s = ababab. Then we first compare aba and bab. Since they dont compare
                // we do i-- and i becomes 2 and we compare ab with other two ab strings.
                if(N % i == 0){ // if current string of length i can be repeated some n number of times to make original string i.e. s
                    String subString = s.substring(0, i); // get the current substring eg. in ababab, get ab when i = 2. substring(0, i) means get i characters from 0th index including 0.
                    int numRepeats = N / i; // get the number of times substring should repeat.
                    StringBuilder sb = new StringBuilder();
                    // construct a new string by repeat the substring numRepeats times.
                    for(int j = 0; j < numRepeats; j++){
                        sb.append(subString);
                    }
                    // compare if equal and return true
                    if(sb.toString().equals(s)) return true;
                }
            }

            return false;
        }
}