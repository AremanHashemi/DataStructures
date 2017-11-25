/**
 * -WHILE record file isn't empty
 * -OPEN data file
 * -READ 10 data records
 * -SORT 10 data records
 * -WRITE 10 data records to one of two alternate files
 * 
 * -MERGE two alternate files to the original data file
 */
package edu.miracosta.cs113;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MergeFileSort
{	
	private File inputFile;
	private File outputFile1;
	private File outputFile2;
	private int sizeOfRun;
	
	public MergeFileSort(int sizeOfRun)
	{
		inputFile = new File("./inputFile1.txt");
		outputFile1 = new File("./outputFile1.txt");
		outputFile2 = new File("./outputFile2.txt");
		this.sizeOfRun = sizeOfRun;
	}
	public void sortFile() throws IOException
	{
		Scanner input = new Scanner(inputFile);
		boolean firstRun = true;
		int fileSize = 20;
		do
		{
			split(input,firstRun);
			merge(sizeOfRun);
			sizeOfRun *= 2;
			firstRun = false;
		}while(sizeOfRun < fileSize);
	}
	public void split(Scanner input, boolean firstRun) throws IOException
	{
		BufferedWriter writer1 = new BufferedWriter(new FileWriter(outputFile1));
		BufferedWriter writer2 = new BufferedWriter(new FileWriter(outputFile2));
		boolean swapWriter = false;
		ArrayList<Integer> run;
		while(input.hasNextInt())
		{
			run = readRecords(input, sizeOfRun);
			if(firstRun)
			{
				Collections.sort(run);
				System.out.print(run);
			}
			while(!run.isEmpty())
			{
				if(swapWriter)
				{
					writer1.write(String.valueOf(run.remove(0))+ " ");
				}
				else
				{
					writer2.write(String.valueOf(run.remove(0))+ " ");
				}
			}
			swapWriter^= true;
		}
		writer1.close();
		writer2.close();
	}
	public void merge(int runSize) throws IOException
	{
		Scanner temp1 = new Scanner(outputFile1);
		Scanner temp2 = new Scanner(outputFile2);
		BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
		ArrayList<Integer> a = new ArrayList();
		ArrayList<Integer> b = new ArrayList();
		ArrayList<Integer> c = new ArrayList();
		
		while(temp1.hasNextInt() && temp2.hasNextInt())
		{
			
			a = readRecords(temp1, runSize);
			b = readRecords(temp2, runSize);
			c = mergeArrays(a,b);
			while(!c.isEmpty())
			{
				writer.write(String.valueOf(c.remove(0))+ " ");
			}
		}
		if(temp1.hasNextInt())
		{
			while(temp1.hasNextInt())
			{
				writer.write(String.valueOf(temp1.nextInt())+ " ");
			}
		}
		else if(temp2.hasNextInt())
		{
			while(temp2.hasNextInt())
			{
				writer.write(String.valueOf(temp2.nextInt())+ " ");
			}
		}
		writer.close();
	}
	//assume sorted
	public ArrayList<Integer> mergeArrays(ArrayList<Integer> a, ArrayList<Integer> b)
	{
		ArrayList<Integer> c = new ArrayList();
		while(!a.isEmpty() && !b.isEmpty())
		{
			int aValue = a.get(0);
			int bValue = b.get(0);
			
			if(aValue > bValue)
			{
				c.add(b.remove(0));
			}
			else
			{
				c.add(a.remove(0));
			}
		}
		if(!a.isEmpty())
		{
			c.addAll(a);
		}
		else if(!b.isEmpty())
		{
			c.addAll(b);
		}
		return c;
	}
	
	public ArrayList<Integer> readRecords(Scanner input,int numRead)
	{
		ArrayList<Integer> dataRead = new ArrayList(numRead);
		while(input.hasNextInt() && dataRead.size() < numRead)
		{
			dataRead.add(input.nextInt());
		}
		return dataRead;
	}
}
