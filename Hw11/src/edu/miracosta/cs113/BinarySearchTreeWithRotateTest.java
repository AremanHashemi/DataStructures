package edu.miracosta.cs113;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeWithRotateTest {

	@Test
	public void testRotateLeft()
	{
		System.out.println("Testing rotate left");
		BinarySearchTreeWithRotate<Integer> testTree = new BinarySearchTreeWithRotate();
		testTree.add(10);
		testTree.add(11);
		testTree.add(12);
		System.out.println(testTree);
		System.out.println("rotating");
		testTree.root = testTree.rotateLeft(testTree.root);
		System.out.println(testTree);
	}
	@Test
	public void testRotateright()
	{
		System.out.println("Testing rotate right");
		BinarySearchTreeWithRotate<Integer> testTree = new BinarySearchTreeWithRotate();
		testTree.add(12);
		testTree.add(11);
		testTree.add(10);
		System.out.println(testTree);
		System.out.println("rotating");
		testTree.root = testTree.rotateRight(testTree.root);
		System.out.println(testTree);
	}

}
