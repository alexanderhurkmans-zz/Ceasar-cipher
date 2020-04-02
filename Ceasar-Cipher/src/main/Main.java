package main;

import java.util.Scanner;

public class Main {
	
	public static int findArrayIndex(char[] arrayToSearchIn, char charToFind) {
		int indexInArray = 0;
		
		// Searches trough the array for a specified char and then returns that index
		while (indexInArray < arrayToSearchIn.length) {
			if (charToFind == arrayToSearchIn[indexInArray]) {
				break;
			}
			indexInArray++;
		}
		
		return indexInArray;
	}
	
	public static String encryptString(String inputedWord) {
		String processedWord = "";
		int wordLenght = 0;
		// Used for modulus calculation
		int tempCalculation = 0;
		char alphabet[] = "abcdefghijklmnopqrstuvwxyzåäö".toCharArray();
		wordLenght = inputedWord.length();
		
		for (int i = 0; i < wordLenght; i++) {
			if (Character.isDigit(inputedWord.charAt(i)) || Character.isWhitespace(inputedWord.charAt(i))) {
				processedWord = processedWord + inputedWord.charAt(i);
			} else {
				// If the letter index expands outside of the designated alphabet-array size, modulus will be used
				if (Main.findArrayIndex(alphabet, inputedWord.charAt(i)) + wordLenght + 1 > 29) {
					tempCalculation = (Main.findArrayIndex(alphabet, inputedWord.charAt(i)) + wordLenght) % 29;
					processedWord = processedWord + Character.toString(alphabet[tempCalculation]);
					
				} else {
					processedWord = processedWord + 
							Character.toString(alphabet[Main.findArrayIndex(alphabet, inputedWord.charAt(i)) + 
							                                 wordLenght]);
				}
			}
					
		}
		return processedWord;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Note that it only works with one word at a time for the moment!");
		while (true) {
			// Tries to clear unnecessary Java Memory
			System.gc();
			
			String inputedWord = "";
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Enter the word you want to encrypt: ");
			inputedWord = scanner.nextLine();
			System.out.println(Main.encryptString(inputedWord));
		}
		
	}

}