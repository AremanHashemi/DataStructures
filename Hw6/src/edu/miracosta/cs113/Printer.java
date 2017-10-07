package edu.miracosta.cs113;
import java.util.Queue;
public class Printer
{
	private final int PAGES_PER_MINUTE =10;
	private String id;
	private int pagesPrinted;
	private Queue<Job> jobs; 
	
	/**
	 * Default contructor
	 * 
	 */
	public Printer()
	{
		id = "Default Printer";
		pagesPrinted = 0;
		jobs = new ArrayQueue<Job>();
	}
	/**
	 * Contructor with only the name of the printer
	 * @param id
	 */
	public Printer(String id)
	{
		pagesPrinted = 0;
		this.id = id;
		jobs = new ArrayQueue<Job>();
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getId()
	{
		return id;
	}
	public boolean addJob(int pages,String title)
	{
		if(pages > 0)
		{
			jobs.offer(new Job(pages,title));
			return true;
		}
		else
		{
			return false;
		}
	}
	public void addJob(Job printRequest)
	{
		System.out.println("Job Received : " + printRequest);
		jobs.offer(new Job(printRequest));
	}
	public Job print()
	{
		if(jobs.peek()!= null)
		{
			pagesPrinted += PAGES_PER_MINUTE;
			if(pagesPrinted < jobs.element().getNumPages())
			{
				return null;
			}
			else
			{
				pagesPrinted = 0;
				return jobs.remove();
			}
			r
		}
	}
	public boolean isEmpty()
	{
		return jobs.isEmpty();
	}
	public String toString()
	{
		StringBuilder printerString = new StringBuilder();
		printerString.append("Printer : " + id + "\n");
		if(jobs.peek()!=null)
		{
			int printSize = jobs.peek().getNumPages();
			String percentDone = String.valueOf((Math.round((double)pagesPrinted/printSize*100)));
			printerString.append(jobs.poll()+ ", Current status = " + percentDone + "%\n");
		}
		while(jobs.peek()!=null)
		{
			printerString.append(jobs.poll().toString() + "\n");
		}
		return printerString.toString();
	}
	
}
