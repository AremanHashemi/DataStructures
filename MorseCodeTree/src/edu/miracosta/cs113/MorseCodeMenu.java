/**MorseCodeMenu : use of morseCodeTree
 * OPEN MORSECODEKEY FILE
 * CREATE morseCodeTree from keyFile
 * CLOSE MORSECODEKEY
 * DO
	 * GET INPUT from USER
	 * IF INPUT = 1
	 * 	PRINT morseCode table
	 * IF INPUT = 2
	 * 	GET fileName from USER
	 * IF input = 3
	 * 	GET code from USER
	 * 	translate code
	 * 	print translation 
 * WHILE 1<= INPUT <= 3
 * @author Areman Hashemi<AremanHashemi@hotmail.com>
 * @version 1.0
 */
package edu.miracosta.cs113;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCodeMenu
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		int input;
		try
		{
			Scanner reader = new Scanner(new File("C:\\Users\\arema\\git\\hashemi\\Hw_7\\src\\edu\\miracosta\\cs113\\MorseCode"));
			MorseCodeTree morseTree;
			morseTree = MorseCodeTree.readMorseTree(reader);
			reader.close();
			do
			{
				System.out.println("Please enter 1 to test morseCodeTree\n"
						+ "2 to enter a file name to be translated\n"
						+ "3 to enter a line of morse code to be translated");
				input = keyboard.nextInt();
				if(input ==1)
				{
					morseTree.getTable();
				}
				else if(input == 2)
				{
					System.out.print("Please enter file name to decode :");
					String fileName = keyboard.nextLine();
					try
					{
						Scanner codedReader = new Scanner(new File(fileName));
						StringBuilder fileReader = new StringBuilder();
						while(codedReader.hasNext())
						{
							fileReader.append(codedReader.next() + " ");
						}
						
						String decodedMessage = morseTree.decode(fileReader.toString());
						System.out.println(decodedMessage);
						reader.close();
					}
					catch(FileNotFoundException e)
					{
						System.out.println("Unable to open file : " + fileName);
					}
				}
				else if(input == 3)
				{
					System.out.print("Please enter code to be decoded");
					keyboard.nextLine();
					String code = keyboard.nextLine();
					String decodedMessage = morseTree.decode(code);
					System.out.println(code +" = " + decodedMessage);
				}
			}while(input>=1 && input<=3);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Unable to open morseCode key");
		}
	}

}
