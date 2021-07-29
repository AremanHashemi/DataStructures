/**
 * Hw5 StackTester - Tests an implementation of a linkedList stack using palindromes
 * 
 * Testing DataStructure LinkedListStack:
 * 	pushOnceTest() - tests peek as well 
 * 	pushTwiceTest()
 * 	popTest()
 * 
 * Testing Pallindrome method using LinkedListStack:
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
		assertEquals(true,HelperMethods.checkPalinDrome("Aibohphobia"));
	}
	@Test
	public void palindromeTestOdd()
	{
		assertEquals(true,HelperMethods.checkPalinDrome("wow"));
	}
	@Test
	public void palindromeTestFalse()
	{
		assertEquals(false,HelperMethods.checkPalinDrome("wohw"));
	}
}
