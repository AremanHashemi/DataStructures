package edu.miracosta.cs113;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class HashtableChainTester
{
	@Test
	public void testPut()
	{
		HashtableChain testTable = generateTable();
		assertEquals(100,testTable.put(1, 10));
		System.out.println("Testing put");
		testTable.printTable();
	}
	@Test
	public void testIsEmptyTrue()
	{
		HashtableChain testTable = new HashtableChain();
		assertEquals(true, testTable.isEmpty());
	}
	@Test
	public void testIsEmptyFalse()
	{
		HashtableChain testTable = generateTable();
		assertEquals(false, testTable.isEmpty());
	}
	@Test
	public void testGet()
	{
		HashtableChain testTable = generateTable();
		assertEquals(100,testTable.get(1));
	}
	@Test
	public void testRemove()
	{
		HashtableChain testTable = generateTable();
		assertEquals(testTable.remove(1),100);
		System.out.println("\nAfter Removing 100");
		testTable.printTable();
	}
	public void testRemoveAll()
	{
		HashtableChain testTable = generateTable();
		testTable.remove(1);
		testTable.remove(2);
		testTable.remove(3);
		testTable.remove(4);
		assertEquals(testTable.isEmpty(), true);
	}
	public void testRemoveNotInList()
	{
		HashtableChain testTable = generateTable();
		assertEquals(testTable.remove(5), null);
	}
	private HashtableChain generateTable()
	{
		HashtableChain testTable = new HashtableChain();
		testTable.put(1,100);
		testTable.put(2, 200);
		testTable.put(3, 300);
		testTable.put(4, 400);
		return testTable;
	}
}
