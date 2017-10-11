package edu.miracosta.cs113;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import edu.miracosta.cs113.Printer.Job;

public class PrinterController
{
	private List<Printer> printers;
	/**
	 * default constructor
	 */
	public PrinterController()
	{
		printers = new ArrayList<Printer>();
	}
	/**
	 * creates a controller with a specified number of printers
	 * @param numberOfPrinters
	 */
	public PrinterController(int numberOfPrinters)
	{
		printers = new ArrayList<Printer>();
		for(int i = 0; i < numberOfPrinters;i++)
		{
			addPrinter("" + (i+1));
		}
	}
	/**
	 * adds a printer to the printerController with specified id
	 * @param id
	 */
	public void addPrinter(String id)
	{
		printers.add(new Printer(id));
	}
	/**
	 * removes the last printer
	 */
	public void removePrinter()
	{
		printers.remove(printers.size());
	}
	/**
	 * adds a job to the printer
	 * @param job
	 */
	public void add(Job job)
	{
		findPrinterForJobSize(job.getNumPages()).addJob(job);
	}
	/**
	 * decides which printer job input gets sent to
	 * @param numPages
	 * @return
	 */
	private Printer findPrinterForJobSize(int numPages)
	{
		ListIterator<Printer> printerIterator = printers.listIterator();
		while(printerIterator.hasNext() && printerIterator.nextIndex() * 10 < numPages)
		{
			printerIterator.next();
		}
		return printerIterator.previous();
	}
	/**
	 * does one tick of printing for each printer
	 */
	public void process()
	{
		ListIterator<Printer> printerIterator = printers.listIterator();
		while(printerIterator.hasNext())
		{
			
			Printer printer = printerIterator.next();
			Job finishedJob = printer.print();
			printSuccess(finishedJob,printer.getId());
		}
	}
	/**
	 * used to print finished jobs
	 * @param job
	 * @param printerId
	 */
	private void  printSuccess(Job job, String printerId)
	{
		if(job != null)
		{
			System.out.println("Printer " + printerId + " has printed :" + job);
		}
	}
	public boolean isJobsEmpty()
	{
		boolean isEmpty = true;
		ListIterator<Printer> printerIterator = printers.listIterator();
		while(printerIterator.hasNext())
		{
			isEmpty = printerIterator.next().isEmpty();
		}
		return isEmpty;
	}
	public String toString()
	{
		StringBuilder printerControllerString = new StringBuilder();
		ListIterator<Printer> printerIterator = printers.listIterator();
		while(printerIterator.hasNext())
		{
			printerControllerString.append(printerIterator.next().toString()); 
		}
		return printerControllerString.toString();
	}
}
