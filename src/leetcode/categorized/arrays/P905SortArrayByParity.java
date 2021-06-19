package leetcode.categorized.arrays;

class P905SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        // One pass solution, O(n) space
        
        int arr []  =new int[A.length];
        int evenI = 0;
        int oddI = A.length - 1;
        for(int i : A){
            if(i % 2 == 0) arr[evenI++] = i;
            else arr[oddI--] = i;
        }
        
        return arr;
    }
}