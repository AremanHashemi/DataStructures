/**
 * Lab7 TestArrayStack- Junit tests for ArrayStack
 * Testing generic Double Linked List properties
	 * testAdd()
	 * testAddToSpot()
	 * testGet()
	 * testRemovePosition()
	 * testRemoveObject()
	 * testSet()
 * Testing Polynomial properties
	 * testEmptyBuilder();
	 * testFirstOrderPolynomial();
	 * testSecondOrderPolynomialSame();
	 * testSecondOrderPolynomialDifferent();
	 * testAddingToZero();
	 * testAddPolynomials();
 * @author Areman Hashemi<AremanHashemi@hotmail.com>
 * @version 2.0
 */
package edu.miracosta.cs113;
import static org.junit.Assert.*;
import java.util.EmptyStackException;
import org.junit.Test;
public class TestArrayStack 
{
	@Test
	public void pushOnceTest()
	{
		Stack<Integer> testStack = new ArrayStack<Integer>();
		testStack.push(1);
		assertEquals(1,testStack.peek().intValue());
	}
	@Test
	public void pushTwiceTest()
	{
		Stack<Integer> testStack = new ArrayStack<Integer>();
		testStack.push(1);
		testStack.push(2);
		assertEquals(2,testStack.pop().intValue());
		assertEquals(1,testStack.pop().intValue());
	}
	@Test(expected = EmptyStackException.class)
	public void popTest()
	{
		Stack<Integer> testStack = new ArrayStack<Integer>();
		testStack.push(1);
		testStack.push(2);
		testStack.push(3);
		assertEquals(3,testStack.pop().intValue());
		assertEquals(2,testStack.pop().intValue());
		assertEquals(1,testStack.pop().intValue());
		testStack.pop();
	}
	@Test
	public void reallocateTest()
	{
		Stack<Integer> testStack = new ArrayStack<Integer>();
		testStack.push(1);
		testStack.push(2);
		testStack.push(3);
		testStack.push(4);
		testStack.push(5);
		testStack.push(6);
		assertEquals(6,testStack.pop().intValue());
		assertEquals(5,testStack.pop().intValue());
		assertEquals(4,testStack.pop().intValue());
		assertEquals(3,testStack.pop().intValue());
		assertEquals(2,testStack.pop().intValue());
		assertEquals(1,testStack.pop().intValue());
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
	/**
	 * checkPalinDrome 
	 * Takes a string input, removes cases and spaces
	 * returns if the string input is a palindrome
	 * @param input
	 * @return true = isPalinDrome , false = isNotPalinDrome
	 */
	private boolean checkPalinDrome(String input)
	{
		int length, halfLength;
		Stack<Character> inputStack = new ArrayStack<Character>();
		Stack<Character> firstHalfStack = new ArrayStack<Character>();
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