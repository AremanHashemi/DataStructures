package edu.miracosta.cs113;

public class LinkedList<E>
{
	private static class Node<E>
	{
		private E data;
		private Node<E> next;
		private Node(E data)
		{
			this.data = data;
			this.next = null;
		}
		private Node(E data, Node<E> next)
		{
			this.data = data;
			this.next = next;
		}
	}
	private Node<E> head;
	private int size;
	public LinkedList()
	{
		head = null;
		size = 0;
	}
	/**
	 * Adds new node with data to front of the list
	 * @param data
	 */
	public void addToFront(E data)
	{
		this.head = new Node(data, this.head);
		size++;
	}
	/**
	 * Adds new node with data to the end of the list
	 * @param data
	 */
	public void addToEnd(E data)
	{
		if(head == null)
		{
			this.head = new Node(data, null);
		}
		else
		{
			Node<E> pointer = head;
			while(pointer.next != null)
			{
				pointer = pointer.next;
			}
			pointer.next = new Node(data, null);
		}
		size++;
	}
	/**
	 * 
	 * @return size
	 */
	public int size()
	{
		return size;
	}
	/**
	 * If requested index is out of bounds throws IndexOutOfBoundsException
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public E get(int index) throws IndexOutOfBoundsException
	{
		if(index >= size || index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			int i = 0;
			Node<E> pointer = head;
			while(i != index)
			{
				i++;
				pointer = pointer.next;
			}
			return pointer.data;
		}
	}
	/** 
	 * Searches for data in list, 
	 * removes if found, 
	 * returns true if it was removed
	 * returns false if not found
	 * @param data
	 * @return
	 */
	public boolean remove(E data)
	{
		if(head!=null)
		{
			Node<E> pointer = head;
			Node<E> previous = null;
			
			while(pointer!=null)
			{
				if(pointer.data.equals(data))
				{
					if(pointer == head)
					{
						head = pointer.next;
					}
					else
					{
						previous.next = pointer.next;
					}
					size--;
					return true;
				}
				previous = pointer;
				pointer = pointer.next;
			}
		}
		return false;
		
	}
	/**
	 * Removes the first item in the list
	 */
	public void removeHead()
	{
		if(head!=null)
		{
			this.head = this.head.next;
			size--;
		}
		
	}
}
