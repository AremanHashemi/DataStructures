/**
 * Hw4 DoubleLinkedListTesterTest- Junit tests for generic double linked list & Polynomial
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
import java.util.ListIterator;
import static org.junit.Assert.*;
import org.junit.Test;

public class DoubleLinkedListTesterTest 
{
	/**
	 * Tests adding one number to an empty DoubleLinkedList
	 */
	@Test
	public void testAdd()
	{
		DoubleLinkedList<Integer> nums = new DoubleLinkedList<Integer>();
		nums.add(5);
		int [] testArray = {5};
		testEquals(nums,testArray);
	}
	/**
	 * tests adding an object into the middle of a DoubleLinkedList
	 */
	@Test
	public void testAddToSpot()
	{
		DoubleLinkedList<Integer> nums = new DoubleLinkedList<Integer>();
		nums.add(5);
		nums.add(7);
		nums.add(1,6);
		int [] testArray = {5,6,7};
		testEquals(nums,testArray);
	}
	/**
	 * tests DoubleLinkedLists get method
	 */
	@Test
	public void testGet()
	{
		DoubleLinkedList<Integer> nums = new DoubleLinkedList<Integer>();
		nums.add(5);
		nums.add(7);
		assertEquals(nums.get(0).intValue(),5);
	}
	/**
	 * tests DoubleLinkedLists remove(position)
	 */
	@Test
	public void testRemovePosition()
	{
		DoubleLinkedList<Integer> nums = new DoubleLinkedList<Integer>();
		nums.add(5);
		nums.add(6);
		nums.add(7);
		nums.remove(0);
		int [] testArray = {6,7};
		testEquals(nums,testArray);
	}
	/**
	 * tests DoubleLinkedLists remove(object)
	 */
	@Test
	public void testRemoveObject()
	{
		DoubleLinkedList<Integer> nums = new DoubleLinkedList<Integer>();
		nums.add(5);
		nums.add(6);
		nums.add(7);
		nums.remove((Integer)6);
		int [] testArray = {5,7};
		testEquals(nums,testArray);
	}
	/**
	 * tests DoubleLinkedLists set
	 */
	@Test
	public void testSet()
	{
		DoubleLinkedList<Integer> nums = new DoubleLinkedList<Integer>();
		nums.add(5);
		nums.add(6);
		nums.add(7);
		nums.set(1,11);
		int [] testArray = {5,11,7};
		testEquals(nums,testArray);
	}
	/**
	 * Tests that an empty Polynomial class will have no terms inside
	 * @throws AssertionError if failed
	 */
	@Test
	public void testEmptyBuilder() throws AssertionError 
	{
		Polynomial.Builder builder = new Polynomial.Builder();
		Polynomial emptyPolynomial = builder.build();
		System.out.println(emptyPolynomial.toString());
		assert emptyPolynomial.toString().equals("0");
	}
	/**
	 * Tests that a single term polynomial will store correctly
	 * @throws AssertionError if failed
	 */
	@Test
	public void testFirstOrderPolynomial() throws AssertionError 
	{
		Polynomial.Builder builder = new Polynomial.Builder();
		Term term = new Term(2,4);
		Polynomial singlePolynomial = builder.add(term).build();
		System.out.println(singlePolynomial.toString());
		assert singlePolynomial.toString().equals("4.0X^2.0");
	}
	/**
	 * Tests a polynomial with the same exponent gets reduced into a simpler polynomial
	 * @throws AssertionError if failed
	 */
	@Test
	public void testSecondOrderPolynomialSame() throws AssertionError 
	{
		Polynomial.Builder builder = new Polynomial.Builder();
		Term term1 = new Term(2,4);
		Term term2 = new Term(2,4);
		Polynomial singlePolynomial =
			builder.add(term1).add(term2).build();
		System.out.println(singlePolynomial.toString());
		assert singlePolynomial.toString().equals("8.0X^2.0");
	}
	/**
	 * Tests a polynomial with two terms that cannot be simplified
	 * @throws AssertionError
	 */
	@Test
	public void testSecondOrderPolynomialDifferent() throws AssertionError 
	{
		Polynomial.Builder builder = new Polynomial.Builder();
		Term term1 = new Term(2,4);
		Term term2 = new Term(3,4);
		Polynomial singlePolynomial =
			builder.add(term1).add(term2).build();
		System.out.println(singlePolynomial.toString());
		assert singlePolynomial.toString().equals("4.0X^3.0 + 4.0X^2.0");
	}
	/**
	 * Tests the add method by adding two second term polynomials together
	 * @throws AssertionError
	 */
	@Test
	public void testAddPolynomials() throws AssertionError
	{
		Polynomial poly1 = 
				new Polynomial.Builder()
						.addTerm(3,4)
						.addTerm(2,3)
						.build();
		Polynomial poly2 = 
				new Polynomial.Builder()
						.addTerm(3,4)
						.addTerm(2,3)
						.build();
		Polynomial sum = Polynomial.addPolynomials(poly1,poly2);
		System.out.println(poly1 + " + " + poly2 + " = " + sum);
		assert sum.toString().equals("8.0X^3.0 + 6.0X^2.0");
	}
	/**
	 * Tests adding an empty polynomial to a second term polynomial
	 * @throws AssertionError
	 */
	@Test
	public void testAddingToZero() throws AssertionError
	{
		Polynomial poly1 = 
				new Polynomial.Builder()
					.build();
		Polynomial poly2 = 
				new Polynomial.Builder()
				.addTerm(3,4)
				.addTerm(2,3)
				.build();
		Polynomial sum = Polynomial.addPolynomials(poly1,poly2);
		System.out.println(poly1 + " + " + poly2 + " = " + sum);
		assert sum.toString().equals("4.0X^3.0 + 3.0X^2.0");
	}
	/**
	 * Used to test actual list against a test list
	 * Tests forward loop to test that next calls are working properly
	 * Tests backward loop to test previous calls working
	 * @param actual
	 * @param test
	 */
	private void testEquals(DoubleLinkedList<Integer> actual, int [] test)
	{ 
		assertEquals(actual.size(), test.length);
		ListIterator<Integer> actualIterator = actual.listIterator();
		for(int i = 0; i < test.length; i++)
		{
			assertEquals(actualIterator.next().intValue(), test[i]);
		}
		for(int i = test.length-1; i>0; i--)
		{
			assertEquals(actualIterator.previous().intValue(), test[i]);
		}
	}
	

}
