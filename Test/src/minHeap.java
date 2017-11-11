
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
    public int compare(E left, E right)
    {
        if (comparator != null)
        { // A Comparator is defined.
            return comparator.compare(left, right);
        }
        else
        { // Use left’s compareTo method.
            return ((Comparable<E>) left).compareTo(right);
        }
    }
}
