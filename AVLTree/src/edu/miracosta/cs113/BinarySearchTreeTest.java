package edu.miracosta.cs113;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.miracosta.cs113.BinaryTree.Node;

public class BinarySearchTreeTest 
{

	@Test
	public void testAdd() 
	{
		System.out.println("Test for adding");
		BinarySearchTree<Integer> testTree = new BinarySearchTree<>();
		testTree.add(10);
		testTree.add(4);
		testTree.add(11);
		testTree.add(1);
		testTree.add(2);
		testTree.add(5);
		testTree.add(12);
		System.out.println("\n" + testTree);
	}
	@Test
	public void testRemoveLeaf() 
	{
		System.out.println("Test for removing leaf");
		BinarySearchTree<Integer> testTree = new BinarySearchTree<>();
		testTree.add(10);
		testTree.add(9);
		testTree.add(11);
		System.out.println(testTree);
		System.out.println("Removing 9");
		testTree.remove(9);
		System.out.println("\n\n" + testTree);
	}
	@Test
	public void testRemoveOneChild() 
	{
		System.out.println("Test for removing node with one child");
		BinarySearchTree<Integer> testTree = new BinarySearchTree<>();
		testTree.add(10);
		testTree.add(9);
		testTree.add(11);
		testTree.add(12);
		testTree.add(13);
		System.out.println(testTree);
		System.out.println("Removing 11");
		testTree.remove(11);
		System.out.println("\n\n" + testTree);
	}
	@Test
	public void testRemoveTwoChildrenCase() 
	{
		System.out.println("Test for removing node with two child case 1");
		BinarySearchTree<Integer> testTree = new BinarySearchTree<>();
		testTree.add(10);
		testTree.add(6);
		testTree.add(4);
		testTree.add(7);
		testTree.add(11);
		testTree.add(12);
		testTree.add(13);
		System.out.println(testTree);
		System.out.println("Removing 10");
		testTree.remove(10);
		System.out.println("\n\n" + testTree);
	}

}
