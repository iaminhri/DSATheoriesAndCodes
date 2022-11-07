public class DSAClassDriverList {
    public DSAClassDriverList(){
        HeapClassContiguous heap = new HeapClassContiguous(15);
        heap.insert(5);
        heap.insert(10);
        heap.insert(20);
        heap.insert(3);
        heap.insert(13);
        heap.insert(7);

        heap.printHeap();

        System.out.println("Minimum Value: " + heap.removeMin());
        heap.printHeap();
    }

    public static void main(String[] args) { new DSAClassDriverList(); }
}
