package leetcode.solved.categorized.arrays.circulararray;

class P1652DefuseTheBomb {
    public int[] decrypt(int[] code, int k) {
        int[] sum = new int[code.length];

        if (k < 0) {
            for (int i = sum.length - 1; i >= 0; i--) {
                System.out.println("i: " + i);
                for (int j = 1; j <= Math.abs(k); j++) {
                    System.out.println("j: " + j);
                    int index = (i - j) < 0 ? (code.length + (i - j)) : i - j % code.length;
                    System.out.println("index: " + index);
                    sum[i] += code[index];
                }
                System.out.println("sum[" + i + "]: " + sum[i]);
            }
        } else {
            for (int i = 0; i < sum.length; i++) {
                for (int j = 1; j <= k; j++) {
                    sum[i] += code[(i + j) % code.length];
                }
            }
        }
        return sum;
    }
}