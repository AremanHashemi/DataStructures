///**
// * Polynomial
// * Generate first and second polynomial (ArrayList<Term>)
// * Add first and second ArrayList into sumPolynomial
// * Print sumArrayList
// * 		
// * @author Areman Hashemi<AremanHashemi@hotmail.com>
// * @version 1.0
// */
//package test;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import edu.miracosta.cs113.Polynomial;
//import edu.miracosta.cs113.Polynomial.Builder;
//
//import java.util.InputMismatchException;
//public class PolynomialDriver
//{
//	public static Polynomial generatePolynomial()
//	{
//		Polynomial.Builder builder = new Polynomial.Builder();
//		String polynomialControl;
//		double coefficientInput, exponentInput;	
//		Scanner keyboard = new Scanner(System.in);
//		System.out.println("Welcome");
//		System.out.println("Please enter an ordered polynomial");
//		do
//		{
//			try
//			{
//				System.out.print("Exponent of next highest term : ");
//				exponentInput = keyboard.nextDouble();
//				System.out.print("Coefficient : ");
//				coefficientInput = keyboard.nextDouble();
//				builder.addTerm(exponentInput, coefficientInput);
//			}
//			catch(InputMismatchException e)
//			{
//				System.out.println("Error: Please enter numbers only");
//			}
//			System.out.println("Current Polynomial is : " + builder);
//			System.out.println("\nEnter q to exit or any other value to continue");
////			if(keyboard.hasNext())
////			{
//			keyboard.nextLine();
//			polynomialControl = keyboard.nextLine();
////			}
//		}while(!(polynomialControl.equals("q") || polynomialControl.equals("Q")));
//		keyboard.close();
//		return builder.build();
//	}
//	}
//	public static void main(String [] args)
//	{
////		List<Term>firstPolynomial = generatePolynomial();
////		List<Term>secondPolynomial = generatePolynomial();
////		List<Term>sumPolynomial = addPolynomials(firstPolynomial,secondPolynomial);
////		for(int i = 0; i < sumPolynomial.size(); i++)
////		{
////			System.out.print(sumPolynomial);
////		}
//	}
//}