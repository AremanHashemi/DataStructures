package edu.miracosta.cs113;
import java.util.EmptyStackException;
import java.util.List;
import java.util.LinkedList;
public class ListStack<E> implements Stack<E>
{
	List<E> data;
	/**
	 * Default constructor
	 */
	public ListStack()
	{
		data = new LinkedList<E>();
	}
	/**
	 * Returns if data is empty
	 */
	public boolean empty()
	{
		return (boolean)data.isEmpty();
	}
	/**
	 * looks at the next data
	 * returns null if is empty
	 */
	public E peek()
	{
		if(empty())
		{
			return null; 
		}
		return data.get(0);
	}
	/**
	 * removes and returns next data
	 * throws exception if empty
	 */
	public E pop()
	{
		if (empty()) 
		{
			throw new EmptyStackException();
		}
		E newData = data.remove(0);
		return newData;
	}
	/**
	 * adds to stack
	 * returns object
	 */
	public E push(E obj)
	{
		data.add(0,obj);
		return obj;
	}
}
