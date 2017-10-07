package edu.miracosta.cs113;
import java.util.Queue;
import java.util.Random;
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
		}
		return null; 
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
	public static class Job
	{
		private int numPagesTotal, numPagesPrinted;
		private String title;
		private int id;
		/**
		 * Default constructor 
		 * sets pages, id = 0, title to empty string
		 */
		public Job()
		{
			setAll(0,"",0);
		}
		/**
		 * Full constructor
		 * @param pages
		 * @param title
		 * @param id
		 */
		public Job(int pages, String title, int id)
		{
			setAll(pages, title, id);
		}
		/**
		 * Partial constructor
		 * @param pages
		 * @param title
		 */
		public Job(int pages, String title)
		{
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(1000);
			setAll(pages, title, randomInt);
		}
		public Job(Job jobInput)
		{
			setAll(jobInput.getNumPages(), jobInput.getTitle(), jobInput.getId());
		}
		public boolean setPages(int pages)
		{
			if(pages > 0)
			{
				this.numPagesTotal = pages;
				return true;
			}
			else
			{
				return false;
			}
		}
		public void setTitle(String title)
		{
			this.title = title;
		}
		public void setId(int id)
		{
			this.id = id;
		}
		public void setAll(int pages, String title, int id)
		{
			setPages(pages);
			setTitle(title);
			setId(id);
		}
		public int getNumPages()
		{
			return numPagesTotal;
		}
		public String getTitle()
		{
			return title;
		}
		public int getId()
		{
			return id;
		}
		public String toString()
		{
			return title + " " + numPagesTotal + " pages, ID : " + id;
		}
	}

}
