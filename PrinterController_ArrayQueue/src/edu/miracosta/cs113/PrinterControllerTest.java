package edu.miracosta.cs113;

import org.junit.Test;
import edu.miracosta.cs113.Printer.Job;

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
		officeStation.addPrinter("One");
		officeStation.addPrinter("Two");
		officeStation.add(new Job(15, "myEssay"));
		officeStation.add(new Job(3, "myEssay"));
		officeStation.add(new Job(400, "myEssay"));
		System.out.println(officeStation);
	}
//	@Test
	public void addJobsNewPrinter()
	{
		PrinterController officeStation = new PrinterController();
		officeStation.addPrinter("Printer One");
		officeStation.addPrinter("Printer Two");
		officeStation.add(new Job(15, "myEssay"));
		officeStation.add(new Job(3, "myEssay"));
		officeStation.add(new Job(400, "myEssay"));
		officeStation.addPrinter("Printer Three");
		officeStation.add(new Job(400, "myEssay"));
		System.out.println(officeStation);
	}
	@Test
	public void printTest()
	{
		PrinterController officeStation = new PrinterController();
		officeStation.addPrinter("Printer One");
		officeStation.addPrinter("Printer Two");
		officeStation.addPrinter("Printer Three");
		officeStation.add(new Job(15, "myEssay"));
		officeStation.add(new Job(3, "myEssay"));
		officeStation.add(new Job(29, "myEssay"));
		officeStation.add(new Job(400, "myEssay"));
		officeStation.process();
		System.out.println(officeStation);
	}

}
