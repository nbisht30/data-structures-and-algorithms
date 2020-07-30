package codingblocks.heaps;

import java.util.ArrayList;

/**
 * @author Nikhil Bisht
 * @date 30-07-2020
 */
public class MinHeap {
    ArrayList<Integer> data;  //array can be used, but we need to specify size hence we're not using it

    public MinHeap() {
        this.data = new ArrayList<>();
    }

    public void add(int item) {
        //1. First add the item at last
        data.add(item);
        upheapify(data.size() - 1);
    }

    private void upheapify(int childIndex) {
        //There is no need for base case as recursive call is only getting made using < operator
        //even when both indexes become same at root i.e 0 since value wont be less than itself
        //call wouldn't be made.
        /*
        if (childIndex <= 0) {
            return;
        }*/
        int parentIndex = (childIndex - 1) / 2;
        if (data.get(parentIndex) > data.get(childIndex)) {
            swapValues(parentIndex, childIndex);
            upheapify(parentIndex);
        }
    }

    private void swapValues(int indexOne, int indexTwo) {
        int dataIndexTwo = data.get(indexTwo);
        data.set(indexTwo, data.get(indexOne));
        data.set(indexOne, dataIndexTwo);
    }

    public void display() {
        System.out.println(data);
    }

    public int size() {
        return this.data.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }
}
