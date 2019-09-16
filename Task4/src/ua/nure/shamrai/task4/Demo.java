package ua.nure.shamrai.task4;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Demo {

	private static final InputStream STD_IN = System.in;

	private static final String ENCODING = "Cp1251";


	  public static void main(String[] args) throws FileNotFoundException, IOException {
		  

	        WordContainer wc = new WordContainer();
	        System.out.println("=================== PART1");
	        // set the mock input
	        System.setIn(new ByteArrayInputStream(
	                "abc^Latin^Latn^Cyrl^stop^"
	                        .replace("^", System.lineSeparator()).getBytes(ENCODING)));
	        Part1.main(args);
	        System.setIn(STD_IN);
	        System.out.println("=================== PART2");

	        System.setIn(new ByteArrayInputStream(
	                "asd asdf asd asdf ^asdf 43 asdsf 43 43 434^stop"
	                        .replace("^", System.lineSeparator()).getBytes(ENCODING)));
	        Part2.main(args);
	        System.setIn(STD_IN);
	        System.setIn(new ByteArrayInputStream(
	                "apple ru^apple en^asdf^table ru^table en^stop"
	                        .replace("^", System.lineSeparator()).getBytes(ENCODING)));
	        System.out.println("\n=================== PART3");
	        Part3.main(args);
	        System.setIn(STD_IN);
	        // restore the standard input
	        System.out.println("=================== PART4");
	        Part4.main(args);
	        System.out.println("\n=================== PART5");
	        Part5.main(args);
	        System.setIn(STD_IN);
	    }
	}
