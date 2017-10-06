package edu.miracosta.cs113;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrinterControllerTest
{
//	@Test
	public void emptyToString()
	{
		PrinterController officeStation = new PrinterController();
		officeStation.addPrinter("Printer One");
		System.out.println(officeStation);
	}
//	@Test
	public void addJobs()
	{
		PrinterController officeStation = new PrinterController();
		officeStation.addPrinter("Printer One");
		officeStation.addPrinter("Printer Two");
		officeStation.printRequest(new Job(15, "myEssay"));
		officeStation.printRequest(new Job(3, "myEssay"));
		officeStation.printRequest(new Job(400, "myEssay"));
		System.out.println(officeStation);
	}
//	@Test
	public void addJobsNewPrinter()
	{
		PrinterController officeStation = new PrinterController();
		officeStation.addPrinter("Printer One");
		officeStation.addPrinter("Printer Two");
		officeStation.printRequest(new Job(15, "myEssay"));
		officeStation.printRequest(new Job(3, "myEssay"));
		officeStation.printRequest(new Job(400, "myEssay"));
		officeStation.addPrinter("Printer Three");
		officeStation.printRequest(new Job(400, "myEssay"));
		System.out.println(officeStation);
	}
	@Test
	public void printTest()
	{
		PrinterController officeStation = new PrinterController();
		officeStation.addPrinter("Printer One");
		officeStation.addPrinter("Printer Two");
		officeStation.addPrinter("Printer Three");
		officeStation.printRequest(new Job(15, "myEssay"));
		officeStation.printRequest(new Job(3, "myEssay"));
		officeStation.printRequest(new Job(29, "myEssay"));
		officeStation.printRequest(new Job(400, "myEssay"));
		officeStation.print();
		System.out.println(officeStation);
	}

}
