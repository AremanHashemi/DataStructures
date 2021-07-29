/**
 * Lab1.java
 * Prints 1-100 except:
 *  mulitples of 3 are printed as "Fizz"
 *  multiples of 5 are printed as "Buzz
 *  multiples of of both 3 & 5 are printed as "Fizzbuzz"
 * @author Areman Hashemi<AremanHashemi@hotmail.com>
 * @version 1.0
 */
package edu.miracosta.cs113;
public class Lab1
{
    public static void main(String[] args)
    {
        for(int i = 1; i<=100; i++)
        {
            if(i%3==0 && i%5==0)
            {
                System.out.println("FizzBuzz");
            }
            else if(i%3==0)
            {
                System.out.println("Fizz");
            }
            else if(i%5==0)
            {
                System.out.println("Buzz");
            }
            else
            {
                System.out.println(i);
            }
        }
    }
}
