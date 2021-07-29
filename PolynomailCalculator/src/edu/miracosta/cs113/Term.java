package edu.miracosta.cs113;

public class Term implements Comparable<Term>
{
	private double exponent;
	private double coefficient;
	

	public Term()
	{
		exponent = 0;
		coefficient = 0;
	}
	public Term(double exponent, double coefficient)
	{
		setExponent(exponent);
		setCoefficient(coefficient);
	}	
	public void setExponent(double exponent)
	{
		this.exponent = exponent;
	}
	public void setCoefficient(double coefficient)
	{
		this.coefficient = coefficient;
	}
	public double getExponent()
	{
		return exponent;
	}
	public double getCoefficient()
	{
		return coefficient;
	}
	public static Term add(Term termOne, Term termTwo)
	{
		assert termOne.getExponent() == termTwo.getExponent();
		if(termOne.getExponent()== termTwo.getExponent())
		{
			return new Term(termOne.getExponent(),termOne.getCoefficient() + termTwo.getCoefficient());
		}
		else
		{
			return null;
		}
	}
	/**
	 * Returns negative int if object is less than, 0 if equal, positive if greater
	 * ONLY COMPARES EXPONENTS NOT COEFFICIENTS 
	 */
	public int compareTo(Term other)
	{
		if(this.exponent > other.getExponent())
		{
			return 1;
		}
		else if(this.exponent < other.getExponent())
		{
			return -1;
		}
		else 
			return 0;
	}
	
	public String toString()
	{
		return coefficient + "X^" + exponent ;
	}

}
