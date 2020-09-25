package implementations.heaps;

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
        upHeapify(data.size() - 1);
    }

    private void upHeapify(int childIndex) {
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
            upHeapify(parentIndex);
        }
    }

    public int delete() {
        int deletedItem = -1;
        if (size() == 0) return deletedItem;
        else if (size() == 1) {
            deletedItem = data.remove(0);
        } else {
            // Highest priority item will be deleted
            deletedItem = data.get(0);

            // Swap 0th and last.
            swapValues(0, size() - 1);

            // Delete last
            data.remove(size() - 1);

            // Down-heapify
            downHeapify(0);
        }
        return deletedItem;
    }

    private void downHeapify(int parentIndex) {
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        int minInd = parentIndex;

        if(leftChildIndex < size() && data.get(minInd) > data.get(leftChildIndex)){
            minInd = leftChildIndex;
        }

        if(rightChildIndex < size() && data.get(minInd) > data.get(rightChildIndex)){ //We need to compare left and right child as well if left was less than
            // the parent and first if block executed as now the right might be even smaller than left of parent hence we're comparing with minInd
            minInd = rightChildIndex;
        }

        if(minInd != parentIndex){
            swapValues(parentIndex, minInd);
            downHeapify(minInd);
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

    public int getMin(){
        return size() > 0 ? data.get(0) : -1;
    }

    public int size() {
        return this.data.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }
}
