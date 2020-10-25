package leetcode.solved.categorized.arrays;

class P1629SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        if(releaseTimes.length == 1) return keysPressed.charAt(0);
        int max = releaseTimes[0];
        char c = keysPressed.charAt(0);
        for(int i = 1; i < releaseTimes.length; i++){
            if((releaseTimes[i] - releaseTimes[i - 1]) > max) {
                max = releaseTimes[i] - releaseTimes[i - 1];
                c = keysPressed.charAt(i);
            }if((releaseTimes[i] - releaseTimes[i - 1]) == max && keysPressed.charAt(i) > c){
                c = keysPressed.charAt(i);
            }
        }
        return c;
    }
}