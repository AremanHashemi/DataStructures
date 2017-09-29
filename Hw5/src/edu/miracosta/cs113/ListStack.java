package edu.miracosta.cs113;
import java.util.EmptyStackException;
import java.util.List;
import java.util.LinkedList;
public class ListStack<E> implements Stack<E>
{
	List<E> data;
	public ListStack()
	{
		data = new LinkedList<E>();
	}
	public boolean empty()
	{
		return (boolean)data.isEmpty();
	}
	public E peek()
	{
		if(empty())
		{
			return null; 
		}
		return data.get(0);
	}
	public E pop()
	{
		if (empty()) 
		{
			throw new EmptyStackException();
		}
		E newData = data.remove(0);
		return newData;
	}
	public E push(E obj)
	{
		data.add(0,obj);
		return null;
	}
}
