import java.util.NoSuchElementException;

public class Heap extends HeapSkeleton<Integer>{

    private static final int DEFAULT_SIZE = 10;

    private int currentSize;
    private int[] heapArr;

    public Heap(int capacity){
        this.currentSize = 0;
        heapArr = new int[capacity + 1];
//        heapArr[0] = Integer.MIN_VALUE;
    }

    @Override
    public void insert(Integer x) {
        if(currentSize == heapArr.length-1){
            enlargeArray(heapArr.length*2+1);
        }

        int hole = ++currentSize;

        for(heapArr[0] = x;
            x.compareTo(heapArr[hole/2]) < 0;
            hole /= 2){
            heapArr[hole] = heapArr[hole/2];
        }
        heapArr[hole] = x;
    }

    @Override
    public Integer findMin() {
        if(isEmpty())
            throw new NoSuchElementException();
        return heapArr[1];
    }

    @Override
    public Integer deleteMin() {
        if(isEmpty())
            throw new NoSuchElementException();
        int minItem = findMin();
        heapArr[1] = heapArr[currentSize--];
        percolateDown(1);

        return minItem;
    }

    @Override
    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    @Override
    public void makeEmpty() {
        heapArr = null;
    }

    @Override
    public void percolateDown(int hole) {
        Integer child;
        int temp = heapArr[hole];

        for(; hole*2 <= currentSize; hole = child){
            child = hole * 2;

            if(child != currentSize &&
                    heapArr[child+1] < heapArr[child] )
                child++;

            if(heapArr[child] < temp)
                heapArr[hole] = heapArr[child];
            else
                break;
        }

        heapArr[hole] = temp;
    }

    @Override
    public void buildHeap() {
        for(int i = currentSize/2; i > 0; i--){
            percolateDown(i);
        }
    }

    @Override
    public void enlargeArray(int length) {
        heapArr = new int[length];
    }

    /**
     * Prints the heap() in Level Ordered.
     */
    public void printHeap(){
        System.out.print("HeapArray: ");

        for(int i = 1; i <= currentSize; i++){
            System.out.print(heapArr[i] + " ");
        }
        System.out.println();
    }
}
