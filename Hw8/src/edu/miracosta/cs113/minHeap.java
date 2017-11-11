package edu.miracosta.cs113;
import java.util.ArrayList;
import java.util.Comparator;

public class minHeap<E extends Comparable> extends Heap<E>
{
    public minHeap()
    {
        data = new ArrayList<E>();
        comparator = new Comparator<E>()
        {
            @Override
            public int compare(E o1, E o2)
            {
                return o1.compareTo(o2);
            }
        };
    }
    public minHeap(Comparator<E> comp)
    {
        super();
        comparator = comp;
    }
    @Override
    public int compare(E left, E right)
    {
    	return comparator.compare(left, right);
    }
}
