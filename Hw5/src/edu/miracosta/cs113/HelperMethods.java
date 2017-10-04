package edu.miracosta.cs113;

public class HelperMethods
{
	/**
	 * Takes String input, returns true if string is a Palindrome, else false
	 * @param input
	 * @return
	 */
	public static boolean checkPalinDrome(String input)
	{
		int length, halfLength;
		Stack<Character> inputStack = new ListStack<Character>();
		Stack<Character> firstHalfStack = new ListStack<Character>();
		Stack<Character> secondHalfStack;
		input = input.toLowerCase();
		input = input.replaceAll("\\s","");
		length = input.length();
		halfLength = length/2;
		while(!input.isEmpty())
		{
			char nextChar = input.charAt(0);
			input = input.substring(1);
			inputStack.push(nextChar);
		}
		for(int i = 0; i < halfLength; i++)
		{
			firstHalfStack.push(inputStack.pop());
		}
		secondHalfStack = inputStack;
		if(halfLength%2 != 0)
		{
			secondHalfStack.pop();
		}
		for(int i = 0; i < halfLength; i++)
		{
			char firstStackValue, secondStackValue;
			firstStackValue = firstHalfStack.pop();
			secondStackValue = secondHalfStack.pop();
			if(firstStackValue != secondStackValue)
			{
				return false;
			}
		}
		return true;
	}
}
