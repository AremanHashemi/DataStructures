package edu.miracosta.cs113;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrinterTester
{
	@Test
	public void testEmpty()
	{
		Printer myPrinter = new Printer();
		assertEquals(null, myPrinter.print());
	}
	@Test
	public void AddTest()
	{
		Printer myPrinter = new Printer();
		assertEquals(true,myPrinter.addJob(4,"My documentation"));
	}
	@Test
	public void testUnfinishedPrint()
	{
		Printer myPrinter = new Printer();
		myPrinter.addJob(11,"My documentation");
		assertEquals(null, myPrinter.print());
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
