package edu.gatech;

public class ResponseData {
    
	// Default values
	
	public String filename;
	public String punctuation;
	public int minWordLength;

    public ResponseData(String filename, String punctuation, int minWordLength) {
        this.filename = filename;
        this.punctuation = punctuation;
        this.minWordLength = minWordLength;
    }

}
