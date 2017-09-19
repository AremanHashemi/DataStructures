package edu.miracosta.cs113;
import edu.miracosta.cs113.*;
public class PolynomialTest 
{
	public static void testEmptyBuilder() throws AssertionError 
	{
		Polynomial.Builder builder = new Polynomial.Builder();
		Polynomial emptyPolynomial = builder.build();
		System.out.println(emptyPolynomial.toString());
		assert emptyPolynomial.toString().equals("0");
	}
	public static void testFirstOrderPolynomial() throws AssertionError 
	{
		Polynomial.Builder builder = new Polynomial.Builder();
		Term term = new Term(2,4);
		Polynomial singlePolynomial = builder.add(term).build();
		System.out.println(singlePolynomial.toString());
		assert singlePolynomial.toString().equals("4.0X^2.0");
	}
	public static void testSecondOrderPolynomialSame() throws AssertionError 
	{
		Polynomial.Builder builder = new Polynomial.Builder();
		Term term1 = new Term(2,4);
		Term term2 = new Term(2,4);
		Polynomial singlePolynomial =
			builder.add(term1).add(term2).build();
		System.out.println(singlePolynomial.toString());
		assert singlePolynomial.toString().equals("8.0X^2.0");
	}
	public static void testSecondOrderPolynomialDifferent() throws AssertionError 
	{
		Polynomial.Builder builder = new Polynomial.Builder();
		Term term1 = new Term(2,4);
		Term term2 = new Term(3,4);
		Polynomial singlePolynomial =
			builder.add(term1).add(term2).build();
		System.out.println(singlePolynomial.toString());
		assert singlePolynomial.toString().equals("4.0X^3.0 + 4.0X^2.0");
	}
	public static void testAddPolynomials() throws AssertionError
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
	public static void testAddingToZero() throws AssertionError
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
	public static void main(String[] args)
	{
		testEmptyBuilder();
		testFirstOrderPolynomial();
		testSecondOrderPolynomialSame();
		testSecondOrderPolynomialDifferent();
		testAddingToZero();
		testAddPolynomials();
		
		System.out.println("Test Passed");
	}
	
}
