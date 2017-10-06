package edu.miracosta.cs113;
import java.util.Random;
public class Job
{
	private int pages;
	private String title;
	private int id;
	public Job()
	{
		setAll(0,"",0);
	}
	public Job(int pages, String title, int id)
	{
		setAll(pages, title, id);
	}
	public Job(int pages, String title)
	{
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		setAll(pages, title, randomInt);
	}
	public Job(Job jobInput)
	{
		setAll(jobInput.getPages(), jobInput.getTitle(), jobInput.getId());
	}
	public boolean setPages(int pages)
	{
		if(pages > 0)
		{
			this.pages = pages;
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
	public int getPages()
	{
		return pages;
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
		return title + " " + pages + " pages, ID : " + id;
	}
}
