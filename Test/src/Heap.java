import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public abstract class Heap<E extends Comparable>
{
    ArrayList<E> data;
    Comparator<E> comparator;
    /**
     * while (parent >= 0 and
     table[parent] > table[child])
     4. Swap table[parent]
     and table[child]
     5. Set child equal to parent
     6. Set parent equal to (child-1)/2
     * @param item
     */
    public boolean add(E item)
    {
        int child;
        int parent;
        int tempParent;
        data.add(item);
        child = data.size()-1;
        parent = (child-1)/2;
        while(parent >= 0 && 0 < comparator.compare(data.get(parent),data.get(child)))
        {
            E parentData = data.get(parent);
            E childData  = data.get(child);
            data.set(parent, childData);
            data.set(child, parentData);
            child = parent;
            parent = (child-1)/2;
        }
        return true;
    }
    public void remove()
    {
        int parent, leftChild, rightChild;
        data.set(0, data.get(data.size()-1));
        data.remove(data.size()-1);
        parent = 0;
        do
        {
            leftChild = (2 * parent) + 1;
            rightChild = leftChild + 1;
            if (rightChild < data.size() && 0 > comparator.compare(data.get(rightChild), data.get(leftChild)))
            {
                leftChild = rightChild;
            }
            if (0 < comparator.compare(data.get(parent), data.get(leftChild)))
            {
                E tempData = data.get(parent);
                data.set(parent, data.get(leftChild));
                data.set(leftChild, tempData);
            }
        }while( leftChild < data.size() && 0 < comparator.compare(data.get(parent), data.get(leftChild)));
    }
    public void print()
    {
        System.out.println(data);
    }
}

