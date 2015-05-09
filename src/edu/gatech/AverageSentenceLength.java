package edu.gatech;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AverageSentenceLength {
	
	// Calculate the average sentence length of a user-supplied 
	// document in .txt format based on user-supplied list of 
	// punctuation and minimum word length.
	
	public static ResponseData parseCommandLine(String[] args){
		
		//defaults
		
		String filename = null;
		String punctuation = "!?;,.";
		int minWordLength = 3;

		if (args.length < 1) {
			System.err.println("Error: No file specified.");
			System.exit(1);
		}
		for (int i = 0; i < args.length; i++) {
			if (args[i].charAt(0) == '-') {
				if (args[i].length() < 2) {
					System.err
							.println("Error: Invalid command line flag specified.");
					System.exit(1);
				}

				if (args[i].charAt(1) == 'd') {
					System.out.println("Delimiter specified: " + args[++i]);
					punctuation = args[i];
				} else if (args[i].charAt(1) == 'l') {
					System.out.println("Word length specified: " + args[++i]);
					try {
						minWordLength = Integer.parseInt(args[i]);
					} catch (NumberFormatException e) {e.printStackTrace();}
				} else {
					System.err
						.println("Error: Invalid command line flag specified.");
					System.exit(1);
				}
				
			} else {
				System.out.println("File specified: " + args[i]);
				filename = args[i];
			}
		}
		
		ResponseData rd = new ResponseData(filename, punctuation, minWordLength);
		
		return rd;
		
	}

	public static void main(String[] args) {
		
		
		// Read command line
		
		ResponseData rd = parseCommandLine(args);
		
		System.out.println(rd.filename);
		
		// Read file
		try {
			Scanner read = new Scanner(new File(rd.filename));
			
			String text = read.useDelimiter("\\A").next();
			read.close();

			ArrayList<Integer> sentenceLengths = new ArrayList<Integer>();

			for (String sentence : text.split(String.format("[%s]", rd.punctuation))) {
				Integer wordcount = 0;
				for (String word : sentence.split("\\s+")) {
					if (word.length() >= rd.minWordLength) {
						wordcount++;
					}
				}

				if (wordcount > 0) {
					sentenceLengths.add(wordcount);
					System.out.printf("Length: %2d; %s\n", wordcount, sentence);
				}
			}

			Integer sum = 0;
			for (Integer i : sentenceLengths) {
				sum += i;
			}

			System.out.printf(
					"Counted %d sentences with average length of %d words.",
					sentenceLengths.size(), sum / sentenceLengths.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
