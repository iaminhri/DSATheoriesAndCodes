public class DSAClassDriverList {
    public DSAClassDriverList(){
//        HeapClassContiguous heap = new HeapClassContiguous(15);
//
//        heap.insert(5);
//        heap.insert(10);
//        heap.insert(20);
//        heap.insert(3);
//        heap.insert(13);
//        heap.insert(7);
//
//        heap.printHeap();
//
//        System.out.println("Minimum Value: " + heap.removeMin());
//        heap.printHeap();

        Heap newHeap = new Heap(10);
        newHeap.insert(5);
        newHeap.insert(10);
        newHeap.insert(20);
        newHeap.insert(3);
        newHeap.insert(13);
        newHeap.insert(7);

        newHeap.printHeap();

        System.out.println("Minimum Value: " + newHeap.deleteMin());
        System.out.println("Minimum Value: " + newHeap.deleteMin());

        newHeap.printHeap();

        System.out.println("Minimum Value: " + newHeap.deleteMin());
        newHeap.printHeap();
    }

    public static void main(String[] args) { new DSAClassDriverList(); }
}
