public class HeapClassContiguous {
    /** creating a heap class to implement and test it's functionality */

    private int[] heap; //heap array
    private int size; // size of the heap
    private int maxsize; // maximum size of the heap.

    private static final int FRONT = 1;


    //Constructor initializes, maxsize and size, creates heap array and initializes first index of array.
    public HeapClassContiguous(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;

        heap = new int[this.maxsize + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    // gets parent of a node
    private int parentNode(int position){
        return position/2;
    }

    //gets left child of a parent or position
    private int leftChild(int pos){
        return pos * 2;
    }

    //gets right child of a parent or position
    private int rightChild(int pos){
        return (pos*2) + 1;
    }

    /**
     * checks if the following position isLeaf() or not.
     * @param pos -> at given position within the heap array.
     * returns -> boolean
     */
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

    /**
     * Builds min Heap recursively.
     * @param pos -> position inside the heap.
     */
    private void minHeapBuilder(int pos){
        if(!isLeaf(pos)){
            int swapPos = pos;

            if(rightChild(pos) <= size)
                swapPos = heap[leftChild(pos)] < heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
            else
                swapPos = heap[leftChild(pos)];

            if(heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]){
                swap(pos, swapPos);
                minHeapBuilder(swapPos);
            }
        }
    }

    /**
     * Inserts elements into the heap.
     * @param element -> element to be inserted inside heap.
     */
    public void insert(int element){
        //if array size exceeds the maxsize then return.
        if(size >= maxsize){
            return;
        }
        heap[++size] = element; //stores inserted element at the last index of the heap.

        int current = size; // stores updated size value for the current inserted node.

        /**
         * If inserted element is less the parent node then swaps current elements in list until current > parentNode.
         */
        while(heap[current] < heap[parentNode(current)]){
            swap(current, parentNode(current));
            current = parentNode(current);
        }
    }

    /**
     * Removes the first element of the array.
     * @return root value or the min value at the top of the tree.
     */
    public int removeMin(){
        int min = heap[FRONT];

        heap[FRONT] = heap[size--];
        minHeapBuilder(FRONT);

        return min;
    }

    /**
     * Prints the heap() in Level Ordered.
     */
    public void printHeap(){
        for(int i = 1; i <= size/2; i++){
            System.out.print("Parent: " + heap[i]
            + " LeftChild: " + heap[2*i]
            + " RightChild: " + heap[(2*i)+1]);
            System.out.println();
        }
    }
}
