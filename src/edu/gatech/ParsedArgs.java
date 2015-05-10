package edu.gatech;

public class ParsedArgs {
    
	// Default values
	
	public String filename    = null;
	public String punctuation = "!?.,";
	public int minWordLength  = 3;

    public ParsedArgs(String[] commandLineArgs) {
    	
    	int punctIndex 	= -1;
    	int lengthIndex = -1;

    	for (int i = 0; i < commandLineArgs.length; i++) {
    		if (commandLineArgs[i] == "-d") punctIndex = i + 1;
    		else if (commandLineArgs[i] == "-l") lengthIndex = i + 1;
    	}
    	
    	if (punctIndex != -1)
    		this.punctuation = commandLineArgs[punctIndex];
    	
    	if (lengthIndex != -1)
    		this.minWordLength = Integer.parseInt(commandLineArgs[lengthIndex]);
    	
    	this.filename = commandLineArgs[commandLineArgs.length - 1];
    	   	
    }
    
    public static boolean validate() {
		//not implemented
    	return false;
    	
    }

}
