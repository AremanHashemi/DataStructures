package edu.miracosta.cs113;
/**
 * Detective Jill :
 * - Gets input from user to test different murder sets
 * - Jill guesses starting from first options
 * - Checks guesses using Assistant Jack
 * - Hints given by Assistant Jack increment the guess
 * - Repeat until Assistant Jack says guess is correct
 * - Print correct murder set & number of guesses to get there
 * @author Areman (material from Kevin Lewis & Nery Chapeton-Lamas)
 * @version 1.0
 *
 */
import java.util.Scanner;
public class DetectiveJill 
{
	public static void main(String[] args)
	{
		final int MURDER_MAX_VALUE = 6;
		final int WEAPON_MAX_VALUE = 6;
		final int LOCATION_MAX_VALUE = 10;
		int answerSet, solution, murderGuess, weaponGuess, locationGuess;
		Scanner keyboard = new Scanner(System.in);
		Theory answer = null;
		AssistantJack jack;

		System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
		answerSet = keyboard.nextInt();
		//keyboard.close();

		jack = new AssistantJack(answerSet);

		murderGuess = 1;
		locationGuess = 1;
		weaponGuess = 1;
		do {
			solution = jack.checkAnswer(weaponGuess, locationGuess, murderGuess);
			if(solution == 1)
            {
                weaponGuess ++;
            }
            else if(solution == 2)
            {
                locationGuess++;
            }
            else if(solution == 3)
            {
                murderGuess++;
            }
			if(murderGuess > MURDER_MAX_VALUE || weaponGuess > WEAPON_MAX_VALUE || locationGuess > LOCATION_MAX_VALUE)
			{
				System.out.println("Error, a guess has gone out of scope");
				System.exit(0);
			}
		} while (solution != 0);
		answer = new Theory(weaponGuess, locationGuess, murderGuess);
		System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution = " + answer);

		if (jack.getTimesAsked() > 20) {
			System.out.println("FAILED!! You're a horrible Detective...");
		} else {
			System.out.println("WOW! You might as well be called Batman!");
		}

	}
	
	
}
