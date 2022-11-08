import java.util.NoSuchElementException;

public class Heap extends HeapSkeleton<Integer>{

    private static final int DEFAULT_SIZE = 10;

    private int currentSize;
    private int[] heapArr;

    public Heap(int capacity){
        this.currentSize = 0;
        heapArr = new int[capacity + 1];

//        insert(5);
//        insert(10);
//        insert(20);
//        insert(3);
//        insert(13);
//        insert(7);
//        insert(14);
//        insert(4);
//        insert(6);

//        insert(10);
//        insert(5);
//        insert(3);
//        insert(4);
//        insert(1);

        insert(5);
        insert(3);
        insert(17);
        insert(10);
        insert(84);
        insert(19);
        insert(6);
        insert(22);
        insert(9);

//        buildHeap();
        print();

        System.out.print("InOrder Traversal: ");
        inOrderTraversal(1);
        System.out.print("Heap Sort: ");
        heapSort();
        printHeap();
    }

    public void print()
    {
        System.out.println();
        for (int i = 1; i <= currentSize / 2; i++) {

            // Printing the parent and both childrens
            System.out.print(
                    "PARENT : " + heapArr[i]
                            + " LEFT CHILD : " + heapArr[2 * i]
                            + " RIGHT CHILD :" + heapArr[2 * i + 1]);

            // By here new line is required
            System.out.println();
        }
    }

    @Override
    public void percolateDown(int hole) {
        int child;
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


    public void swapElements(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void inOrderTraversal(int pos){
        if(pos > currentSize)
            return;
        else{
            inOrderTraversal(2 * pos);
            System.out.print(heapArr[pos] + " " );
            inOrderTraversal(2 * pos + 1);
        }
    }

    private static int leftChild(int i){
        return i*2;
    }

    public void heapSort(){
        buildHeap();
        for(int i = currentSize; i > 0; i--){
            swapElements( heapArr, 1, i);
            percolateDown(heapArr, 1, i);
        }
    }

    public void percolateDown(int[] array, int i, int n) {
        int child;
        int temp;

        for(temp = array[i]; leftChild(i) < n; i = child){
            child = leftChild(i);

            if(child != n-1 &&
                      array[child+1] < array[child] )
                child++;

            if( array[child] < temp )
                array[i] = array[child];
            else
                break;
        }
        array[i] = temp;
    }

    @Override
    public void insert(int x) {
        if(currentSize == heapArr.length-1){
            enlargeArray(heapArr.length*2+1);
        }

        int hole = ++currentSize;

        //Trickle Up
        for(heapArr[0] = x;
            x < heapArr[hole/2];
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

    public int getCurrentSize() {
        return currentSize;
    }

    public int[] getHeapArr() {
        return heapArr;
    }
}
