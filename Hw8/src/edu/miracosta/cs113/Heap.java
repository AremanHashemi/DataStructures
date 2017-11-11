package edu.miracosta.cs113;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class Heap<E extends Comparable>
{
    protected ArrayList<E> data;
    protected Comparator<E> comparator;
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
        data.add(item);
        int child = data.size()-1;
        bubbleUp(child);
        return true;
    }
    private void bubbleUp(int child)
    {
    	int parent = (child-1)/2;
        while(parent >= 0 && 0 < compare(data.get(parent),data.get(child)))
        {
            E parentData = data.get(parent);
            E childData  = data.get(child);
            data.set(parent, childData);
            data.set(child, parentData);
            child = parent;
            parent = (child-1)/2;
        }
    }
	public void remove()
    {
        data.set(0, data.get(data.size()-1));
        data.remove(data.size()-1);
        int parent = 0;
        int leftChild, rightChild;
        do
        {
            leftChild = (2 * parent) + 1;
            rightChild = leftChild + 1;
            if (exists(rightChild)&& leftGreaterThanRight(leftChild, rightChild))
            {
                leftChild = rightChild;
            }
            if (leftGreaterThanRight(parent,rightChild))
            {
                swap(parent,leftChild);
            }
        }while( leftChild < data.size() && 0 < compare(data.get(parent), data.get(leftChild)));
    }
	private void swap(int a, int b)
	{
		E tempData = data.get(a);
        data.set(a, data.get(b));
        data.set(b, tempData);
	}
	private boolean leftGreaterThanRight(int left, int right)
	{
		return compare(data.get(left), data.get(right)) > 0 ;
	}
	private boolean exists(int child)
	{
		return child < data.size();
	}
    public void print()
    {
        System.out.println(data);
    }
    protected abstract int compare(E e, E e2);
}

