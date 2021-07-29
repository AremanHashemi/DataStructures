package edu.miracosta.cs113;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;
class MorseCodeTester
{

	@Test
	void testBuild()
	{
		try
		{
			Scanner reader = new Scanner(new File("C:\\Users\\arema\\git\\hashemi\\Hw_7\\src\\edu\\miracosta\\cs113\\MorseCode"));
			MorseCodeTree morseTree;
			morseTree = MorseCodeTree.readMorseTree(reader);
			System.out.println(morseTree);
			reader.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Unable to open file");
		}
	}
	@Test
	void testDecode()
	{
		try
		{
			Scanner reader = new Scanner(new File("C:\\Users\\arema\\git\\hashemi\\Hw_7\\src\\edu\\miracosta\\cs113\\MorseCode"));
			MorseCodeTree morseTree;
			morseTree = MorseCodeTree.readMorseTree(reader);
			String decodedMessage = morseTree.decode("**-* **- -*");
			System.out.println(decodedMessage);
			reader.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Unable to open file");
		}
	}
	@Test
	void printTable()
	{
		try
		{
			Scanner reader = new Scanner(new File("C:\\Users\\arema\\git\\hashemi\\Hw_7\\src\\edu\\miracosta\\cs113\\MorseCode"));
			MorseCodeTree morseTree;
			morseTree = MorseCodeTree.readMorseTree(reader);
			morseTree.getTable();
			reader.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Unable to open file");
		}
	}

}
