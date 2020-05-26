package leetcode.unsolved.dp;

class P1035UncrossedLines {
    public int maxUncrossedLines(int[] A, int[] B) {
        int i = 0, j = 0;
        
        int ucl = 0;
        while((i + 1) < A.length && (j + 1) < B.length){
            if(A[i] == B[j])  {
                ucl++; 
                i++;
                j++;
            }
            else if(A[i] == B[j + 1]) {
                j++;
            }
            else if(B[j] == A[i + 1]) {
                i++;
            }else{
                i++;
                j++;
            }
        }
        
        if(i < A.length && j < B.length && A[i] == B[j]) {
            ucl++;
            i++;
            j++;
        }
        else if(A.length > B.length) {
            i = B.length;
            while(i < A.length) {
                if(B[B.length - 1] == A[i]){
                    ucl++;
                    break;                
                }
                i++;
            }
        }else if(A.length < B.length){
            j = A.length;
             while(j < B.length) {
                if(A[A.length - 1] == B[j]){
                    ucl++;
                    break;                
                }
                j++;
            }
        }
        return ucl;
    }
}