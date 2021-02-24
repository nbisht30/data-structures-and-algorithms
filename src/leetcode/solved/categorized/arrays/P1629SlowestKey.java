package leetcode.solved.categorized.arrays;

class P1629SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char maxKey = keysPressed.charAt(0);
        int maxDur = releaseTimes[0];
        for(int i = 1; i < releaseTimes.length; i++){
            int currDur = releaseTimes[i] - releaseTimes[i - 1];
            if(currDur > maxDur) {
                maxDur = currDur;
                maxKey = keysPressed.charAt(i);
            } else if(currDur == maxDur && maxKey < keysPressed.charAt(i)) {
                maxKey = keysPressed.charAt(i);
            }
        }
        return maxKey;
    }
}