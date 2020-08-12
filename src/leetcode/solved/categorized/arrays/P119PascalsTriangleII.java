package leetcode.solved.categorized.arrays;

import java.util.ArrayList;
import java.util.List;

class P119PascalsTriangleII {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
    public static List<Integer> getRow(int rowIndex) {
        
        List<Integer> retLst = new ArrayList<Integer>();
        
        if(rowIndex == 0) {
            retLst.add(1);
            return retLst;
        }
        
        int[] arr = new int[35];
        int st = 0, end = 1;
        int cnt = 1;
        arr[st] = 1; arr[end] = 1;
        
        if(rowIndex > 1) {
           
            while(cnt < rowIndex){
                int prev = arr[st];
                int curr;
                for(int i = st + 1; i <= end; i++){
                    curr = arr[i];
                    arr[i] = curr + prev;
                    prev = curr;
                }
                arr[++end] = 1;
                cnt++;
            }
        }
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0) retLst.add(arr[i]);
        }
        
        return retLst;
    }
}