package edu.miracosta.cs113;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class Heap<E extends Comparable<E>>
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
    /**
     * adds 
     * @param item
     * @return
     */
    public void add(E item)
    {
        data.add(item);
        int child = data.size()-1;
        bubbleUp(child);
    }
    /**
     * moves index value up if it is less than the previous 
     * @param child
     */
    private void bubbleUp(int child)
    {
    	int parent = parent(child);
        if(exists(parent) && leftLessThanRight(child,parent))
        {
        	swapData(parent,child);
            bubbleUp(parent);
        }
    }
    /**
     * returns the parent of the inputed child
     * @param child
     * @return
     */
    private int parent(int child)
    {
    	return (child-1)/2;
    }
    /**
     * removes top element in heap
     */
	public void remove()
    {
        data.set(0, data.get(data.size()-1));
        data.remove(data.size()-1);
        if(!data.isEmpty())
        {
        	bubbleDown(0);
        }
    }
	/**
	 * starting at given index, moves it down heap if greater than children
	 * @param parent
	 */
	private void bubbleDown(int parent)
	{
		int leftChild = leftChild(parent);
        int rightChild = rightChild(parent);
        if((exists(leftChild)&&leftLessThanRight(leftChild, parent)) || (exists(rightChild) && leftLessThanRight(rightChild, parent)))
        {
            int smallerChild = returnSmaller(leftChild, rightChild);
            swapData(parent,smallerChild);
            bubbleDown(smallerChild);
        }
	}
	/**
	 * if a & b does not exist throws illegalArgumentException
	 * if a or b does not exist returns existing value
	 * else returns smaller value
	 * @param a
	 * @param b
	 * @return
	 */
	private int returnSmaller(int a,int b)
	{
		if(!exists(a) && !exists(b))
		{
			throw new IllegalArgumentException();
		}
		if(!exists(a))
		{
			return b;
		}
		else if(!exists(b))
		{
			return a;
		}
		else if(leftLessThanRight(a,b))
		{
			return a;
		}
		else
		{
			return b;
		}
	}
	/**
	 * returns value of left child of given parent
	 * @param parent
	 * @return
	 */
	private int leftChild(int parent)
	{
		return(2 * parent) + 1;
	}
	/**
	 * returns right child of given parent
	 * @param parent
	 * @return
	 */
	private int rightChild(int parent)
	{
		return leftChild(parent)+1;
	}
	/**
	 * Swaps a,b
	 * @param a
	 * @param b
	 */
	private void swapData(int a, int b)
	{
		E tempData = data.get(a);
        data.set(a, data.get(b));
        data.set(b, tempData);
	}
	/**
	 * returns true if left is less than right
	 * WARNING less is based of compare method
	 * @param left
	 * @param right
	 * @return
	 */
	private boolean leftLessThanRight(int left, int right)
	{
		return compare(data.get(left), data.get(right)) < 0 ;
	}
	/**
	 * returns true if index is within array bounds
	 * @param child
	 * @return
	 */
	private boolean exists(int index)
	{
		return index >= 0 && index < data.size();
	}
    public void print()
    {
        System.out.println(data);
    }
    /**
     * delegate compare to extended class's
     * @param e
     * @param e2
     * @return
     */
    protected abstract int compare(E e, E e2);
}

