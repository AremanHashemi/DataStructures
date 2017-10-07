package edu.miracosta.cs113;
import java.util.Random;
public class Job
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
