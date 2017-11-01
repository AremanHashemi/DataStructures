package edu.miracosta.cs113;

import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

import org.junit.jupiter.api.Test;
import java.util.*;
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
