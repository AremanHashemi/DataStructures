package edu.miracosta.cs113;
import java.util.EmptyStackException;
public class ArrayStack<E> implements Stack<E>
{
	private final int INITIAL_CAPACITY = 10;
	private E[] data;
	private int topOfStack = -1;
	
	public ArrayStack()
	{
		data = (E[])new Object[INITIAL_CAPACITY];
	}
	public boolean empty()
	{
		if(topOfStack == -1)
		{
			return true;
		}
		return false;
	}
	public E peek() 
	{
		if (empty()) 
		{
			throw new EmptyStackException();
		}
		return data[topOfStack];
	}
	public E pop()
	{
		if (empty()) 
		{
			throw new EmptyStackException();
		}
		return data[topOfStack--];
	}
	public E push(E obj)
	{
		if (topOfStack == data.length - 1)
		{
			reallocate();
		}
		topOfStack++;
		data[topOfStack] = obj;
		return obj;
	}
	private void reallocate()
	{
		int newLength = data.length * 2;
		E[] newData = (E[]) new Object[newLength];
		for(int i = 0; i < topOfStack+1;i++)
		{
			newData[i] = data[i];
		}
		data = newData; 
	}
}
