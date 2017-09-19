/**
 * Lab6_2
 * CREATE ARRAYLIST students ["Tom", "Dick", "Harry", "Sam""]
 * PRINT students
 * INSERT(Bill before Tom)
 * PRINT students
 * INSERT(Sue before Sam)
 * PRINT students
 * REMOVE(Bill)
 * PRINT students
 * REMOVE(Sam)
 * PRINT students
 * 
 * @author Areman Hashemi<AremanHashemi@hotmail.com>
 * @version 1.0
 */
package edu.miracosta.cs113;
import java.util.ArrayList;
import java.util.List;
public class Programming_2 
{
	public static void main(String[] args)
	{
		List<String> students = new ArrayList<String>();
		students.add("Tom");
		students.add("Dick");
		students.add("Harry");
		students.add("Sam");
		System.out.println(students);
		students.add(0,"Bill");
		System.out.println(students);
		students.add(4,"Sue");
		System.out.println(students);
		students.remove("Bill");
		System.out.println(students);
		students.remove("Sam");
		System.out.println(students);
	}
}
