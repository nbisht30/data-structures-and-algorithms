package leetcode.solved.categorized.greedy;

class P1653MinimumDeletionsToMakeStringBalanced {
    public int minimumDeletions(String s) {
        int a = 0, b = 0, st = 0, end = s.length() -1, count = 0;
        char[] str = s.toCharArray();
        for(char ch : str) {
            if(ch == 'a') a++;
            else b++;
        }
        while(st < end){
            if(a > 0 && str[st] == 'a') {
                st++; 
                a--;
            } else if(b > 0 && str[end] == 'b') {
                end--;
                b--;
            } else{
                count++;
                if(a < b) {
                    a--;
                    end--;
                } else {
                    b--;
                    st++;
                }
            }
        }
        return count;
    }
}