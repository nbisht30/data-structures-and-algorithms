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
}