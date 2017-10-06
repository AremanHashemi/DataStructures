package edu.miracosta.cs113;

public class PrinterDriver
{
	public static void main(String[] args)
	{
		PrinterController officeStation = new PrinterController();
		officeStation.addPrinter("Printer One");
		officeStation.addPrinter("Printer Two");
		officeStation.addPrinter("Printer Three");
		officeStation.printRequest(new Job(15, "myEssay"));
		officeStation.printRequest(new Job(3, "myEssay"));
		officeStation.printRequest(new Job(19, "myEssay"));
		officeStation.printRequest(new Job(23, "myEssay"));
		officeStation.print();
		officeStation.print();
		System.out.println(officeStation);
	}

}
