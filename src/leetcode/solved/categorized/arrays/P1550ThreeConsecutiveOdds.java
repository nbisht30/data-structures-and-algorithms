package leetcode.solved.categorized.arrays;

class P1550ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 != 0) {
                if(i + 2 < arr.length && (arr[i + 1] % 2 != 0) && (arr[i + 2] % 2 != 0)) return true;
            }
        }
        return false;
    }
}