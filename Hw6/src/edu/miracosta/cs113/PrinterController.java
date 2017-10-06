package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PrinterController
{
	private List<Printer> printers;
	public PrinterController()
	{
		printers = new ArrayList<Printer>();
	}
	public void addPrinter(String id)
	{
		printers.add(new Printer(id));
	}
	public void removePrinter()
	{
		printers.remove(printers.size());
	}
	public void printRequest(Job request)
	{
		ListIterator<Printer> printerIterator = printers.listIterator();
		while(printerIterator.hasNext() && printerIterator.nextIndex() * 10 < request.getPages())
		{
			printerIterator.next();
		}
		printerIterator.previous().addJob(request);
	}
	public void print()
	{
		ListIterator<Printer> printerIterator = printers.listIterator();
		while(printerIterator.hasNext())
		{
			printerIterator.next().print();
		}
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
