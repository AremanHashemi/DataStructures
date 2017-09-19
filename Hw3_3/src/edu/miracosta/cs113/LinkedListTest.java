package edu.miracosta.cs113;

public class LinkedListTest
{
	public static void testEmptyLinkedList() throws AssertionError 
	{
		LinkedList<String> students = new LinkedList<String>();
		assert students.size() == 0;
		try
		{
			students.get(0);
			assert false;
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("Emply List Passed");
		}
	}
	public static void testAddToFront() throws AssertionError
	{
		LinkedList<String> students = new LinkedList<String>();
		students.addToFront("Mike");
		students.addToFront("Jim");
		assert students.get(1).equals("Mike");
		assert students.get(0).equals("Jim");
		assert students.size()==2;
		System.out.println("Test AddToFront Passed");
	}
	public static void addToEnd() throws AssertionError
	{
		LinkedList<String> students = new LinkedList<String>();
		students.addToEnd("Mike");
		students.addToEnd("Jim");
		assert students.get(0).equals("Mike");
		assert students.get(1).equals("Jim");
		assert students.size()==2;
		System.out.println("Test addtoEnd Passed");
	}
	public static void removeHead() throws AssertionError
	{
		LinkedList<String> students = new LinkedList<String>();
		students.addToEnd("Mike");
		students.addToEnd("Jim");
		students.removeHead();
		assert students.get(0).equals("Jim");
		assert students.size()==1;
		System.out.println("Test removeHead Passed");
	}
	public static void remove() throws AssertionError
	{
		LinkedList<String> students = new LinkedList<String>();
		students.addToEnd("Mike");
		students.addToEnd("Jim");
		students.remove("Mike");
		assert students.get(0).equals("Jim");
		assert students.size()==1;
		System.out.println("Test removeByName Passed");
	}
	public static void main(String[] args)
	{
		testEmptyLinkedList();
		testAddToFront();
		addToEnd();
		removeHead();
		remove();
		System.out.println("Test Passed");
	}
}
