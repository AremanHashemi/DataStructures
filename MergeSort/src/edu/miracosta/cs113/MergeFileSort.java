/**
 * HW 10 : sorts Files using variation of mergeSort
 * sortFile()
 * 	CALCULATE FILESIZE()
 * 	DO
 * 		SPLIT(INPUT FILE, BOOL firstRun) // Splits File into runs, writes files to one of two temp files
 * 		MERGE(sizeOfSplits) // merges two temp files back to mainfile
 * 		*2 sizeOfRun
 * 	WHILE ( sizeOfRun < fileSize)
 * @author Areman Hashemi<AremanHashemi@hotmail.com>
 * @version 2.0
 */
package edu.miracosta.cs113;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MergeFileSort
{	
	private File inputFile;
	private File outputFile1;
	private File outputFile2;
	private int sizeOfRun;
	public MergeFileSort(File inputFile, int sizeOfRun)
	{
		this.inputFile = inputFile;
		outputFile1 = new File("./outputFile1.txt");
		outputFile2 = new File("./outputFile2.txt");
		this.sizeOfRun = sizeOfRun;
	}
	/**
	 * sorts inputFile
	 * @throws IOException
	 */
	public void sortFile() throws IOException
	{
		
		boolean firstRun = true;
		int fileSize = calculateFileSize(inputFile);
		do
		{
			split(inputFile,firstRun);
			merge(sizeOfRun);
			sizeOfRun *= 2;
		}while(sizeOfRun < fileSize);
	}
	/**
	 * returns number of integers in file
	 * @param fileInput
	 * @return
	 * @throws FileNotFoundException
	 */
	private int calculateFileSize(File fileInput) throws FileNotFoundException
	{
		int size = 0;
		Scanner input = new Scanner(fileInput);
		while(input.hasNextInt())
		{
			input.nextInt();
			size++;
		}
		input.close();
		return size;
	}
	/**
	 * Splits fileInput into two temporary files half of the fineInputData
	 * If it is the first run sorts these inputs
	 * @param fileInput
	 * @param firstRun
	 * @throws IOException
	 */
	private void split(File fileInput, boolean firstRun) throws IOException
	{
		Scanner input = new Scanner(inputFile);
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
		input.close();
	}
	/**
	 * Merges two temp files back into inputFile 
	 * @param runSize
	 * @throws IOException
	 */
	private void merge(int runSize) throws IOException
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
			System.out.println(c);
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
	/**
	 * ASSUMES INPUT ARRAYS ARE SORTED SMALLEST-> LARGEST
	 * returns an merged arraylist 
	 * @param a
	 * @param b
	 * @return
	 */
	private ArrayList<Integer> mergeArrays(ArrayList<Integer> a, ArrayList<Integer> b)
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
	/**
	 * Reads in numRead number of integers from input 
	 * returned in arraylist
	 * @param input
	 * @param numRead
	 * @return
	 */
	private ArrayList<Integer> readRecords(Scanner input,int numRead)
	{
		ArrayList<Integer> dataRead = new ArrayList(numRead);
		while(input.hasNextInt() && dataRead.size() < numRead)
		{
			dataRead.add(input.nextInt());
		}
		return dataRead;
	}
}
