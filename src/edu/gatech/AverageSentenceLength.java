package edu.gatech;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AverageSentenceLength {
	
	// Calculate the average sentence length of a user-supplied 
	// document in .txt format based on user-supplied list of 
	// punctuation and minimum word length.
	


	public static void main(String[] args) {
		
		
		// Read command line
		
		ParsedArgs parsedArgs = new ParsedArgs(args);
		
		// Read file
		try {
			
			String text;
			
			Scanner read = new Scanner(new File(parsedArgs.filename));
			text = read.useDelimiter("\\A").next().replaceAll("(\n|\r)", " ");  // finds end of line
			read.close();
						
			ArrayList<Integer> sentenceLengths = new ArrayList<Integer>();

			StringTokenizer st = new StringTokenizer(text, parsedArgs.punctuation);
			
			while (st.hasMoreTokens()) {
				
				String token = st.nextToken();
				
				int numWords = 0;
				
				for (String word : token.split(" "))
					if (word.length() >= parsedArgs.minWordLength)
						numWords ++;
				
				sentenceLengths.add(numWords);
				
//				String oneSentence = st.nextToken();
//				System.out.println(oneSentence);
//				String[] sentenceWords = oneSentence.split(" ");
//				int numWords = sentenceWords.length;
//				System.out.println(numWords);
//				sentenceLengths.add(numWords);
			};
			
//			for (String sentence : text.split(String.format("[%s]", parsedArgs.punctuation))) {
//			//for (String sentence : text.split("[" + parsedArgs.punctuation.toString() + "]")) {
//				Integer wordcount = 0;
//				for (String word : sentence.split("\\s+")) {
//					if (word.length() >= parsedArgs.minWordLength) {
//						wordcount++;
//					}
//				}
//
//				if (wordcount > 0) {
//					sentenceLengths.add(wordcount);
//					System.out.printf("Length: %2d; %s\n", wordcount, sentence);
//				}
//			}

			int sum = 0;
			for (int i : sentenceLengths) {
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
