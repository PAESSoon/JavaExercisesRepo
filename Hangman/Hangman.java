/*
This program will simulate the Hangman game where one player will try to guess the word input originally by the first player.
The program will check the validity of the first player's input before engaging with the guessing player
The guessing player can choose to guess a single letter or the entire word in one shot
The word to guess can have repeated letters and is not case sensitive
The program will check the validity of the guessing user input before proceeding
Once a valid letter is entered, the program updates the list of letters still left to try by removing
this letter from the list if all occurrences of the same letter are guessed, reduces the number of
guesses left by one, and checks whether the letter is part of the word to guess. If it is, then replace
the dash (or star) with the letter in the appropriate position.
Previous steps are repeated until guessing player finds all letters in the word or reaches 10 guesses.
A message is displayed at the end informing the user whether he won or not and the game ends.
*/

import java.util.Scanner;

public class Hangman {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// display welcome message
		System.out.println(
				"  ****************************\n       Welcome to Hangman     \n  ****************************\n");

		System.out.println("Ok Guessing Player ...turn around, while your friend enters the word to guess!\n");

		String wordInput = "";
		boolean isLetter = false;

		// verify if user input length is less or equal to 10 and all are letters
		while (wordInput.length() < 1 || wordInput.length() > 10 || isLetter == false) {
			System.out.print("Other Player - Enter your word (up to 10 letters only, not case sensitive): ");
			wordInput = input.nextLine();

			char[] wordInputChars = wordInput.toCharArray();

			for (int i = 0; i < wordInputChars.length; i++) {

				if (!Character.isLetter(wordInputChars[i])) {
					isLetter = false;
					break;
				}

				isLetter = true;
			}

		}

		// convert verified input to upper case
		String wordToGuess = wordInput.toUpperCase();
		// System.out.println(wordToGuess);

		// hide the word to guess
		String hiddenWord = "";
		int x = 0;
		while (x < wordToGuess.length()) {
			hiddenWord += "*";
			x++;
		}

		// add blank lines
		int n = 0;
		while (n < 25) {
			System.out.println("");
			n++;
		}

		// convert to char
		char[] wordInputChars = wordInput.toCharArray();
		char[] originalWordToGuessChars = wordToGuess.toCharArray();
		char[] wordToGuessChars = wordToGuess.toCharArray();
		char[] hiddenChars = hiddenWord.toCharArray();

		// create the array of alphabetic letters A-Z that user needs to guess from
		char[] lettersList = new char[26];
		char ch = 'A';
		for (int i = 0; i < lettersList.length; i++) {
			lettersList[i] = ch++;
		}

		int numberOfGuesses = 10;
		int remainingLettersToGuess = wordToGuess.length();
		String newHiddenChars = String.valueOf(hiddenChars);
		boolean isGuessedCompleteCorrect = false;

		// start loop for 10 rounds of guesses
		while (numberOfGuesses > 0 || remainingLettersToGuess < 1 || isGuessedCompleteCorrect) {
			// print number of guesses left
			System.out.println("\nWord to date: " + newHiddenChars + " (" + numberOfGuesses + " guess(es) left)");

			System.out.print(
					"Want to solve the puzzle? Enter \"Y\" to solve the puzzle, or \"N\" to guess a character: ");

			String selection = input.nextLine();
			String guessOption = "";
			char guessOptionFirst = '\u0000';

			if (selection.length() > 0) {
				guessOption = selection.toUpperCase();
				guessOptionFirst = guessOption.charAt(0);
			}

			// case where user wants to guess 1 letter
			if (guessOptionFirst == 'N') {

				System.out.print("Letters not tried yet: ");
				System.out.println(lettersList);

				String newLetter = "";
				String newInputLetter = "";
				boolean isCharLetter = false;
				boolean isCharSelectable = false;

				// check validity of user input
				while (newInputLetter.length() != 1 || !isCharLetter || !isCharSelectable) {

					System.out.print("Which letter should I check for? ");

					newInputLetter = input.nextLine();
					if (newInputLetter.length() > 0 && newInputLetter.length() < 2) {

						newLetter = newInputLetter.toUpperCase();

						if (!Character.isLetter(newLetter.charAt(0))) {
							isCharLetter = false;
						} else {
							isCharLetter = true;
						}

						for (int i = 0; i < lettersList.length; i++) {

							if (lettersList[i] == newLetter.charAt(0)) {
								isCharSelectable = true;
							}

						}
					}
				}

				boolean needToModifylettersList = false;
				char letterChar = newLetter.charAt(0);
				int count = 0;

				// compare the letter with the word
				for (int i = 0; i < wordToGuess.length(); i++) {

					if (wordToGuessChars[i] == letterChar) {
						count++;
						if (count == 2) {
							needToModifylettersList = false;
							break;
						}

						hiddenChars[i] = wordInputChars[i];
						wordToGuessChars[i] = '*';
						remainingLettersToGuess--;
					}
				}

				if (count != 2) {
					needToModifylettersList = true;
				}

				if (remainingLettersToGuess < 1) {
					break;
				}

				newHiddenChars = String.valueOf(hiddenChars);

				// modify lettersList if all occurrences of the letter has been guessed
				if (needToModifylettersList) {

					lettersList = ModifyLettersList.getLettersList(lettersList, letterChar);
					numberOfGuesses--;

				} else {

					numberOfGuesses--;

				}

				// case where user wants to guess the whole word
			} else if (guessOptionFirst == 'Y') {
				System.out.print("Enter the complete word: ");
				String guessedComplete = input.nextLine().toUpperCase();
				char[] guessedCompleteChars = guessedComplete.toCharArray();

				// compare guessed word with original input in upperCase
				isGuessedCompleteCorrect = CheckCompleteWord.getResult(guessedCompleteChars, originalWordToGuessChars);

				if (isGuessedCompleteCorrect) {
					;
					break;

				} else {

					numberOfGuesses--;

				}

				// case where user didn't input neither 'Y' nor 'N'
			} else {

				continue;
			}

		}

		// case where user guessed the correct word within 10 guesses
		if (isGuessedCompleteCorrect || remainingLettersToGuess < 1) {

			System.out.println("\n---------------------------------------------------\n");
			System.out.println("Congratulations!!!");
			System.out.println("You guessed the mystery word \"" + wordInput + "\" in " + (11 - numberOfGuesses)
					+ " guess(es).\n");
			System.out.println("Goodbye .....");
			System.out.println("\n---------------------------------------------------\n");

			// case where user didn't guess the correct word after 10 guesses
		} else {

			System.out.println("\n---------------------------------------------------\n");
			System.out
					.println("Uh Oh!!! You haven't guessed the mystery word \"" + wordInput + "\". Please try again!");
			System.out.println("\n---------------------------------------------------\n");
		}

		input.close();
	}
}