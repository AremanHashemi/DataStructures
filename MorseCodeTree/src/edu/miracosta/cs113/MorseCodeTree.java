package edu.miracosta.cs113;

import java.util.Arrays;
import java.util.Scanner;

public class MorseCodeTree extends BinaryTree<Character>
{
	/**
	 * INPUT MESSAGE MUST BE DELIMITED BY SPACES
	 * INPUT MUST BE ONLY WRITTEN IN * & - 
	 * @param message
	 * @return decoded Message
	 */
	public String decode(String message)
	{
		String[] codeStr = message.split("\\s+");
		char[] decodedStr = new char[codeStr.length];
		for(int i = 0; i < codeStr.length; i++)
		{
			decodedStr[i] = morseToAlpha(root, codeStr[i]);
		}
		return Arrays.toString(decodedStr);
	}
	/**
	 * Prints Morse Code Table
	 * Precondition : MorseCodeTree must be created from key
	 */
	public void getTable()
	{
		String message =
				"- " + 
				"** " + 
				"*- " + 
				"-* " + 
				"-- " + 
				"*** " + 
				"**- " + 
				"*-* " + 
				"*-- " + 
				"-** " + 
				"-*- " + 
				"--* " + 
				"--- " + 
				"**** " + 
				"***- " + 
				"**-* " + 
				"*-** " + 
				"*--* " + 
				"*--- " + 
				"-*** " + 
				"-**- " + 
				"-*-* " + 
				"-*-- " + 
				"--** " + 
				"--*- ";
		String[] codeStr = message.split("\\s+");
		char[] decodedStr = new char[codeStr.length];
		System.out.println("Letter = Morse\n"
				+ "--------------");
		for(int i = 0; i < codeStr.length; i++)
		{
			decodedStr[i] = morseToAlpha(root, codeStr[i]);
			System.out.println(decodedStr[i] +"      = "+codeStr[i] );
		}
	}
	/**
	 * Translates morse code string to char letter 
	 * Only used by printTable 
	 * @param root
	 * @param code
	 * @return decoded string
	 */
	private char morseToAlpha(Node<Character> root,String code)
	{
		if(code.equals(""))
		{
			return root.data;
		}
		else if(code.charAt(0)=='*')
		{
			return morseToAlpha(root.left,code.substring(1));
		}
		else if (code.charAt(0)=='-')
		{
			return morseToAlpha(root.right,code.substring(1));
		}
		else
		{
			System.out.println("ERROR: EMPTY CODE !!!");
			return('0');
		}
	}
	/**
	 * returns MorseCodeTree built from scanner input
	 * @param scan = key
	 * @return MorseCodeTree
	 */
	public static MorseCodeTree readMorseTree(Scanner scan)
	{
		MorseCodeTree tree = new MorseCodeTree();
		tree.root = new Node<Character>('-');
		while(scan.hasNext())
		{
			char letter = scan.next().charAt(0);
			String code = scan.next();
			createLevel(tree.root,letter,code);
		}
		return tree;
	}
	/**
	 * readMorseTree helper method
	 * uses recursion to traverse tree, if at last bit of code creates a new node in direction of last bit
	 * @param root
	 * @param letter
	 * @param code
	 */
	private static void createLevel(Node<Character> root, char letter, String code)
	{

		if(code.equals("*"))
		{
			root.left = new Node<Character>(letter);
		}
		else if(code.equals("-"))
		{
			root.right = new Node<Character>(letter);
		}
		else if(code.charAt(0)=='*')
		{
			createLevel(root.left,letter,code.substring(1));
			
		}
		else if (code.charAt(0)=='-')
		{
			createLevel(root.right,letter,code.substring(1));
		}
		else
		{
			System.out.println("ERROR: EMPTY CODE !!!");
		}
	}
}
