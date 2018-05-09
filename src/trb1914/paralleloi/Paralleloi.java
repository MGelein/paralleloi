package trb1914.paralleloi;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import trb1914.paralleloi.data.Text;

/**
 * Main class for the Paralleloi comparison module
 * @author Mees Gelein
 */
public class Paralleloi {
	
	/** By default encode all files in UTF-8*/
	public static Charset charSet = StandardCharsets.UTF_8;

	/**
	 * Main entry point if you want to compare the files provided by the command line arguments
	 * @param args
	 */
	public static void main(String[] args) {
		for(String file : args) {
			new Text(file);
		}
		//Then run a comparison between all the texts
		Text.compareAll();
	}

}
