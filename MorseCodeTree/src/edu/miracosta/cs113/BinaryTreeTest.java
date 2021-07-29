package edu.miracosta.cs113;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;
class BinaryTreeTest
{
	@Test
	void testFileIn()
	{
		String fileName = "BinaryTree";
		try
		{
			Scanner reader = new Scanner(new File("C:\\Users\\arema\\git\\hashemi\\Hw_7\\src\\edu\\miracosta\\cs113\\BinaryTree.txt"));
			BinaryTree<String> myTree;
			myTree = BinaryTree.readBinaryTree(reader);
			System.out.println(myTree);
			reader.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Unable to open file");
		}
	}
}
