/**
 * Lab4_Programming1 : Program compairs value of y1 & y2 for values n -> 100 in increments of 10
 * FOR n < 100  n+=10
 * 	PRINTF y1 = 100*n+10 
 * 	PRINTF y2 = 5*n*n+2
 * @author Areman Hashemi<AremanHashemi@hotmail.com>
 * @version 1.0
 */
package edu.miracosta.cs113;
public class Programming1 
{
	public static void main(String [] args)
	{
		double y1;
		double y2;
		System.out.println("y1 = 100*n+10 ---- y2 = 5*n*n+2 \n");
		for(int n=0; n <= 100; n+=10)
		{
			y1 = 100*n+10;
			y2 = 5*n*n+2;
			System.out.printf("For n = %d %.2f----%.2f%n",n,y1,y2);
		}
	}

}
