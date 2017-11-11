public class HeapDriver
{
    public static void main(String[] args)
    {
        minHeap<Integer> heapTest = new minHeap();
        heapTest.add(5);
        heapTest.add(2);
        heapTest.add(11);
        heapTest.add(2);
        heapTest.add(1);
        heapTest.add(31);
        heapTest.add(0);
        System.out.println("MinHeap of [5,2,11,2,1,31,0]");
        heapTest.print();
        heapTest.remove();
        System.out.println("Removing");
        heapTest.print();


        maxHeap<Integer> maxHeapTest = new maxHeap();

        maxHeapTest.add(5);
        maxHeapTest.add(1);
        maxHeapTest.add(20);
        maxHeapTest.add(4);
        System.out.println("\nMaxHeap of [5, 1, 20, 4]");
        maxHeapTest.print();
        maxHeapTest.add(1);
        maxHeapTest.add(20);
        maxHeapTest.add(4);
        maxHeapTest.add(6);
        System.out.println("Adding 6 to heap");
        maxHeapTest.print();
        System.out.println("removing from heap");
        maxHeapTest.remove();
        maxHeapTest.print();
    }
}
