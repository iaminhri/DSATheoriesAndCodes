public class HeapClass {
    /** creating a heap class to implement and test it's functionality */

    private int[] heap; //heap array
    private int size; // size of the heap
    private int maxsize; // maximum size of the heap.

    private static final int FRONT = 1;


    //Constructor initializes, maxsize and size, creates heap array and initializes first index of array.
    public HeapClass(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;

        heap = new int[this.maxsize + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    // get parent of a node
    private int parentNode(int position){
        return position/2;
    }

    private int leftChild(int pos){
        return pos * 2;
    }

    private int rightChild(int pos){
        return (pos*2) + 1;
    }

    private boolean isLeaf(int pos){
        return (pos > (size/2));
    }

    /**
     * Swaps between two values
     * @param fPos -> first element of swap
     * @param sPos -> Element that is to be swapped.
     */
    private void swap(int fPos, int sPos){
        int temp;

        //position swapping algo.
        temp = heap[fPos];
        heap[fPos] = heap[sPos];
        heap[sPos] = temp;
    }

    private void minHeapBuilder(int pos){

    }

}
