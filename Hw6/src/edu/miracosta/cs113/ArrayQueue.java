package edu.miracosta.cs113;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ArrayQueue<E> implements Queue<E>
{
	private final int INITIAL_CAPACITY = 10;
	private int front, size, capacity, rear;
	private E[] data; 
	
	@SuppressWarnings("unchecked")
	public ArrayQueue()
	{
		capacity = INITIAL_CAPACITY;
		data = (E[])new Object[capacity];
		front = 0;
		rear = capacity - 1;
		size = 0;
	}
	public ArrayQueue(int initCapacity)
	{
		capacity = initCapacity;
		data = (E[])new Object[capacity];
		front = 0;
		rear = capacity - 1;
		size = 0;
	}
	@Override
	public boolean addAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear()
	{
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty()
	{
		if(size <= 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean offer(E item)
	{
		if (size == capacity) 
		{
			reallocate();
		}
		size++;
		rear = (rear + 1) % capacity;
		data[rear] = item;
		return true;
	}
	@Override
	public E element()
	{
		if (size == 0)
		{
			throw new NoSuchElementException();
		}
		return data[front];
	}
	@Override
	public E peek()
	{
		if (size == 0)
		{
			return null;
		}
		return data[front];
	}
	@Override
	public E poll() 
	{
		if (size == 0)
		{
			return null;
		}
		E result = data[front];
		front = (front + 1) % capacity;
		size--;
		return result;
	}

	@Override
	public E remove()
	{
		if (size == 0)
		{
			throw new NoSuchElementException();
		}
		E result = data[front];
		front = (front + 1) % capacity;
		size--;
		return result;
	}
	private void reallocate() 
	{
		int newCapacity = 2 * capacity;
		E[] newData = (E[])new Object[newCapacity];
		int j = front;
		for (int i = 0; i < size; i++) {
		newData[i] = data[j];
		j = (j + 1) % capacity;
		}
		front = 0;
		rear = size - 1;
		capacity = newCapacity;
		data = newData;
	}
}
