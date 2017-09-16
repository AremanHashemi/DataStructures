package edu.miracosta.cs113;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.lang.Exception;
public class Polynomial
{
	private List<Term> terms;
	private Polynomial()
	{
		terms = new ArrayList<Term>();
	}
	private Polynomial(List<Term> inputPolynomial)
	{
		terms = inputPolynomial;
	}
	public String toString()
	{
		return termsToString(terms);
	}
	private static String termsToString(List<Term> terms)
	{
		if(terms.isEmpty())
		{
			return "0";
		}
		StringBuilder builder = new StringBuilder();
		Iterator<Term> termIterator = terms.iterator();
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
	public static class Builder
	{ 
		private List<Term> terms;
		public Builder()
		{
			terms = new ArrayList<Term>();
		}
		public Builder add(Term term)
		{
			terms.add(term);
			return this;
		}
		public Builder addTerm(double exponent, double coefficient)
		{
			Term term = new Term(exponent, coefficient);
			this.add(term);
			return this;
		}
		public String toString()
		{
			return termsToString(terms);
		}
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
