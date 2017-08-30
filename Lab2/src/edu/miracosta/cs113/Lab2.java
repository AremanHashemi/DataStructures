/**
 * Lab2.java
 * Checks a method that tells if an input is a power of 2
 * 	-Checks for special case of 1 being a product of 0 * 0
 * 	-DO
 * 		-Check if rem
 * @author Areman Hashemi<AremanHashemi@hotmail.com>
 * @version 1.0
 */
package edu.miracosta.cs113;
public class Lab2
{
    /**
     * Checks if input is a power of 2
     * @param input number to be checked a power of 2
     * @return true if input is a power of 2, false if is not a power of 2
     */
    public static boolean isPowerOf2(int input)
    {
        if(input ==0)
        {
            return true;
        }
        do
        {
            if(input%2!= 0)
            {
                return false;
            }
            input = input / 2;
        }while(input !=1);
        return true;
    }
    public static void main(String [] args)
    {
        System.out.println("Is 0    a power of 2 :" + isPowerOf2(0));
        System.out.println("Is 8    a power of 2 :" + isPowerOf2(8));
        System.out.println("Is 128  a power of 2 :" + isPowerOf2(128));
        System.out.println("Is 1024 a power of 2 :" + isPowerOf2(1024));
        System.out.println();
        System.out.println("Is 3    a power of 2 :" + isPowerOf2(3));
        System.out.println("Is 10   a power of 2 :" + isPowerOf2(10));
        System.out.println("Is 40   a power of 2 :" + isPowerOf2(10));
    }
}
