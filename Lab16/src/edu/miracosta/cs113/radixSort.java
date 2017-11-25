package edu.miracosta.cs113;

public class radixSort
{
	public static void main(String [] args)
	{
	
		int [] a = {3, 4, 20 ,132 , 214 , 42 ,34 ,521 ,2 , 31};
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i]+ " ");
		}
		System.out.println();
		sort(a);
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i]+ " ");
		}
	}
		/**
		 * find max 
		 * places numbers into bucket based on base 
		 * calculate index values by adding bucket values to the next one over
		 * decrement bucketValue and place a[] value into b[]
		 * set a = b 
		 * increment place value
		 * loop
		 * @param a
		 */
	    public static void sort(int[] a)
	    {
	        int[] b = new int[10];
	        int max = getMax(a);
	        int place = 1;
	        System.out.println(max);
	        while (max / place > 0)
	        {
	        	int[] bucket = new int[10];
	            for (int i = 0; i < a.length; i++)
	            {
	            	bucket[(a[i]/place) % 10]++;
	            }	      
	            for (int i = 1; i < 10; i++)
	            {
	            	bucket[i] += bucket[i - 1];
	            }        
	            for (int i = a.length - 1; i >= 0; i--)
	            {
	            	b[--bucket[(a[i]/place)%10]] = a[i];
	            }   
	            for (int i=0; i<a.length; i++)
	            {
	            	a[i] = b[i];
	            }	           
	            place *= 10;        
	        }
	    }  
	    public static int getMax(int[] a)
	    {
			int max = a[0];
			for (int i = 1; i < a.length; i++)
			{
				max = Math.max(a[i], max);
			}
			return max;
	    }
}
