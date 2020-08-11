package leetcode.solved.categorized.math;

class P171ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int i = s.length() - 1;
        int colNum = 0;
        int num = 0;
        int unitPlace = 1;
        while(i >= 0){
            System.out.println(colNum);
            num = s.charAt(i) - 'A' + 1; //to get number corresponding to the letter
            colNum = (int) (colNum + Math.pow(26,unitPlace) * num);
            unitPlace++;
            i--;
        }
        return colNum;
    }

    /*
    I was able to code it up on my own in August challenge, using the below approach
    It is actually same as above approach, but we dont need to use Math.pow()
    */
    public int titleToNumberAugChallenge(String s) {
        int res = 0;
        int unitPlace = 1;
        for(int i = s.length() - 1; i >= 0; i--){
            res += ((s.charAt(i) - 'A' + 1) * unitPlace);
            unitPlace *= 26;
        }
        return res;
    }
}