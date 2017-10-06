package edu.miracosta.cs113;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrinterTester
{
	@Test
	public void testEmpty()
	{
		Printer myPrinter = new Printer();
	}
	@Test
	public void AddTest()
	{
		Printer myPrinter = new Printer();
		assertEquals(true,myPrinter.addJob(4,"My documentation"));
	}
	@Test
	public void testPrint()
	{
		Printer myPrinter = new Printer();
		myPrinter.addJob(10,"My documentation");
		//System.out.println(myPrinter);
		assertEquals(true, myPrinter.print());
		
	}
	@Test
	public void testUnfinishedPrint()
	{
		Printer myPrinter = new Printer();
		myPrinter.addJob(11,"My documentation");
		assertEquals(false, myPrinter.print());
	}
	@Test
	public void testToString()
	{
		Printer myPrinter = new Printer();
		myPrinter.addJob(25,"My documentation");
		myPrinter.addJob(30,"My documentation");
		myPrinter.addJob(40,"My documentation");
		myPrinter.print();
		System.out.println(myPrinter);
	}

}
