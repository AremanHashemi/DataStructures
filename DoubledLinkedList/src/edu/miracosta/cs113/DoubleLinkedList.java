package edu.miracosta.cs113;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
public class DoubleLinkedList<E> implements List<E>
{
    private Node<E> head;
    private Node<E> tail;
    private int size;
    public DoubleLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }
    private static class Node<E>
    {
        private E data;
        private Node<E> next;
        private Node<E> prev;
        private Node(E data)
        {
            this.data = data;
        }
    }
    private class DoubleListIterator implements ListIterator<E>
    {
        private Node <E> nextItem;
        private Node <E> lastItemReturned;
        private int index = 0;
        public DoubleListIterator()
        {
            nextItem = head;
        }
        public DoubleListIterator(int i)
        {
            if(i < 0 || i > size)
            {
                throw new IndexOutOfBoundsException("Invalid index " + i);
            }
            lastItemReturned = null;
            if(i == size)
            {
                index = size;
                nextItem = null;
            }
            else
            {
                nextItem = head;
                for(index = 0; index < i; index++)
                {
                    nextItem = nextItem.next;
                }
            }
        }
        /*
         * Inserts object obj into the list just before the item that would be returned by the next call to method next
         * and after the item that would have been returned by method previous.
         * If method previous is called after add, the newly inserted object will be returned.
         * (non-Javadoc)
         * @see java.util.ListIterator#add(java.lang.Object)
         */
        public void add(E obj)
        {
            if(head == null)
            {
                head = new Node<E>(obj);
                tail = head;        
            }
            else if (nextItem == null)
            {
                Node<E> newNode = new Node<E>(obj);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            else
            {
                Node<E> newNode = new Node<E>(obj);
                newNode.prev = nextItem.prev;
                nextItem.prev.next = newNode;
                newNode.next = nextItem;
                nextItem.prev = newNode;
            }
            size++;
            index++;
        }
        /*
         * Returns true if next will not throw an exception.
         */
        public boolean hasNext()
        {
            return nextItem != null;
        }
        /*
         * 	Returns true if previous will not throw an exception.

         * (non-Javadoc)
         * @see java.util.ListIterator#hasPrevious()
         */
        public boolean hasPrevious()
        {
            return (nextItem == null && size !=0) || nextItem.prev != null;
        }
        /*
         * 	Returns the next object and moves the iterator forward.
         * If the iterator is at the end, the NoSuchElementException is thrown.
         * (non-Javadoc)
         * @see java.util.ListIterator#hasPrevious()
         */
        public E next()
        {
            if(!hasNext())
            {
                throw new NoSuchElementException();
            }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }
        /*
         * Returns the index of the item that will be returned by the next call
         *  to next. If the iterator is at the end, the list size is returned.

         * (non-Javadoc)
         * @see java.util.ListIterator#hasPrevious()
         */
        public int nextIndex()
        {
            if(hasNext())
            {
                return index+1;
            }
            else
            {
                return index;
            }
        }
        /*
         * 	Returns the previous object and moves the iterator backward.
         *  If the iterator is at the beginning of the list,
         *  the NoSuchElementExcepton is thrown.
         * (non-Javadoc)
         * @see java.util.ListIterator#hasPrevious()
         */
        public E previous()
        {
            if(!hasPrevious())
            {
                throw new NoSuchElementException();
            }
            if(nextItem == null)
            {
                nextItem = tail;
            }
            else
            {
                nextItem = nextItem.prev;
            }
            lastItemReturned = nextItem;
            index--;
            return lastItemReturned.data;
        }
        /*
         * 	Returns the index of the item that will be returned by the next
         *  call to previous.
         *  If the iterator is at the beginning of the list, −1 is returned.

         * (non-Javadoc)
         * @see java.util.ListIterator#hasPrevious()
         */
        public int previousIndex()
        {
            if(hasPrevious())
            {
            	return index-1;
            }
            else
            {
            	return -1;
            }
        }
        /*
         * 	Removes the last item returned from a call to next or previous.
         * If a call to remove is not preceded by a call to next or previous,
         * the IllegalStateException is thrown.
         * (non-Javadoc)
         * @see java.util.ListIterator#hasPrevious()
         */
        public void remove()
        {
        	if(lastItemReturned == null)
        	{
        		throw new IllegalStateException();
        	}
        	else if(lastItemReturned == head)
        	{
        		head = head.next;
        		head.prev = null;
        	}
        	else if(lastItemReturned == tail)
        	{
        		tail = tail.prev;
        		tail.next = null;
        	}
        	else
        	{
        		lastItemReturned.prev.next = nextItem;
        		nextItem.prev = lastItemReturned.prev;
        	}
        	index--;
        	size--;
        }
        /*
         * 	Replaces the last item returned from a call to next or
         * previous with obj. If a call to set is not preceded by a
         * call to next or previous, the IllegalStateException is thrown.
         * (non-Javadoc)
         * @see java.util.ListIterator#hasPrevious()
         */
        public void set(E obj)
        {
        	if(lastItemReturned == null)
        	{
        		throw new IllegalStateException();
        	}
        	else
        	{
        		lastItemReturned.data = obj; 
        	}
        }
    }
    /**
     * adds an element at the index 
     * throws outOfBoundsException if given index is out of bounds
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) 
    {
    	if(index > size || index < 0)
    	{
    		throw new IndexOutOfBoundsException();
    	}
        ListIterator<E> iterator = listIterator(index);
        iterator.add(element);
    }
    /**
     * adds an object at the end of the lsit
     * @param obj
     * @return
     */
    @Override
    public boolean add(E obj) 
    {
    	if(head == null)
		{
			this.head = new Node<E>(obj);
			this.tail = head;
		}
		else
		{
			tail.next = new Node<E>(obj);
			tail.next.prev = tail;
			tail = tail.next; 
			
		}
    	size++;
        return true;
    }
    /**
     * returns the object at the given index
     * Throws out of bounds exception if given index is larger or smaller than size
     * @param index
     * @return
     */
    @Override
    public E get(int index) 
    {
    	if(index > size || index < 0)
    	{
    		throw new IndexOutOfBoundsException();
    	}
    	else
    	{
    		DoubleListIterator iterator = new DoubleListIterator(); 
    		while(iterator.index != index)
            {
            	iterator.next();
            }
    		return iterator.next();
    	}
    }
    /**
     * deletes the list
     */
    @Override
    public void clear() 
    {
    	head = null;
    	size = 0;
    }
    /**
     * checks if the head is null
     * @return
     */
    @Override
    public boolean isEmpty()
    {
        return head==null;
    }
    /**
     * iterates through the list to find given object
     * if object is found removed and returns true
     * if not found returns false
     * @param o
     * @return
     */
    @Override
    public boolean remove(Object o) 
    {
		DoubleListIterator iterator = new DoubleListIterator(); 
		E data;
		boolean objectFound = false;
		while(iterator.hasNext() && !objectFound)
        {
        	data = iterator.next();
        	objectFound = data==o;
        }
		iterator.remove();
		return objectFound;
    }
    /**
     * Goes to the given index and removes the item
     * if given index is out of bounds throws out of bounds exception
     * @param index
     * @return
     */
    @Override
    public E remove(int index) 
    {
    	if(index > size || index < 0)
    	{
    		throw new IndexOutOfBoundsException();
    	}
    	DoubleListIterator iterator = new DoubleListIterator(); 
    	while(iterator.index != index)
    	{
    		iterator.next();
    	}
    	E data = iterator.next();
    	iterator.remove();
    	return data;
    }
    /**
     * Sets element at the given index
     * if given index is out of bounds 
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) 
    {
    	if(index > size || index < 0)
    	{
    		throw new IndexOutOfBoundsException();
    	}
    	DoubleListIterator iterator = new DoubleListIterator(); 
    	while(iterator.index != index)
    	{
    		iterator.next();
    	}
    	E data = iterator.next();
    	iterator.set(element);
    	return data;
    }
    @Override
    public int size() 
    {
        return size;
    }
    /**
     * iterates through the array
     * returns true if object found
     * returns false if object is not found
     * @param data
     * @return
     */
    @Override
    public boolean contains(Object data)
    {
        ListIterator<E> iterator = listIterator();
        while(iterator.hasNext())
        {
        	if(iterator.next().equals(data))
        	{
        		return true;
        	}
        }
        return false;
    }
    /**
     * iterates through the array
     * returns index if found
     * returns -1 if not found
     * @param data
     * @return
     */
    @Override
    public int indexOf(Object data) 
    {
    	ListIterator<E> iterator = listIterator();
        while(iterator.hasNext())
        {
        	if(iterator.next().equals(data))
        	{
        		return iterator.previousIndex();
        	}
        }
        return -1;
    }
    /**
     * iterates backwards through the array
     * returns index if found
     * returns -1 if not found
     * @param data
     * @return
     */
    public int lastIndexOf(Object data)
    {
    	ListIterator<E> iterator = listIterator(size);
        while(iterator.hasPrevious())
        {
        	if(iterator.previous().equals(data))
        	{
        		return iterator.nextIndex();
        	}
        }
        return -1;
    }
    @Override
    public boolean addAll(Collection<? extends E> arg0) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean addAll(int arg0, Collection<? extends E> arg1) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public Iterator<E> iterator() 
    {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public boolean containsAll(Collection<?> arg0) {
        // TODO Auto-generated method stub
        return false;
    }  
    @Override
    public ListIterator<E> listIterator() 
    {
        return new DoubleListIterator();
    }
    @Override
    public ListIterator<E> listIterator(int arg0)
    {
        return new DoubleListIterator(arg0);
    }
    @Override
    public boolean removeAll(Collection<?> arg0) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean retainAll(Collection<?> arg0) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        return null;
    }
    //Used by Collection.sort() Method in Polynomial
    @Override
    public Object[] toArray() 
    {
        Object[] convertedArray = new Object[size];
        ListIterator<E> iterator = listIterator();
        int i = 0;
        while(iterator.hasNext())
        {
        	convertedArray[i] = iterator.next();
        	i++;
        }
        return convertedArray;
    }
    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }
}
