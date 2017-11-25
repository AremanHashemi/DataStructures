package edu.miracosta.cs113;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

import org.junit.Test;

public class MergeFileSortTester 
{

	@Test
	public void testReadRecords() throws FileNotFoundException
	{
//		MergeFileSort testFile = new MergeFileSort(null,9);
//		Scanner input = new Scanner(new File("C:\\Users\\arema\\git\\hashemi\\Hw10\\src\\edu\\miracosta\\cs113\\readTestFile"));
//		assertArrayEquals(new ArrayListint[] {1,2,3,4,5,6,7,8,9},testFile.readRecords(input, 9));
	}
	@Test
	public void testArrayMerge()
	{
//		ArrayList<Integer> a = new ArrayList();
//		ArrayList<Integer> b = new ArrayList();
//		a.add(0);
//		a.add(2);
//		b.add(1);
//		b.add(4);
//		
//		MergeFileSort testFile = new MergeFileSort(null,9);
//		ArrayList<Integer> c = testFile.mergeArrays(a, b);
//		System.out.print(c);
		
	}
	@Test
	public void testSplit() throws IOException
	{
		MergeFileSort testFile = new MergeFileSort(2);
		Scanner input = new Scanner(new File("C:\\Users\\arema\\git\\hashemi\\Hw10\\src\\edu\\miracosta\\cs113\\readTestFile"));
		testFile.sortFile();
		testFile.split(input, false);
		testFile.merge(2);
	}
	@Test
	public void testMerge()
	{
		
	}
}
