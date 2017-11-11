
import java.util.ArrayList;
import java.util.Comparator;

public class maxHeap<E extends Comparable> extends Heap<E>
{
    public maxHeap()
    {
        data = new ArrayList<E>();
        comparator = new Comparator<E>()
        {
            @Override
            public int compare(E o1, E o2)
            {
                return -1 * o1.compareTo(o2);
            }
        };
    }
    public maxHeap(Comparator<E> comp)
    {
        super();
        comparator = comp;
    }
    public int compare(E left, E right)
    {
        if (comparator != null)
        { // A Comparator is defined.
            return -1 * comparator.compare(left, right);
        }
        else
        { // Use left’s compareTo method.
            return -1 * ((Comparable<E>) left).compareTo(right);
        }
    }
}
