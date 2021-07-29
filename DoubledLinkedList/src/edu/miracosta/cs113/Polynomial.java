package edu.miracosta.cs113;
import java.util.List;
import java.util.ListIterator;
import java.util.Collections;
import java.util.Iterator;
public class Polynomial
{
	private List<Term> terms;
	private Polynomial()
	{
		terms = new DoubleLinkedList<Term>();
	}
	private Polynomial(List<Term> inputPolynomial)
	{
		terms = inputPolynomial;
	}
	public String toString()
	{
		return termsToString(terms);
	}
	/**
	 * Takes in a list of terms 
	 * returns a string of terms
	 * @param terms
	 * @return toString
	 */
	private static String termsToString(List<Term> terms)
	{
		if(terms.isEmpty())
		{
			return "0";
		}
		StringBuilder builder = new StringBuilder();
		ListIterator<Term> termIterator = terms.listIterator();
		while(termIterator.hasNext())
		{
			builder.append(termIterator.next());
			if(termIterator.hasNext())
			{
				builder.append(" + ");
			}
		}
		return builder.toString();
	}
	/**
	 * adds two polynomials together and returns a new polynomial of the sum
	 * @param firstPolynomial
	 * @param secondPolynomial
	 * @return sum of the two polynomials 
	 */
	public static Polynomial addPolynomials(Polynomial firstPolynomial,Polynomial secondPolynomial)
	{
		Polynomial.Builder sumPolynomial = new Polynomial.Builder();
		int firstIterator = 0;
		int secondIterator = 0;
		int compareValue = 0;
		while(firstIterator < firstPolynomial.terms.size() && secondIterator < secondPolynomial.terms.size())
		{
			Term term1 = firstPolynomial.terms.get(firstIterator);
			Term term2 = secondPolynomial.terms.get(secondIterator);
			compareValue = term1.compareTo(term2);
			if( compareValue > 0)
			{
				sumPolynomial.add(term1);
				firstIterator++;
			}
			else if(compareValue < 0)
			{
				sumPolynomial.add(term2);
				secondIterator++;
			}
			else
			{
				Term sumTerm = Term.add(term1, term2);
				sumPolynomial.add(sumTerm);
				firstIterator++;
				secondIterator++;
			}
		}
		if(firstIterator < firstPolynomial.terms.size())
		{
			for(int i = firstIterator; i < firstPolynomial.terms.size(); i++)
			{
				sumPolynomial.add(firstPolynomial.terms.get(i));
			}
		}
		else if(secondIterator < secondPolynomial.terms.size())
		{
			for(int i = secondIterator; i < secondPolynomial.terms.size(); i++)
			{
				sumPolynomial.add(secondPolynomial.terms.get(i));
			}
		}
		return sumPolynomial.build();
	}
	/**
	 * Use a builder class to insure all created polynomials 
	 * are sorted and simplified before being returned
	 * @author arema
	 */
	public static class Builder
	{ 
		private List<Term> terms;
		public Builder()
		{
			terms = new DoubleLinkedList<Term>();
		}
		/**
		 * adds term to builders terms
		 * @param term
		 * @return
		 */
		public Builder add(Term term)
		{
			terms.add(term);
			return this;
		}
		/**
		 * adds a term defined by exponent and coefficient to builders list
		 * @param exponent
		 * @param coefficient
		 * @return
		 */
		public Builder addTerm(double exponent, double coefficient)
		{
			Term term = new Term(exponent, coefficient);
			this.add(term);
			return this;
		}
		/**
		 * returns the polynomial in a string
		 */
		public String toString()
		{
			return termsToString(terms);
		}
		/**
		 * Returns a built polynomial that is in order and simplified
		 * @return polynomial
		 */
		public Polynomial build()
		{
			if(terms.isEmpty())
			{
				return new Polynomial();
			}
			Collections.sort(terms, Collections.reverseOrder());
			int i = 0;
			while(i < terms.size()-1)
			{
				if(terms.get(i).compareTo(terms.get(i+1)) == 0)
				{
					terms.set(i, Term.add(terms.get(i),terms.get(i+1)));
					terms.remove(i+1);
				}
				else
				{
					i++;
				}
			}
			return new Polynomial(terms);
		}
	}
}
