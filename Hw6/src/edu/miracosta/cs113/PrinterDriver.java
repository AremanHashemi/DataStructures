/**
 * Hw6 PrinterDriver - testing how effeciently 1 2 and 3 printers can print 100 jobs of 1-50 pages randomly
 * testPrinterController(1,100);
 * testPrinterController(2,100);
 * testPrinterController(3,100);
 * @author Areman Hashemi<AremanHashemi@hotmail.com>
 * @version 2.0
 */
package edu.miracosta.cs113;
import java.util.Random;
import edu.miracosta.cs113.Printer.Job;
public class PrinterDriver
{
	public static void main(String[] args)
	{
		System.out.println("Testing 1 printer");
		testPrinterController(1,100);
		System.out.println("Testing 2 printers");
		testPrinterController(2,100);
		System.out.println("Testing 3 printers");
		testPrinterController(3,100);
		
	}
	/**
	 * Creates a printerController with the number of printers
	 * While not done with all the jobs, and not done with all the inputs
	 * 	create a new job and send it to printerController to be assigned to a printer
	 * 	processes one tick of printing
	 * @param numberOfPrinters
	 * @param numberOfPrintJobs
	 * @return
	 */
	private static int testPrinterController(int numberOfPrinters, int numberOfPrintJobs)
	{
		PrinterController officeStation = new PrinterController(numberOfPrinters);
		Random rand = new Random();
		int i = 0;
		while(i < numberOfPrintJobs || !officeStation.isJobsEmpty())
		{
			
			System.out.print("\n" + (i+1)+" Minute: \n");
			if( i < numberOfPrintJobs)
			{
				int n = rand.nextInt(50) + 1;
				Job randJob = new Job(n,"My Essay #" + (i+1) + ", ");
				officeStation.add(randJob);
			}
			officeStation.process();
			i++;
		}
		System.out.println("Finished Printing: " + numberOfPrinters + " printers, printed "+ numberOfPrintJobs + " pages in " + i + " minutes" );
		return i;
	}
}
