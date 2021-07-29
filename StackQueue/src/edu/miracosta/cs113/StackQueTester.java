/**
 * StackQueTester : Comparing stacks and ques
 * Create a stack with values [ -1,15,23,44,4,99]
 * Copy stack values into new stack and que
 * Pull all values out of stack and que
 * @author Areman Hashemi<AremanHashemi@hotmail.com>
 * @version 1.0
 */
package edu.miracosta.cs113;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class StackQueTester 
{
	public static void main(String args[])
	{
		Stack<Integer> myStack = new Stack<Integer>();
		Stack<Integer> myStack1 = new Stack<Integer>();
		Queue<Integer> myQue = new LinkedList<Integer>();
		myStack.push(-1);
		myStack.push(15);
		myStack.push(23);
		myStack.push(44);
		myStack.push(4);
		myStack.push(99);
		System.out.println("Top of my stack is : " + myStack.peek());
		for(Integer x: myStack)
		{
			myStack1.push(x);
			myQue.offer(x);
		}
		System.out.println("After storing each number from my stack into my que ");
		System.out.println("My Stack : " + myStack1);
		System.out.println("My QUE   : " + myQue);
		System.out.println("\nNow to pull from both of these adapters");
		while(!myQue.isEmpty())
		{
			System.out.println("Pulling|  Stack =" + myStack.pop() + " Que =" + myQue.poll());
		}
	}

}
