package edu.miracosta.cs113;
import java.util.Random;
public class PrinterDriver
{
	public static void main(String[] args)
	{
		testPrinterController(5,100);
	}
	private static int testPrinterController(int numberOfPrinters, int numberOfPrintJobs)
	{
		PrinterController officeStation = new PrinterController(numberOfPrinters);
		Random rand = new Random();
		int i = 0;
		while(i < numberOfPrintJobs || !officeStation.isJobsEmpty())
		{
			System.out.print("\n" + i+" Minutes: \n");
			if( i < numberOfPrintJobs)
			{
				int n = rand.nextInt(50) + 1;
				Job randJob = new Job(n,"My Essay #" + (i+1) + ", ");
				officeStation.add(randJob);
			}
			else
			{
				System.out.println();
			}
			officeStation.process();
			i++;
		}
		System.out.println("Finished Printing: " + numberOfPrinters + " printers, printed "+ numberOfPrintJobs + " pages in " + i + " minutes" );
		return i;
	}

}
