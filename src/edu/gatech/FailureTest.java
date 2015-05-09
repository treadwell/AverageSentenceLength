package edu.gatech;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FailureTest {
	
	AverageSentenceLength asl = new AverageSentenceLength();
	String[] testargs = {new String("-d"), new String(".!?"), new String("-l"), 
		new String("3"), new String("input.txt")};
	String[] badArgs = {new String("-z"), new String(".!?"), new String("-l"), 
			new String("3"), new String("input.txt")};
	
	ResponseData args = AverageSentenceLength.parseCommandLine(testargs);
	//ResponseData args1 = AverageSentenceLength.parseCommandLine(badArgs);


//	@Test
//	public void testParseValid() {
//		assertEquals(args.punctuation,testargs[1]);
//		assertEquals(args.minWordLength,Integer.parseInt(testargs[3]));
//		assertEquals(args.filename,testargs[4]);
//	}
	
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setErr(null);
	}

	@Test
	public void err() {
		AverageSentenceLength.parseCommandLine(badArgs);
		System.out.println(errContent.toString());
	    assertEquals("Error: Invalid command line flag specified.", errContent.toString());
	}
	
//	@Test
//	public void testParseInvalid() {  // this should test bad inputs for error statements
//		assertEquals(args1.punctuation,badArgs[1]);
////		assertEquals(args.minWordLength,Integer.parseInt(testargs[3]));
////		assertEquals(args.filename,testargs[4]);
//	}
	
//	@Test
//	public void testCalculations() {  // this should test results from various input files
//		assertEquals(args.punctuation,testargs[1]);
//		assertEquals(args.minWordLength,Integer.parseInt(testargs[3]));
//		assertEquals(args.filename,testargs[4]);
//	}

}
