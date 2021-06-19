package leetcode.categorized.hashing;

class P705DesignHashSet {

    boolean[] set;
    /** Initialize your data structure here. */
    public P705DesignHashSet() {
        set = new boolean[1000001];
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return set[key];
    }
}
