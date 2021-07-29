/**
 * LinkedListTest
 * testEmptyLinkedList()
 * testAddToFront()
 * testAddToEnd()
 * testRemoveHead()
 * testRemove()
 * PRINT("Test Passed")
 * @author Areman Hashemi<AremanHashemi@hotmail.com>
 * @version 1.0
 */
package edu.miracosta.cs113;
public class LinkedListTest
{
	/**
	 * Tests to make sure that you can't call get on an empty LinkedList
	 * @throws AssertionError
	 */
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
	/**
	 * Tests addToFront() 
	 * @throws AssertionError
	 */
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
	/**
	 * Tests addToEnd()
	 * @throws AssertionError
	 */
	public static void testAddToEnd() throws AssertionError
	{
		LinkedList<String> students = new LinkedList<String>();
		students.addToEnd("Mike");
		students.addToEnd("Jim");
		assert students.get(0).equals("Mike");
		assert students.get(1).equals("Jim");
		assert students.size()==2;
		System.out.println("Test addtoEnd Passed");
	}
	/**
	 * Tests removeHead()
	 * @throws AssertionError
	 */
	public static void testRemoveHead() throws AssertionError
	{
		LinkedList<String> students = new LinkedList<String>();
		students.addToEnd("Mike");
		students.addToEnd("Jim");
		students.removeHead();
		assert students.get(0).equals("Jim");
		assert students.size()==1;
		System.out.println("Test removeHead Passed");
	}
	/**
	 * Tests remove()
	 * @throws AssertionError
	 */
	public static void testRemove() throws AssertionError
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
		testAddToEnd();
		testRemoveHead();
		testRemove();
		System.out.println("Test Passed");
	}
}
