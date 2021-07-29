/**
 * Hw8 : Tests min and max Heap implementations
 * minHeapTest
 * 	add
 * 	test removal of 1 element
 *  add many elements
 *  print heap
 *  remove
 *  print heap
 *  
 * maxHeapTest
 * 	add
 * 	test removal of 1 element
 *  add many elements
 *  print heap
 *  remove
 *  print heap
 * @author Areman Hashemi<AremanHashemi@hotmail.com>
 * @version 2.0
 */
package edu.miracosta.cs113;
public class HeapDriver
{
    public static void main(String[] args)
    {
        minHeap<Integer> heapTest = new minHeap();
        heapTest.add(5);
        heapTest.remove();
        heapTest.add(2);
        heapTest.add(11);
        heapTest.add(2);
        heapTest.add(1);
        heapTest.add(4);
        heapTest.add(6);
        heapTest.add(76);
        heapTest.add(31);
        heapTest.add(0);
        System.out.println("Given minHeap");
        heapTest.print();
        heapTest.remove();
        System.out.println("Removing");
        heapTest.print();


        maxHeap<Integer> maxHeapTest = new maxHeap();
        maxHeapTest.add(5);
        maxHeapTest.remove();
        maxHeapTest.add(1);
        maxHeapTest.add(20);
        maxHeapTest.add(4);
        maxHeapTest.add(42);
        maxHeapTest.add(100);
        maxHeapTest.add(44);
        maxHeapTest.add(321);
        maxHeapTest.add(6);
        System.out.println("\nGiven maxHeap");
        maxHeapTest.print();
        System.out.println("removing from heap");
        maxHeapTest.remove();
        maxHeapTest.print();
    }
}
