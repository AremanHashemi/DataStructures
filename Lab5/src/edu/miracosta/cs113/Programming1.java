/**
 * Lab5 - Create a driver for replace and delete methods
 * -Create an ArrayList<String> aList
 * ADD the following to aList[book,table,candle,box,pen,pencil,book]
 * PRINT aList
 * REPLACE(book with lamp)
 * PRINT aList
 * DELETE(first instance of lamp)
 * PRINT aList
 * 
 * @author Areman Hashemi<AremanHashemi@hotmail.com>
 * @version 1.0
 */

package edu.miracosta.cs113;
import java.util.ArrayList;
import java.util.List;
public class Programming1 
{
	public static void main(String [] args)
	{
		List<String> aList = new ArrayList<String>();
		aList.add("book");
		aList.add("table");
		aList.add("candle");
		aList.add("box");
		aList.add("pen");
		aList.add("pencil");
		aList.add("book");
		System.out.println(aList);
		System.out.println("Replacing book with lamp");
		replace(aList,"book","lamp");
		System.out.println(aList);
		delete(aList,"lamp");
		System.out.println("Deleting first instance of lamp");
		System.out.println(aList);
	}
	/**
	 * replaces each occurrence of oldItem with newItem in aList
	 * @param aList
	 * @param oldItem
	 * @param newItem
	 */
	public static void replace(List<String> aList, String oldItem, String newItem)
	{
		for(int i = 0; i < aList.size(); i++)
		{
			if(aList.get(i).equals(oldItem))
			{
				aList.set(i, newItem);
			}
		}
	}
	/**
	 * Deletes first occurrence of target in aList
	 * breaks loop after first deletion
	 * @param aList
	 * @param target
	 */
	public static void delete(List<String> aList, String target)
	{
		for(int i = 0; i < aList.size(); i++)
		{
			if(aList.get(i).equals(target))
			{
				aList.remove(i);
				break;
			}
		}
	}

}
