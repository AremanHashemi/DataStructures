package edu.miracosta.cs113;

import static org.junit.Assert.*;

import org.junit.Test;

public class AVLTreeTest {

	@Test
	public void testLeftLeft()
	{
		System.out.println("Testing left left imbalances");
		AVLTree<Integer> testTree = new AVLTree();
		testTree.add(5);
		testTree.add(4);
		testTree.add(3);
//		testTree.add(2);
//		testTree.add(1);
		System.out.println(testTree);
	}
	@Test
	public void testRightRight()
	{
		System.out.println("Testing right right imbalances");
		AVLTree<Integer> testTree = new AVLTree();
		testTree.add(5);
		testTree.add(6);
		testTree.add(7);
		System.out.println(testTree);
	}
	@Test
	public void testBalanced()
	{
		System.out.println("Testing levelIncreased");
		AVLTree<Integer> testTree = new AVLTree();
		testTree.add(6);
		testTree.add(7);
		testTree.add(4);
		testTree.add(2);
		System.out.println(testTree);
	}
	@Test
	public void testLeftRight()
	{
		System.out.println("Testing Left Right");
		AVLTree<Integer> testTree = new AVLTree();
		testTree.add(5);
		testTree.add(3);
		testTree.add(4);
		System.out.println(testTree);
	}
	@Test
	public void testRightLeft()
	{
		System.out.println("Testing Right Left");
		AVLTree<Integer> testTree = new AVLTree();
		testTree.add(5);
		testTree.add(7);
		testTree.add(6);
		System.out.println(testTree);
	}
	
	@Test
	public void testLargeTree()
	{
		System.out.println("Testing Larger Tree");
		AVLTree<Integer> testTree = new AVLTree();
		testTree.add(5);
		testTree.add(100);
		testTree.add(50);
		testTree.add(200);
		testTree.add(40);
		testTree.add(11);
		testTree.add(9);
		System.out.println(testTree);
	}
	
}
