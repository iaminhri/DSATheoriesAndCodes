abstract class HeapSkeleton<AnyType extends Comparable<?super AnyType>>{
    //Heap Properties

    private static final int DEFAULT_CAPACITY = 10; // capacity of an array by default.

    private int currentSize; // number of elements in heap
    private AnyType[] array;

    //Constructors Section
    public HeapSkeleton(){
        //this.array instantiation.
    }
    public HeapSkeleton(int capacity){
        this.currentSize = capacity;
    }
    public HeapSkeleton(AnyType[] items){
        this.array = items;
    }

    //Heap Operations Abstract Methods.
    public abstract void insert(AnyType x);
    public abstract AnyType findMin();
    public abstract AnyType deleteMin();
    public abstract boolean isEmpty();
    public abstract void makeEmpty();

    // Heap Construction Abstract Methods.
    public abstract void percolateDown(int hole); // where hole refers to the place to inserted new element
    public abstract void buildHeap(); // Builds heap off of a data of an Array.
    public abstract void enlargeArray(int length);// Dynamically changes array size;
}
