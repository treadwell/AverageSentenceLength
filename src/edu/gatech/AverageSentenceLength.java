package edu.gatech;

public class AverageSentenceLength {
	
	// Calculate the average sentence length of a user-supplied 
	// document in .txt format based on user-supplied list of 
	// punctuation and minimum word length.

	public static void main(String[] args) {
		// Declare variables
		
		String filename = null;
		String punctuation = "!?;,.";
		int minWordLength = 3;
		int avgSentenceLength = 0;
		
		// Read command line

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
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
				}
			} else {
				System.out.println("File specified: " + args[i]);
				filename = args[i];
			}
		}
		
		// Return helpful errors. (non-txt, no punctuation...
		
		// Set defaults based on flags
		
		// Read file
		
		// Parse file & run calculations
		
		// Output results
		
		
		System.out.println("Average Sentence Length: " + avgSentenceLength);

	}

}
