/**
 * Hw5 StackTester - Tests an implementation of a linkedList stack using palindromes
 * Testing DataStructure LinkedListStack
 * 	pushOnceTest() - tests peek as well 
 * 	pushTwiceTest()
 * 	popTest()
 * 
 * Testing Pallindrome method using LinkedListStack
 * 	palindromeTestEven()
 * 	palindromeTestOdd()
 * 	palindromeTestFalse()
 * @author Areman Hashemi<AremanHashemi@hotmail.com>
 * @version 2.0
 */
package edu.miracosta.cs113;
import static org.junit.Assert.*;
import org.junit.Test;
public class StackTester
{
	@Test
	public void pushOnceTest()
	{
		Stack<Integer> testStack = new ListStack<Integer>();
		testStack.push(1);
		assertEquals(1,testStack.peek().intValue());
	}
	@Test
	public void pushTwiceTest()
	{
		Stack<Integer> testStack = new ListStack<Integer>();
		testStack.push(1);
		testStack.push(2);
		assertEquals(2,testStack.pop().intValue());
		assertEquals(1,testStack.pop().intValue());
	}
	@Test
	public void popTest()
	{
		Stack<Integer> testStack = new ListStack<Integer>();
		testStack.push(1);
		testStack.push(2);
		testStack.push(3);
		assertEquals(3,testStack.pop().intValue());
		assertEquals(2,testStack.pop().intValue());
		assertEquals(1,testStack.pop().intValue());
		assertEquals(null,testStack.peek());
	}
	@Test
	public void palindromeTestEven()
	{
		assertEquals(true,checkPalinDrome("Aibohphobia"));
	}
	@Test
	public void palindromeTestOdd()
	{
		assertEquals(true,checkPalinDrome("wow"));
	}
	@Test
	public void palindromeTestFalse()
	{
		assertEquals(false,checkPalinDrome("wohw"));
	}
	private boolean checkPalinDrome(String input)
	{
		int length, halfLength;
		Stack<Character> inputStack = new ListStack<Character>();
		Stack<Character> firstHalfStack = new ListStack<Character>();
		Stack<Character> secondHalfStack;
		input = input.toLowerCase();
		input = input.replaceAll("\\s","");
		length = input.length();
		halfLength = length/2;
		while(!input.isEmpty())
		{
			char nextChar = input.charAt(0);
			input = input.substring(1);
			inputStack.push(nextChar);
		}
		for(int i = 0; i < halfLength; i++)
		{
			firstHalfStack.push(inputStack.pop());
		}
		secondHalfStack = inputStack;
		if(halfLength%2 != 0)
		{
			secondHalfStack.pop();
		}
		for(int i = 0; i < halfLength; i++)
		{
			char firstStackValue, secondStackValue;
			firstStackValue = firstHalfStack.pop();
			secondStackValue = secondHalfStack.pop();
			if(firstStackValue != secondStackValue)
			{
				return false;
			}
		}
		return true;
	}
}