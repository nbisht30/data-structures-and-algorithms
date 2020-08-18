package leetcode.solved.categorized.arrays;

class P1103DistributeCandiesToPeople {
    // MYSELF.(new comment to be put in all problems I did myself, to add to already completed problems when I redo them)
    public int[] distributeCandies(int candies, int num_people) {
        int[] arr = new int[num_people];
        int loopCount = 0;
        int toReduce = 0;
        while (candies > 0) {
            for (int i = 1; i <= num_people; i++) {
                toReduce = (num_people * loopCount) + i;
                if (candies > toReduce) {
                    arr[i - 1] += toReduce;
                    candies -= toReduce;
                } else {
                    arr[i - 1] += candies;
                    candies = 0;
                    break;
                }
            }
            loopCount += 1;
        }
        return arr;
    }
}