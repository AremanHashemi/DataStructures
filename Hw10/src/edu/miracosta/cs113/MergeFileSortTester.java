package edu.miracosta.cs113;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import org.junit.Test;
/**
 * HW 10 : sorts Files using variation of mergeSort
 * tests 3 inputs with starting split of 2
 * tests 100 inputs with starting split of 3
 * tests 7002 inputs with starting split of 100
 *  *Files should be saved to working directory
 * @author Areman Hashemi<AremanHashemi@hotmail.com>
 * @version 2.0
 *
 */
public class MergeFileSortTester 
{
	@Test
	public void test3() throws IOException
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter("./test 3.txt"));
		Random rand = new Random();
		for(int i = 0; i < 3; i++)
		{
			int n = rand.nextInt(100) + 1;
			writer.write(String.valueOf(n)+ " ");
		}
		writer.close();
		File testFile = new File("./test 3.txt");
		MergeFileSort testMerge = new MergeFileSort(testFile, 2);
		testMerge.sortFile();
	}
	@Test
	public void test100() throws IOException
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter("./test 100.txt"));
		Random rand = new Random();
		for(int i = 0; i < 100; i++)
		{
			int n = rand.nextInt(100) + 1;
			writer.write(String.valueOf(n)+ " ");
		}
		writer.close();
		File testFile = new File("./test 100.txt");
		MergeFileSort testMerge = new MergeFileSort(testFile, 3);
		testMerge.sortFile();
	}
	@Test
	public void test7002() throws IOException
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter("./test 7002.txt"));
		Random rand = new Random();
		for(int i = 0; i < 7000; i++)
		{
			int n = rand.nextInt(100) + 1;
			writer.write(String.valueOf(n)+ " ");
		}
		writer.close();
		File testFile = new File("./test 7002.txt");
		MergeFileSort testMerge = new MergeFileSort(testFile, 10);
		testMerge.sortFile();
	}
}
