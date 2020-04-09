package main;

import java.util.Scanner;

public class Main {
	
	static char alphabet[] = "abcdefghijklmnopqrstuvwxyzåäö".toCharArray();

	public static int findArrayIndex(char charToFind) {
		int indexInArray;
		
		// Searches trough the array for a specified char and then returns that index
		for (indexInArray = 0; indexInArray < alphabet.length; indexInArray++) {
			if (charToFind == alphabet[indexInArray]) {
				break;
			}

		}
		
		return indexInArray;
	}
	
	public static String encryptString(String inputedWord, int wordLenght) {
		String processedWord = "";
		// Used for modulus calculation
		int tempCalculation = 0;
		
		for (int i = 0; i < wordLenght; i++) {
			if (Character.isDigit(inputedWord.charAt(i)) || Character.isWhitespace(inputedWord.charAt(i))) {
				processedWord = processedWord + inputedWord.charAt(i);
			} else {
				// If the letter index expands outside of the designated alphabet-array size, modulus will be used
				if (Main.findArrayIndex(inputedWord.charAt(i)) + wordLenght + 1 > 29) {
					tempCalculation = (Main.findArrayIndex(inputedWord.charAt(i)) + wordLenght) % 29;
					processedWord = processedWord + Character.toString(alphabet[tempCalculation]);
					
				} else {
					processedWord = processedWord + 
							Character.toString(alphabet[Main.findArrayIndex(inputedWord.charAt(i)) + 
							                                 wordLenght]);
				}
			}
					
		}
		return processedWord;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String encryptedWord = "";
		while (true) {
			// Tries to clear unnecessary Java Memory
			System.gc();
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the word you want to encrypt: ");
			String inputedWord = scanner.nextLine();
			String[] inputedWordArray = inputedWord.split("\\W+");
			
			for (int i = 0; i < inputedWordArray.length; i++) {
				encryptedWord = encryptedWord + " " + Main.encryptString(inputedWordArray[i].toString(), inputedWordArray[i].length());
			}
			
			System.out.println(encryptedWord.substring(1));
			
		}
		
	}

}