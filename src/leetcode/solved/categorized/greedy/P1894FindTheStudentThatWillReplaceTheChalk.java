package leetcode.solved.categorized.greedy;

class P1894FindTheStudentThatWillReplaceTheChalk {
    public int chalkReplacer(int[] chalk, int k) {
        int sum = 0;
        for(int j = 0; j < chalk.length; j++) {
            k -= chalk[j];
            if(k < 0) return j;
            sum += chalk[j];
        }
        k = k % sum;
        for(int j = 0; j < chalk.length; j++) {
            k -= chalk[j];
            if(k < 0) return j;
        }
        return 0;
    }
    
}