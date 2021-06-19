package leetcode.categorized.math.others;

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
    COMMENTS:-
    I was able to code it myself in August challenge, using the below approach
    It is same as the approach above, but we don't need to use Math.pow()
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