package edu.gatech;

import static org.junit.Assert.*;

import org.junit.Test;

public class FailureTest {
	
	AverageSentenceLength asl = new AverageSentenceLength();
	String[] testargs = {new String("-d"), new String(".!?"), new String("-l"), 
		new String("3"), new String("input.txt")};
	
	ResponseData args = AverageSentenceLength.parseCommandLine(testargs);


	@Test
	public void testParseValid() {
		assertEquals(args.punctuation,testargs[1]);
		assertEquals(args.minWordLength,Integer.parseInt(testargs[3]));
		assertEquals(args.filename,testargs[4]);
	}
	
	@Test
	public void testParseInvalid() {  // this should test bad inputs for error statements
		assertEquals(args.punctuation,testargs[1]);
		assertEquals(args.minWordLength,Integer.parseInt(testargs[3]));
		assertEquals(args.filename,testargs[4]);
	}
	
	@Test
	public void testCalculations() {  // this should test results from various input files
		assertEquals(args.punctuation,testargs[1]);
		assertEquals(args.minWordLength,Integer.parseInt(testargs[3]));
		assertEquals(args.filename,testargs[4]);
	}

}
