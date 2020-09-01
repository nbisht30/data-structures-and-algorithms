package leetcode.solved.categorized.bitmanipulation;
// https://leetcode.com/problems/reverse-bits/
public class P190ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        for(int i = 32, j = 1; i > j; i--,j++){
            int iBit = getKthBit(n,i);
            int jBit = getKthBit(n,j);
            if(iBit != jBit){ // only then swap
                if(iBit == 1 && jBit == 0){
                    n = setKthBit(n, i, 0);
                    n = setKthBit(n, j, 1);
                }else{
                    n = setKthBit(n, i, 1);
                    n = setKthBit(n, j, 0);
                }
            }
        }
        return n;
    }
    
    public int getKthBit(int n, int k){
        return (n & (1 << (k - 1))) != 0 ? 1 : 0;
    }
    
    public int setKthBit(int n, int k, int bit){
        if(bit == 1) return n | (1 << k - 1);
        else return n & ~(1 << k - 1);
            
    }
}